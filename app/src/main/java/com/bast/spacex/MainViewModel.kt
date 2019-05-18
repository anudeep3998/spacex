package com.bast.spacex

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel( private val launchRepository: LaunchRepository ) : ViewModel() {

    private val launches: MutableLiveData<List<LaunchModel>> = MutableLiveData()

    private var job: Job? = null

    fun launches(): LiveData<List<LaunchModel>> = launches

    @UiThread
    fun fetchLaunches() {
        job = CoroutineScope( Dispatchers.IO ).launch {
            val launchesResult = launchRepository.allLaunches()

            withContext( Dispatchers.Main ) {
                launches.value = launchesResult
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        job?.cancel()
    }
}