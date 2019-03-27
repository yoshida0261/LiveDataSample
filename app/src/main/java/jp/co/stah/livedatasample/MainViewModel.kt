package jp.co.stah.livedatasample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    val countUpLiveData = CountUpLiveData()

    private val _ld = MutableLiveData<Int>().apply { value = 0 }

    val livedata: LiveData<Int>
    get() = _ld

    fun countUp(){
        val count = (_ld.value ?:0) + 1
        _ld.value = count

    }



    override fun onCleared() {
        super.onCleared()
        // リソースの解放


    }
}