package com.example.limehdadssdk

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.my.target.instreamads.InstreamAd
import com.my.target.instreamads.InstreamAdPlayer

class MyTargetFragment : Fragment() {

    companion object {
        private const val TAG = "myTargetFragment"
    }

    private lateinit var mInstreamAd: InstreamAd
    private lateinit var mInstreamAdPlayer: InstreamAdPlayer

    private lateinit var videoContainer: RelativeLayout
    private lateinit var rootContainer: RelativeLayout

    fun setInstreamAd(instreamAd: InstreamAd){
        mInstreamAd = instreamAd
        mInstreamAd.useDefaultPlayer()
        setListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_instream, container, false)
        rootContainer = rootView.findViewById(R.id.root_container)
        videoContainer = rootView.findViewById(R.id.video_container)
        return rootView
    }

    fun initializePlaying(){
        mInstreamAd.startPreroll()
    }

    private fun setListener() {
        mInstreamAdPlayer = mInstreamAd.player!!
        videoContainer.removeAllViews()
        videoContainer.addView(mInstreamAdPlayer.view)
        mInstreamAd.listener = object : InstreamAd.InstreamAdListener {
            override fun onLoad(p0: InstreamAd) {
                Log.d(TAG, "onLoad called")
            }

            override fun onComplete(p0: String, p1: InstreamAd) {
                Log.d(TAG, "onComplete called")
            }

            override fun onBannerPause(p0: InstreamAd, p1: InstreamAd.InstreamAdBanner) {
                Log.d(TAG, "onBannerPause called")
            }

            override fun onBannerStart(p0: InstreamAd, p1: InstreamAd.InstreamAdBanner) {
                Log.d(TAG, "onBannerStart called")
            }

            override fun onNoAd(p0: String, p1: InstreamAd) {
                Log.d(TAG, "onNoAd called")
            }

            override fun onBannerResume(p0: InstreamAd, p1: InstreamAd.InstreamAdBanner) {
                Log.d(TAG, "onBannerResume called")
            }

            override fun onBannerTimeLeftChange(p0: Float, p1: Float, p2: InstreamAd) {
                Log.d(TAG, "onBannerTimeLeftChange called")
            }

            override fun onError(p0: String, p1: InstreamAd) {
                Log.d(TAG, "onError called")
            }

            override fun onBannerComplete(p0: InstreamAd, p1: InstreamAd.InstreamAdBanner) {
                Log.d(TAG, "onBannerComplete called")
            }

        }
    }

}