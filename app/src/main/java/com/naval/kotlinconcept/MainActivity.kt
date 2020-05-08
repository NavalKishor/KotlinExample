package com.naval.kotlinconcept

import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main),HomeFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(data: String) {
        var strAt=if(tvHello.text.contains(data)) "" else "\nYour Are at $data"
        tvHello.setText(getString(R.string.hello_blank_fragment)+strAt)
    }

    fun onClickHello(view: View) {
        view.id
        Toast.makeText(applicationContext,"WelCome To Navigation Arch Flow!! "+tvHello.text.toString(),Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (getTopFragment().onBackPreesed()) {
            return
        }
//        val currentFragment = supportFragmentManager.getCurrentNavigationFragment() //working
//        val currentFragment = getBaseFragment() //working
//        if (currentFragment.onBackPreesed()){ return }
        super.onBackPressed()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val currentFragment = getBaseFragment()
        if (event is KeyEvent) {
            if (currentFragment.onKeyDown(keyCode,event)) {
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
