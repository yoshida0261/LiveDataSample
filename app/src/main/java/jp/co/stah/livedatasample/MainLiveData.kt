package jp.co.stah.livedatasample

import android.util.Log
import androidx.lifecycle.LiveData
class MainLiveData : LiveData<String>(){

    override fun onActive() {
        super.onActive()
        Log.i("aac", "${hasActiveObservers()}")

    }

    override fun onInactive() {
        super.onInactive()
        Log.i("aac", "${hasActiveObservers()}")
    }
}