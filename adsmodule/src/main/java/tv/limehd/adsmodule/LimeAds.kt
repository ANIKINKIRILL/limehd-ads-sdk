package tv.limehd.adsmodule

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
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
    private lateinit var fragmentState: FragmentState

    fun setFragmentState(fragmentState: FragmentState){
        this.fragmentState = fragmentState
    }

    /**
     * Получить рекламу от площадки myTarget
     *
     * @param context     Context приложения
     * @param resId       Id контейнера, куда нужно будет поместить фрагмент
     */

    fun getMyTargetAd(context: Context, resId: Int) {
        val myTargetLoader = MyTargetLoader(context)
        val activity = context as FragmentActivity
        val fragmentManager = activity.supportFragmentManager
        fragmentManager.beginTransaction().replace(resId, myTargetFragment).commit()
        myTargetLoader.loadAd()
        myTargetLoader.setAdLoader(object : AdLoader {
            override fun onLoaded(instreamAd: InstreamAd) {
                myTargetFragment.setInstreamAd(instreamAd)
                myTargetFragment.initializePlaying()
                fragmentState.onSuccessState(myTargetFragment)
            }

            override fun onError() {
                TODO("Not yet implemented")
            }

            override fun onNoAd() {
                Log.d(TAG, "onNoAd called")
                fragmentState.onErrorState("NoAd")
                fragmentManager.beginTransaction().remove(myTargetFragment).commit()
            }
        })
    }
}

