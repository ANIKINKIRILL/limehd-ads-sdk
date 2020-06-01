package tv.limehd.adsmodule.interfaces

import androidx.fragment.app.Fragment

interface FragmentState {

    fun onSuccessState(fragment: Fragment)
    fun onErrorState(message: String)

}