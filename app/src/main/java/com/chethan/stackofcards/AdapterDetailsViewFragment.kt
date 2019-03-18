package com.chethan.stackofcards

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class AdapterDetailsViewFragment : Fragment() {
    val drawable = intArrayOf(R.drawable.angry_bird_1,
            R.drawable.angry_bird_2,
            R.drawable.angry_bird_3,
            R.drawable.angry_bird_4,
            R.drawable.angry_bird_5,
            R.drawable.angry_bird_6,
            R.drawable.angry_bird_7,
            R.drawable.angry_bird_8);
    val backgroundColor = arrayOf("#F44336", "#E91e63", "#9C27B0", "#03A9F4", "#00BCD4", "#FFC107", "#FF9800", "#FF5722");

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var imageView = view.findViewById<ImageView>(R.id.imageView)
        val args = arguments
        if (args != null) {
            val position: Int = args.getInt("PageInfo")
            val imageIndex = position % 8;
            imageView.setBackgroundColor(Color.parseColor(backgroundColor[position]));
            imageView.setImageResource(drawable[imageIndex]);
        }
    }

}