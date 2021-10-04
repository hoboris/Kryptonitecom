package me.hoboris.kryptonitecom

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import me.hoboris.kryptonitecom.databinding.DemoActivityBinding
import me.hoboris.kryptonitecom.ui.main.CurrencyListFragment
import me.hoboris.kryptonitecom.ui.main.CurrencyListViewModel

@AndroidEntryPoint
class DemoActivity : AppCompatActivity() {

    private val viewModel: CurrencyListViewModel by viewModels()
    private lateinit var binding: DemoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DemoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CurrencyListFragment.newInstance())
                .commitNow()
        }

        binding.loadButton.setOnClickListener {
            viewModel.startLoading()
        }

        binding.sortButton.setOnClickListener {
            viewModel.switchSortMode()
        }
    }
}