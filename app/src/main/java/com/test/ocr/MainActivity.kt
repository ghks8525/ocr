package com.test.ocr

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.ocr.databinding.ActivityMainBinding
import com.test.ocr.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    // When using Latin script library

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.amBtnNext.setOnClickListener {
            Intent(this, InsuranceActivity::class.java).apply {
                startActivity(this)
            }
        }
    }


}