package com.test.ocr

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.ocr.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: AppCompatActivity() {
    lateinit var mBinding: ActivitySplashBinding
    // When using Latin script library

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000L)
            Intent(this@SplashActivity, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

    }


}