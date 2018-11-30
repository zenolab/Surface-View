package com.surfaceview_draw.zenolab.surfaceviewdraw.ui.mainactivity3


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.surfaceview_draw.zenolab.feature.SpaceSurfaceView
import com.surfaceview_draw.zenolab.surfaceviewdraw.R


class SpaceFragment : Fragment() {

    companion object {
        fun newInstance() = TouchSurfaceFragment()
    }

    private var touchSurfaceFragment:SpaceSurfaceView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        touchSurfaceFragment =SpaceSurfaceView(activity);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Toast.makeText(activity,"Surface foreground", Toast.LENGTH_SHORT).show();
        return touchSurfaceFragment;
    }

    public override fun onResume() {
        super.onResume()
        touchSurfaceFragment?.onResumeMySurfaceView()
    }

    public override fun onPause() {
        super.onPause()
        touchSurfaceFragment?.onPauseMySurfaceView()
    }

}


