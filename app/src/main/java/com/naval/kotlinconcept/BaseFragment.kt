package com.naval.kotlinconcept


import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * A simple [Fragment] subclass.
 */
open class BaseFragment : Fragment {

    constructor():super()
     constructor( contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    open fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        Log.i("TAG", "BaseFragment->onKeyDown: ")
        return false
    }

    open fun onBackPreesed():Boolean{
        Log.i("TAG",Thread.currentThread().getStackTrace()[2].className)
        return false
    }
}
//Extension function
fun FragmentManager.getCurrentNavigationFragment(): Fragment? =
    primaryNavigationFragment?.childFragmentManager?.fragments?.first()

fun AppCompatActivity.getBaseFragment(): BaseFragment {
    val currentFragment= supportFragmentManager.getCurrentNavigationFragment()
    if (currentFragment is BaseFragment) {return currentFragment}
    else {return currentFragment as BaseFragment}
}
fun AppCompatActivity.getTopFragment(): BaseFragment= supportFragmentManager.getTopFragment() as BaseFragment

fun FragmentManager.getTopFragment():BaseFragment = getCurrentNavigationFragment() as BaseFragment

