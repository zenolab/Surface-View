package com.surfaceview_draw.zenolab.surfaceviewdraw

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.android.synthetic.main.app_bar_nav_drawer.*

import com.surfaceview_draw.zenolab.surfaceviewdraw.ui.point.*
import kotlinx.android.synthetic.main.content_nav_drawer.*

class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var soundAdjustment: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        soundAdjustment = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        volumeBar?.calibrateVolumeLevels(
            soundAdjustment.getStreamMaxVolume(AudioManager.STREAM_SYSTEM),
            soundAdjustment.getStreamVolume(AudioManager.STREAM_SYSTEM))
        Handler().postDelayed({
            Toast.makeText(this,"Chose screen on the left ", Toast.LENGTH_LONG).show();
        }, 4800)
        Toast.makeText(this,"Press volume button -/+ ", Toast.LENGTH_SHORT).show();
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_drawer, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var selectedFragment = Fragment()
        when (item.itemId) {
            R.id.nav_draw -> {
                selectedFragment = TouchSurfaceFragment()
                setTitle("Draw")
            }
            R.id.nav_color -> {
                selectedFragment =  ColorSurfaceFragment();
                setTitle("Color");
            }
            R.id.nav_round -> {
                selectedFragment =  RoundTextFragment();
                setTitle("Round");
            }
            R.id.nav_space -> {
                selectedFragment =  SpaceFragment();
                setTitle("Cosmic");
            }
            R.id.nav_grid -> {
                selectedFragment =  BlankFragment();
                setTitle("Grid");


            }R.id.nav_host -> {
                    //Host
            }
        }
        replaceFragment(selectedFragment)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        super.dispatchKeyEvent(event)
        if (event?.keyCode == KeyEvent.KEYCODE_VOLUME_UP ||
            event?.keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            volumeBar.setVolumeLevel(soundAdjustment.getStreamVolume(AudioManager.STREAM_SYSTEM))
        }
        return false
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frag_container, fragment).commit()
    }
    public override fun onResume() {
        super.onResume()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "New drawing", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
                replaceFragment(TouchSurfaceFragment.newInstance());
        }
    }
    public override fun onPause() {
        super.onPause()
    }
}
