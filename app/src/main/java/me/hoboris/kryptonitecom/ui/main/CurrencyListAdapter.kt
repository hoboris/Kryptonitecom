package me.hoboris.kryptonitecom.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.hoboris.kryptonitecom.data.model.CurrencyInfo
import me.hoboris.kryptonitecom.databinding.CurrencyListItemBinding

class CurrencyListAdapter: RecyclerView.Adapter<CurrencyListAdapter.ViewHolder>() {

    var currencyList: List<CurrencyInfo>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CurrencyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        currencyList?.get(position)?.let { tag ->
            holder.bind(tag)
        }
    }

    override fun getItemCount(): Int = currencyList?.size ?: 0

    class ViewHolder(
        private val binding: CurrencyListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(currencyInfo: CurrencyInfo) {
            binding.iconTextview.text = currencyInfo.formattedIcon
            binding.currencyNameTextview.text = currencyInfo.formattedName
            binding.currencySymbolTextview.apply {
                text = currencyInfo.formattedSymbol
                alpha = 0.5f
            }
        }
    }
}
