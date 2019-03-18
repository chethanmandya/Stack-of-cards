package com.chethan.stackofcards

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StackOfCardsFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var viewPager: ViewPagerCustom;


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_view_pager, container, false)
        return mView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewPagerAdapter = ViewPagerAdapter(childFragmentManager)

        viewPager = mView.findViewById<ViewPagerCustom>(R.id.viewPager)
        viewPager.offscreenPageLimit = 4
        viewPager.setScrollDurationFactor(500)
        viewPager.setPageTransformer(true, CardStackLeftTransformer(view.context))
        viewPager.apply {
            adapter = viewPagerAdapter
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })




    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}