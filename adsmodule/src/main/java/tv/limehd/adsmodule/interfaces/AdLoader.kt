package tv.limehd.adsmodule.interfaces

import com.my.target.instreamads.InstreamAd

interface AdLoader {

    fun onLoaded(instreamAd: InstreamAd)
    fun onError()
    fun onNoAd()

}