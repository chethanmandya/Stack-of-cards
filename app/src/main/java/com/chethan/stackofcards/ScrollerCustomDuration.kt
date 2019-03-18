package com.chethan.stackofcards

import android.annotation.SuppressLint
import android.content.Context
import android.view.animation.Interpolator
import android.widget.Scroller

class ScrollerCustomDuration : Scroller {

    private var mScrollFactor = 1.0

    private var durationScrollMillis = 1500

    constructor(context: Context) : super(context) {}

    constructor(context: Context, interpolator: Interpolator) : super(context, interpolator) {}

    @SuppressLint("NewApi")
    constructor(context: Context, interpolator: Interpolator, flywheel: Boolean) : super(context, interpolator, flywheel) {
    }

    /**
     * Set the factor by which the duration will change
     */
    fun setScrollDurationFactor(scrollFactor: Double) {
        mScrollFactor = scrollFactor
    }

    fun setScrollerDuration(durationScrollMillis: Int) {
        this.durationScrollMillis = durationScrollMillis
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
        super.startScroll(startX, startY, dx, dy, durationScrollMillis)
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, durationScrollMillis)
    }

}