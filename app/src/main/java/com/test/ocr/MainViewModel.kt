package com.test.ocr

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.googlecode.tesseract.android.TessBaseAPI

class MainViewModel: ViewModel() {
    var mTess: TessBaseAPI = TessBaseAPI() //Tess API reference
    val lang = "kor"
    var txt: LiveData<String> = MutableLiveData()

    init {
        mTess.init(datapath, lang)
    }
    fun getText(image:Bitmap){
        mTess.setImage(image)
        txt.value = mTess.utF8Text
    }
}