package jp.co.stah.livedatasample

import android.app.Application
import android.util.Log
import androidx.lifecycle.*

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()


        val observer = object : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
            fun onAny(source: LifecycleOwner, event: Lifecycle.Event) {
                Log.d("aac", "onAny : ${source.lifecycle.currentState.name} event : ${event.name}")


            }


/*            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate(source: LifecycleOwner) {
                Log.d("aac", "onCreate : ${source.lifecycle.currentState.name}")
            }


            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop(source: LifecycleOwner) {
                Log.d("aac", "onCreate : ${source.lifecycle.currentState.name}")
                source.lifecycle.removeObserver(this)
            }


            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestory(source: LifecycleOwner) {
                Log.d("aac", "onCreate : ${source.lifecycle.currentState.name}")
            }

*/
        }
        //l.addObserver(observer)

        ProcessLifecycleOwner.get()
            .lifecycle
            .addObserver(observer)

    }
}