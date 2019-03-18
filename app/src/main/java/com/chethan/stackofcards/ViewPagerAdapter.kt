package com.chethan.stackofcards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.ViewGroup

class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        val mFirstFragment = AdapterDetailsViewFragment();
        val bundle: Bundle = Bundle()
        bundle.putInt("PageInfo", position)
        mFirstFragment.arguments = bundle
        return mFirstFragment;

    }

    override fun getCount(): Int {
        return 8
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

}