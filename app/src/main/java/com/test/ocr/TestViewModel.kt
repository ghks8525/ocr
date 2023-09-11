package com.test.ocr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions

class TestViewModel: ViewModel() {
    val mldText:MutableLiveData<String> = MutableLiveData()
    val mldError:MutableLiveData<String> = MutableLiveData()
//    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

//    val recognizer = TextRecognition.getClient(ChineseTextRecognizerOptions.Builder().build())
//
//    val recognizer = TextRecognition.getClient(DevanagariTextRecognizerOptions.Builder().build())
//
//    val recognizer = TextRecognition.getClient(JapaneseTextRecognizerOptions.Builder().build())
//
    val recognizer = TextRecognition.getClient(KoreanTextRecognizerOptions.Builder().build())

    fun setImage(image: InputImage){
        val result = recognizer.process(image)
        .addOnSuccessListener { visionText ->
            mldText.value = visionText.getText()
        }
        .addOnFailureListener { e ->
            mldError.value = e.message
        }
    }
}