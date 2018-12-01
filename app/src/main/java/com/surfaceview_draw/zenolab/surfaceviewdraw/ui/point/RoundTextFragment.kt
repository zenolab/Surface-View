package com.surfaceview_draw.zenolab.surfaceviewdraw.ui.point


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.surfaceview_draw.zenolab.feature.RoundDrawView


class RoundTextFragment : Fragment() {

    private var roundDrawView:RoundDrawView? = null;
    companion object {
        fun newInstance() = TouchSurfaceFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roundDrawView = RoundDrawView(activity);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(activity,"Custom View", Toast.LENGTH_SHORT).show();
       return roundDrawView
    }


}
