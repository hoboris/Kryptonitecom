package me.hoboris.kryptonitecom.ui.main

import android.view.View
import android.widget.ImageView
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.lifecycle.HiltViewModel
import me.hoboris.kryptonitecom.data.local.RoomDataSource
import me.hoboris.kryptonitecom.data.local.SortMode
import me.hoboris.kryptonitecom.data.model.CurrencyInfo
import javax.inject.Inject


@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val localDataSource: RoomDataSource
) : ViewModel() {

    private val _loadingStatus: MutableLiveData<LoadingStatus> = MutableLiveData(LoadingStatus.NOT_LOADED)
    val loadingStatus: LiveData<LoadingStatus> by lazy { _loadingStatus }

    private val _sortMode: MutableLiveData<SortMode> = MutableLiveData(SortMode.ASCENDANT)
    val sortMode: LiveData<SortMode> by lazy { _sortMode }

    val currencyList: LiveData<List<CurrencyInfo>> = sortMode.switchMap { sortMode ->
        localDataSource
            .getAllCurrencyInfo(sortMode)
            .asLiveData()
    }

    enum class LoadingStatus {
        NOT_LOADED,
        LOADING,
        LOADED;
    }

    fun startLoading() {
        _loadingStatus.value = LoadingStatus.LOADING
    }

    fun finishedLoading() {
        _loadingStatus.value = LoadingStatus.LOADED
    }

    fun switchSortMode() {
        _sortMode.value = sortMode.value?.next
    }

    fun updateIconAnimation(icon: ImageView, loadingStatus: LoadingStatus) {
        when (loadingStatus) {
            LoadingStatus.NOT_LOADED -> {
                icon.alpha = 0.2f
                icon.visibility = View.VISIBLE
            }
            LoadingStatus.LOADING -> { }
            LoadingStatus.LOADED -> icon.visibility = View.INVISIBLE
        }
    }

    fun updateCurrencyListVisibility(
        currencyListRecyclerview: RecyclerView,
        loadingStatus: LoadingStatus
    ) {
        when (loadingStatus) {
            LoadingStatus.NOT_LOADED -> currencyListRecyclerview.visibility = View.INVISIBLE
            LoadingStatus.LOADING -> { }
            LoadingStatus.LOADED -> currencyListRecyclerview.visibility = View.VISIBLE
        }
    }
}

val CurrencyInfo.formattedName
    get() = name.replaceFirstChar { it.uppercase() }

val CurrencyInfo.formattedIcon
    get() = name.first().uppercase()

val CurrencyInfo.formattedSymbol
    get() = symbol.uppercase()