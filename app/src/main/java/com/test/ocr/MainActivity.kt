package com.test.ocr

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.WorkerThread
import androidx.databinding.DataBindingUtil
import com.googlecode.tesseract.android.TessBaseAPI
import com.test.ocr.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    lateinit var image: Bitmap
    
    val viewModel: MainViewModel by viewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        image = BitmapFactory.decodeResource(resources, R.drawable.test)

        viewModel.mldText.observe(this){ txt ->
            mBinding.text.text = txt 
        }
        viewModel.getText(image)
        
    }


}