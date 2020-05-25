package com.example.limehdadssdk

import com.my.target.instreamads.InstreamAd

interface AdLoader {

    fun onLoaded(instreamAd: InstreamAd)
    fun onError()
    fun onNoAd()

}