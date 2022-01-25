package com.example.tms_homework19

import androidx.lifecycle.*
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.URL
import java.util.*


class AkamaiViewModel : ViewModel() {

    val time = MutableLiveData<String>()
    private val scope = CoroutineScope(Dispatchers.Main)

    fun syncTime() {
        scope.launch {
            time.value = "loading..."
            time.value = withContext(Dispatchers.IO) {
                try {
                    URL("https://time.akamai.com/").readText()

                } catch (e: Exception) {
                    "error"
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

}