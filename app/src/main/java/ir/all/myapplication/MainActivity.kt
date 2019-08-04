package ir.all.myapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.*
import android.widget.Button
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.RelativeLayout
import com.tiagosantos.enchantedviewpager.EnchantedViewPager

import ir.all.share.Tow_frag
import ir.all.slider.AlbumArt
import ir.all.slider.EnchantedPagerAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var btnNavigation: Button

    private lateinit var hrz: HorizontalScrollView
    private lateinit var hrz2: HorizontalScrollView
    private lateinit var hrz3: HorizontalScrollView

    /* private lateinit var typeface1: Typeface
     private lateinit var typeface2: Typeface*/

    private lateinit var rls: RelativeLayout
    private lateinit var frm: FrameLayout


    private lateinit var inflater: LayoutInflater
    private lateinit var rootView: View
    private lateinit var viewPager: EnchantedViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        typeface1 = Typeface.createFromAsset(assets , "fonts/iranbold.ttf")
//        typeface2 = Typeface.createFromAsset(assets , "fonts/DroidNaskh-Regular.ttf")

        viewPager = findViewById(R.id.view_pagertop)
        viewPager.adapter = EnchantedPagerAdapter(this,createAlbumList())
        viewPager.setCurrentItem(5)
        viewPager.useScale()
        viewPager.removeAlpha();


        rls = findViewById(R.id.lsiasi)
        frm = findViewById(R.id.frm2)
        rls.setOnClickListener({
            frm.visibility = View.GONE
            var f = Tow_frag()
            supportFragmentManager.beginTransaction().replace(R.id.frm, f)
                .commit()
        })

        btnNavigation = findViewById(R.id.btnNav)
        hrz = findViewById(R.id.hrz_scroll)
        hrz2 = findViewById(R.id.hrz2_scroll)
        hrz3 = findViewById(R.id.hrz3_scroll)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        btnNavigation.setOnClickListener({
            drawerLayout.openDrawer(Gravity.RIGHT)

        })

        hrz.post({
            hrz.fullScroll(View.FOCUS_RIGHT)
            hrz2.fullScroll(View.FOCUS_RIGHT)
            hrz3.fullScroll(View.FOCUS_RIGHT)
        })


    }


    override fun onBackPressed() {
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(Gravity.RIGHT)
        return true
    }

    private fun createAlbumList(): ArrayList<AlbumArt> {
        val albumList = ArrayList<AlbumArt>()

        for (i in 0..9) {
            albumList.add(AlbumArt(getAlbumArtReference(i)))
        }
        return albumList
    }

    private fun getAlbumArtReference(position: Int): Int {
        if (position == 0) {
            return R.drawable.album_art_1
        } else if (position == 1) {
            return R.drawable.album_art_2
        } else if (position == 2) {
            return R.drawable.album_art_3
        } else if (position == 3) {
            return R.drawable.album_art_4
        } else if (position == 4) {
            return R.drawable.album_art_5
        } else if (position == 5) {
            return R.drawable.album_art_6
        } else if (position == 6) {
            return R.drawable.album_art_7
        } else if (position == 7) {
            return R.drawable.album_art_8
        } else if (position == 8) {
            return R.drawable.album_art_9
        } else if (position == 9) {
            return R.drawable.album_art_10
        }

        return R.drawable.album_art_1
    }

}
