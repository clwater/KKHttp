package com.clwater.kkhttp

import java.io.IOException

/**
 * Created by gengzhibo on 2017/10/31.
 */
interface KKCallback{
    fun onSuceess(body: String?)
    fun onFailure(e : IOException)
}