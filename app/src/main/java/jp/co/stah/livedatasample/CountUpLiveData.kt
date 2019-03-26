package jp.co.stah.livedatasample

import android.os.Handler
import androidx.lifecycle.LiveData

class CountUpLiveData : LiveData<Int>() {

    private var count = 0
    private var handler = Handler()
    private var r = Runnable {
        count++
        value = count
        next()
    }

    private fun next(){
        handler.postDelayed(r, 1000)

    }

    override fun onActive() {
        //super.onActive()
        next()
    }
    

}