package me.okawa.androidexperiment.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.okawa.androidexperiment.model.Launch
import me.okawa.androidexperiment.model.mapToPresentation
import me.okawa.core.base.BaseViewModel
import me.okawa.domain.usecase.LaunchesUseCase

class MainViewModel(private val launchesUseCase: LaunchesUseCase) : BaseViewModel() {

    private val _launches = MutableLiveData<List<Launch>>()
    val launches: LiveData<List<Launch>> = _launches

    fun loadData() {
        launchesUseCase.retrieveLaunches()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { rocketModels -> rocketModels.map { it.mapToPresentation() } }
            .subscribe(
                ::onLaunchesSuccess,
                ::onLaunchesError
            )
            .addToDisposable()
    }

    private fun onLaunchesSuccess(launches: List<Launch>) {
        _launches.postValue(launches)
    }

    private fun onLaunchesError(throwable: Throwable) {

    }

}