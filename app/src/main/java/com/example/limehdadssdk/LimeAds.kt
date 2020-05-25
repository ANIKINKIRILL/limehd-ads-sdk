package com.example.limehdadssdk

import android.content.Context
import com.my.target.instreamads.InstreamAd
import org.json.JSONObject

/**
 * Класс для работы с рекламой
 *
 * @param context   Context приложения
 * @param json      Json, который даёт сервер. Со всеми необходимыми объектами
 */

class LimeAds constructor(private val context: Context, private val json: JSONObject) {

    private var myTargetFragment = MyTargetFragment()

    /**
     * Получить рекламу от площадки myTarget
     *
     * @param context     Context приложения
     */

    private fun getMyTargetAd(context: Context){
        val myTargetLoader = MyTargetLoader(context)
        myTargetLoader.loadAd()
        myTargetLoader.setAdLoader(object : AdLoader {
            override fun onLoaded(instreamAd: InstreamAd) {
                myTargetFragment.setInstreamAd(instreamAd)
            }

            override fun onError() {
                TODO("Not yet implemented")
            }

            override fun onNoAd() {
                TODO("Not yet implemented")
            }
        })
    }

    /**
     * Функция возвращает готовый фрагмент с рекломой от myTarget
     */

    fun getMyTargetAdFragment() : MyTargetFragment {
        return myTargetFragment
    }

}

