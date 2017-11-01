package com.clwater.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.clwater.kkhttp.KKCallback
import com.clwater.kkhttp.KKHttp
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val Tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        val mainInfo = findViewById<TextView>(R.id.mainInfo)
//        mainInfo.text = KKHttp.init(123 , 666).toString()

        KKHttp.get("http://www.gengzhibo.com/" , object : KKCallback{
            override fun onFailure(e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSuceess(body: String?) {
                Log.d(Tag , body)
            }

        })
    }
}
