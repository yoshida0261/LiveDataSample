package jp.co.stah.livedatasample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val l = lifecycle

        println("onCreate : ${l.currentState.name}")

        val toggleLD = MainLiveData()
        val toggle = findViewById<ToggleButton>(R.id.toggleButton)
        toggle.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                toggleLD.observe(this, Observer {
                    Log.i("aac", it)
                })
            }else{
                toggleLD.removeObservers(this)
            }

        }

        val livedata = MutableLiveData<String>()
        //val livedata = MainLiveData()
        livedata.observe(this, Observer {
            Log.i("aac", it)
        })

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            //livedata.value = "a"
            //livedata.postValue("a")
            //livedata.postValue("b")
            //livedata.value = "b"
        }


        val observer = object : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate(source: LifecycleOwner) {
                println("onCreate : ${l.currentState.name}")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
            fun onAny(source: LifecycleOwner, event: Lifecycle.Event) {
                println("onCreate onAny : ${l.currentState.name}")

            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop(source: LifecycleOwner) {
                println("onCreate : ${l.currentState.name}")
                source.lifecycle.removeObserver(this)
            }


            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestory(source: LifecycleOwner) {
                println("onCreate onAny : ${l.currentState.name}")
            }


        }
        l.addObserver(observer)
    }
}
