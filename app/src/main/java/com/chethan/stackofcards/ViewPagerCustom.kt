package com.chethan.stackofcards

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.DecelerateInterpolator

import java.lang.reflect.Field

class ViewPagerCustom : ViewPager {

    private var mScroller: ScrollerCustomDuration? = null
    var pagingStatus = true
        private set

    constructor(context: Context) : super(context) {
        postInitViewPager()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        postInitViewPager()
    }

    /**
     * Override the Scroller instance with our own class so we can change the
     * duration
     */
    private fun postInitViewPager() {
        try {
            val scroller = ViewPager::class.java.getDeclaredField("mScroller")
            scroller.isAccessible = true
            mScroller = ScrollerCustomDuration(context,
                    DecelerateInterpolator())
            scroller.set(this, mScroller)
        } catch (e: Exception) {
        }

    }

    // Call this method in your motion events when you want to disable or enable
    fun setPagingEnabled(swipeable: Boolean) {
        this.pagingStatus = swipeable
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return this.pagingStatus && super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return this.pagingStatus && super.onTouchEvent(event)
    }

    /**
     * Set the factor by which the duration will change
     */
    fun setScrollDurationFactor(duration: Int) {
        mScroller!!.setScrollerDuration(duration)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mScroller = null
    }
}