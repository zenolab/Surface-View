package com.surfaceview_draw.zenolab.surfaceviewdraw.ui.mainactivity3


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.surfaceview_draw.zenolab.feature.SimpleSurface
import com.surfaceview_draw.zenolab.surfaceviewdraw.R


class ColorSurfaceFragment : Fragment() {

    companion object {
        fun newInstance() = TouchSurfaceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Toast.makeText(activity,"Just set color in SurfaceView", Toast.LENGTH_SHORT).show();
       // return TextView(activity).apply { setText(R.string.hello_blank_fragment)}
        return SimpleSurface(activity)

    }
}



