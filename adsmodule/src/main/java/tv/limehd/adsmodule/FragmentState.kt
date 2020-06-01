package tv.limehd.adsmodule

import androidx.fragment.app.Fragment

interface FragmentState {

    fun onSuccessState(fragment: Fragment)
    fun onErrorState(message: String)

}