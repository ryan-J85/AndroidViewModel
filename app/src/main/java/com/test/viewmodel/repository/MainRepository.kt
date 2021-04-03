package com.test.viewmodel.repository

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainRepository {
    companion object {
        lateinit var mInstance: MainRepository
        fun prepare() {
            mInstance =
                MainRepository()
        }
        fun release() {
        }

        fun getInstance() : MainRepository {
            return mInstance
        }
    }

    var mCount:Int = 0
    val mItem = MutableLiveData<String>()

    fun fetchData(data:Int) {
        // Call Core Function
        // Update Data
        mItem.value = "Repository Send data=${data}"
    }

    fun observer(owner:LifecycleOwner, observer:Observer<String>) {
        mItem.observe(owner, observer)
    }

}