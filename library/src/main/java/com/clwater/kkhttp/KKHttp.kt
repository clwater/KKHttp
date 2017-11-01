package com.clwater.kkhttp

import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Created by gengzhibo on 2017/10/31.
 */

object KKHttp {
    val TAG = "KKHttp"
    //构建okHttpClient
    private val okHttpClient = OkHttpClient.Builder()
            .connectTimeout((20 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .readTimeout((20 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .build()

    fun get(url : String , kkCallback: KKCallback){
        val request = Request.Builder().url(url).build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: Call?, e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                kkCallback.onFailure(e)
            }

            override fun onResponse(call: Call?, response: Response) {
                kkCallback.onSuceess(response.body()?.string())
            }

        })
    }

}
