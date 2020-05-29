package tv.limehd.adsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import tv.limehd.adsmodule.LimeAds

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val limeAds = LimeAds(this, JSONObject())
        limeAds.getMyTargetAd(this)
        val fragment = limeAds.getMyTargetAdFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
    }
}
