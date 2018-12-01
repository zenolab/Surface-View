package com.surfaceview_draw.zenolab.surfaceviewdraw.ui.point

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.surfaceview_draw.zenolab.feature.TouchSurfaceView


class TouchSurfaceFragment : Fragment() {

    companion object {
        fun newInstance() = TouchSurfaceFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        Toast.makeText(activity,"Draw something on the screen", Toast.LENGTH_SHORT).show();
        return  TouchSurfaceView(activity)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
