package com.test.ocr

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.mlkit.vision.common.InputImage
import com.test.ocr.databinding.ActivityMainBinding

class TestActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    lateinit var image: Bitmap
    private lateinit var viewModel:TestViewModel
    // When using Latin script library

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        image = BitmapFactory.decodeResource(resources, R.drawable.test)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(TestViewModel::class.java)

//        viewModel.mldText.observe(this){ txt ->
//            mBinding.text.text = txt
//            Log.e(txt, "e")
//        }

        viewModel.mldError.observe(this){ err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
        }

        viewModel.setImage(InputImage.fromBitmap(image, 0))

    }


}