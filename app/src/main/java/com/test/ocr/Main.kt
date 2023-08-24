package com.test.ocr

import android.graphics.Bitmap
import com.googlecode.tesseract.android.TessBaseAPI
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream


var datapath = "C:\\tessdata" //언어데이터가 있는 경로
fun main() {
    System.out.println("test")

    var image = File("C:\\test.png")

    var mTess: TessBaseAPI //Tess API reference


    val lang = "kor"
    try {

        mTess = TessBaseAPI()
        mTess.init(datapath, lang)

        var OCRresult: String? = null
        mTess.setImage(image)
        OCRresult = mTess.utF8Text
    } catch (e: Exception) {
        e.stackTrace
    }

}

/***
 * 이미지에서 텍스트 읽기
 */

/***
 * 언어 데이터 파일, 디바이스에 복사
 */