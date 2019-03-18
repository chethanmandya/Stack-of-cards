package com.chethan.stackofcards

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.RelativeLayout

class FragmentActivityViewPager : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity_view_pager)
        loadFragment()
    }

    private fun loadFragment() {
        var fragmentContainer = findViewById<RelativeLayout>(R.id.fragmentContainer)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, StackOfCardsFragment(), "screenSlidePageFragment").commit()

    }
}
