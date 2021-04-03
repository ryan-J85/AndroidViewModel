package com.test.viewmodel.ui.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.test.viewmodel.repository.MainRepository

class MainViewModel : ViewModel() {
    val mItem = MutableLiveData<String>()

    // ViewModel
    fun connectViewModelObserver(owner:LifecycleOwner, observer: Observer<String>) {
        mItem.observe(owner, observer)
    }

    // Repository
    fun connectRepositoryObserver(owner:LifecycleOwner) {
        MainRepository.mInstance.observer(owner, Observer<String> {
            updateRepositoryData(it)
        })
    }

    // Update Repostory
    fun updateRepositoryData(data:String) {
        mItem.value = data
    }

    // Get Data
    fun getItem() : String? {
        return mItem.value
    }
}