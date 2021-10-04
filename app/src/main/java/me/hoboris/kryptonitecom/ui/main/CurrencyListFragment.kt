package me.hoboris.kryptonitecom.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.hoboris.kryptonitecom.data.model.CurrencyInfo
import me.hoboris.kryptonitecom.databinding.CurrencyListFragmentBinding

@AndroidEntryPoint
class CurrencyListFragment : Fragment() {

    companion object {
        fun newInstance() = CurrencyListFragment()
    }

    private val viewModel: CurrencyListViewModel by activityViewModels()
    private lateinit var binding: CurrencyListFragmentBinding
    private var adapter: CurrencyListAdapter?
        get() = binding.currencyListRecyclerview.adapter as? CurrencyListAdapter
        set(value) {
            binding.currencyListRecyclerview.adapter = value
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CurrencyListFragmentBinding.inflate(inflater, container, false)

        binding.currencyListRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = CurrencyListAdapter()
        }

        observeLoadingStatus()

        return binding.root
    }

    private fun observeLoadingStatus() {
        val loadingStatusObserver: (CurrencyListViewModel.LoadingStatus) -> Unit = { loadingStatus ->
            binding.apply {
                viewModel.updateIconAnimation(iconImageview, loadingStatus)
                viewModel.updateCurrencyListVisibility(currencyListRecyclerview, loadingStatus)
            }
            if (loadingStatus == CurrencyListViewModel.LoadingStatus.LOADING) {
                observeCurrencyList()
            }
        }
        viewModel.loadingStatus.observe(viewLifecycleOwner, loadingStatusObserver)
    }

    private fun observeCurrencyList() {
        adapter?.reset()
        val currencyListObserver: (List<CurrencyInfo>) -> Unit = { currencyList ->
            adapter?.updateWith(currencyList)
            viewModel.finishedLoading()
        }
        viewModel.currencyList.observe(viewLifecycleOwner, currencyListObserver)
    }
}

@SuppressLint("NotifyDataSetChanged")
fun CurrencyListAdapter.reset() {
    currencyList = null
    notifyDataSetChanged()
}

@SuppressLint("NotifyDataSetChanged")
fun CurrencyListAdapter.updateWith(currencyList: List<CurrencyInfo>) {
    this.currencyList = currencyList
    notifyDataSetChanged()
}