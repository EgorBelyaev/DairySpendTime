package com.example.diarytimespent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        replaceFlagment(HomeFragment.newInstance(),true)
    }

    fun replaceFlagment(fragment: Fragment,istransition:Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition
        }

        fragmentTransition.replace(R.id.textView,fragment).addToBackStack(fragment.javaClass.simpleName)
    }
}