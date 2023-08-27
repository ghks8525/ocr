package com.test.ocr

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.googlecode.tesseract.android.TessBaseAPI

class MainViewModel: ViewModel() {
    val mldText:MutableLiveData<String> = MutableLiveData()
    val mldError:MutableLiveData<String> = MutableLiveData()
    // When using Latin script library
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

// When using Chinese script library
    val recognizer = TextRecognition.getClient(ChineseTextRecognizerOptions.Builder().build())

// When using Devanagari script library
    val recognizer = TextRecognition.getClient(DevanagariTextRecognizerOptions.Builder().build())

// When using Japanese script library
    val recognizer = TextRecognition.getClient(JapaneseTextRecognizerOptions.Builder().build())

// When using Korean script library
    val recognizer = TextRecognition.getClient(KoreanTextRecognizerOptions.Builder().build())

    fun setImage(image:Image){
        val result = recognizer.process(image)
        .addOnSuccessListener { visionText ->
            // Task completed successfully
            // ...
            mldText.value = visionText.getText()
        }
        .addOnFailureListener { e ->
            // Task failed with an exception
            // ...
        }
    }
}