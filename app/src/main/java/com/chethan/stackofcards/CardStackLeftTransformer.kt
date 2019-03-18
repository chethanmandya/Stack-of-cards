package com.chethan.stackofcards

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.View



class CardStackLeftTransformer(private val mContext: Context) : ViewPager.PageTransformer {
    var mStackedScaleFactor: Float = 0.toFloat()
    var mShiftPixels: Float = 0.toFloat()

    init {
        init()
    }

    private fun init() {
        mStackedScaleFactor = 0.02f//(CURRENT_PAGE_SCALE - TOP_STACKED_SCALE) / NUMBER_OF_VISIBLE_STACKCARDS;;// 0.02f;
        mShiftPixels = 30f//TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 12, mContext.getResources().getDisplayMetrics());
    }

    override fun transformPage(view: View, position: Float) {
        val width = getWidth(view)

        /**
         * Scale all the pages from 0 to n
         */
        scaleAllPages(view, position)

        /**
         * Apply translation on X axis for shifting the cards and make them a stack
         * Apply translation on Y axis for shifting the cards so that it gives a hint of depth
         */
        if (position > 0) {
            view.translationX = -position * width

            view.translationY = position * mShiftPixels // shift the page up with 30 pixels

        } else if (position == -1f)
        // Once the page goes to the left side
        {
            // translate x so that we can see the margin of the page as a hint : 14 percent of the page
            view.translationX = width - width * TRANSLATE_X_FACTOR

            val scale = CURRENT_PAGE_SCALE + position * mStackedScaleFactor

            view.scaleX = scale

            view.scaleY = scale

        } else if (position < 0 && position > -1) {
            val scale = CURRENT_PAGE_SCALE + position * mStackedScaleFactor
            // apply translation x as 0 to display it on the screen
            view.translationX = 0f

            view.scaleX = scale

            view.scaleY = scale
        }
        /**
         * Apply translation when the page is translated from left to right
         */
        /**
         * Apply translation on the page to show the hint of next page
         * 14 percent of the page translation
         */

        // We do not want to show all the cards in the stack
        // Show only 2 cards below the main visible card
        showOnlyFewCardsAndHideOthers(view, position, NUMBER_OF_VISIBLE_STACKCARDS - 1)

    }

    /**
     * Scales all pages from position 0 to n (only pages with position >=0)
     * Scale on X and Scale on Y will depend on the position of the card
     *
     * @param page
     * @param position
     */
    private fun scaleAllPages(page: View, position: Float) {
        if (position >= 0) {
            val scale = CURRENT_PAGE_SCALE - position * mStackedScaleFactor

            page.scaleX = scale

            page.scaleY = scale
        }
    }

    /*
    this method will be used for showing limited number of cards at a time in the stack
    The number of cards shown will be determined by parameter - int number
     */
    private fun showOnlyFewCardsAndHideOthers(page: View, position: Float, number: Int) {
        // handling alpha
        if (position > number) {
            page.alpha = 0f
        } else {
            page.alpha = 1f
        }
    }

    protected fun getWidth(page: View): Int {
        return page.width
    }

    companion object {
        private val NUMBER_OF_VISIBLE_STACKCARDS = 5
        val CURRENT_PAGE_SCALE = 0.91f
        val TRANSLATE_X_FACTOR = .90f
    }

}