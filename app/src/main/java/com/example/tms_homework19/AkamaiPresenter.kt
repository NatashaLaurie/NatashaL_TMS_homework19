package com.example.tms_homework19

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.URL
import java.util.*

interface AkamaiView {
    fun setTime(time: String)
}

class AkamaiPresenter : LifecycleEventObserver {

    var view: AkamaiView? = null
    private var time: String = ""
        set(value) {
            field=value
            view?.setTime(time)
        }
    private val scope = CoroutineScope(Dispatchers.Main)

    fun syncTime() {
        scope.launch {
            time = "loading..."
            time = withContext(Dispatchers.IO) {
                try {
                    URL("https://time.akamai.com/").readText()

                } catch (e: Exception) {
                    "error"
                }
            }

            view?.setTime(time = time)
        }
    }

    fun onDestroy() {
        scope.cancel()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_RESUME) {
            view?.setTime(time)
        }
    }
}