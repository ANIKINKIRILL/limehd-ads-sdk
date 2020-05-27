package com.example.limehdadssdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val limeAds = LimeAds(this, JSONObject(Constants.json))
        val myTargetFragment = limeAds.getMyTargetAd(this)
        if(myTargetFragment != null){
            // Реклама нашлась. Показываем на UI
            Log.d(TAG, "Реклама нашлась. Отображаем её на UI")
            supportFragmentManager.beginTransaction().replace(R.id.main_container, myTargetFragment).commit()
        }else{
            // Рекламы нет
            Log.d(TAG, "Рекламы нет")
            Toast.makeText(this, "Реклама не нашлось. Сейчас поищу на след. площадке", Toast.LENGTH_LONG).show()
        }
    }
}
