package com.example.tms_homework19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.URL
import java.text.DateFormat
import java.util.*

class AkamaiActivity : AppCompatActivity(), AkamaiView {

    private lateinit var timeTextView: TextView
    private lateinit var presenter: AkamaiPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akamai)

        presenter = if (savedInstanceState==null) {
            AkamaiPresenter()
        } else {
            lastCustomNonConfigurationInstance as AkamaiPresenter
        }

        timeTextView = findViewById(R.id.time)

        presenter.view = this

        findViewById<Button>(R.id.syncTime).setOnClickListener() {
            presenter.syncTime()

        }
        lifecycle.addObserver(presenter)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isFinishing) {
            presenter.onDestroy()
        }
        presenter.view = null
    }

    override fun setTime(time: String) {
        timeTextView.text = time
    }
}
