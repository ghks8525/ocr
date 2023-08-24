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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        System.out.println("test")

        var image = BitmapFactory.decodeResource(resources, R.drawable.test)

        val lang = "kor"

    }

    @WorkerThread
    fun getText(image:Bitmap){
        mTess.setImage(image)
        mBinding.text.text = mTess.utF8Text;
    }

}