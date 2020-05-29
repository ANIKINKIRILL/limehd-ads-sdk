package tv.limehd.adsmodule

import android.content.Context
import android.util.Log
import com.my.target.instreamads.InstreamAd
import org.json.JSONObject

/**
 * Класс для работы с рекламой
 *
 * @param context   Context приложения
 * @param json      Json, который даёт сервер. Со всеми необходимыми объектами
 */

class LimeAds constructor(private val context: Context, private val json: JSONObject) {

    companion object {
        private const val TAG = "LimeAds"
    }

    private var myTargetFragment = MyTargetFragment()

    /**
     * Получить рекламу от площадки myTarget
     *
     * @param context     Context приложения
     */

    fun getMyTargetAd(context: Context){
        val myTargetLoader = MyTargetLoader(context)
        myTargetLoader.loadAd()
        myTargetLoader.setAdLoader(object : AdLoader {
            override fun onLoaded(instreamAd: InstreamAd) {
                myTargetFragment.setInstreamAd(instreamAd)
                myTargetFragment.initializePlaying()
            }

            override fun onError() {
                TODO("Not yet implemented")
            }

            override fun onNoAd() {
                Log.d(TAG, "onNoAd called")
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

