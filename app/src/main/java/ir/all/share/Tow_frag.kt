package ir.all.share

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.all.myapplication.R

class Tow_frag : androidx.fragment.app.Fragment() {

    private lateinit var layoutInflate: LayoutInflater
    private lateinit var rootView: View
    private lateinit var viewPager: androidx.viewpager.widget.ViewPager
    private lateinit var tbl: TabLayout
    private var arrayPg = arrayOf( PorBinandetarin(), PorBinandetarin(),Page_tazeha_frag())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutInflate = LayoutInflater.from(container!!.context)
        rootView = layoutInflate.inflate(R.layout.fragment_tow_frag, container, false)


        viewPager = rootView.findViewById(R.id.vp)
        tbl = rootView.findViewById(R.id.tbl)

        viewPager.adapter = SetPagerFragment(fragmentManager)
        tbl.setupWithViewPager(viewPager)
        viewPager.setCurrentItem(arrayPg.size - 1)
        return rootView
    }

    inner class SetPagerFragment(fm: androidx.fragment.app.FragmentManager?) : androidx.fragment.app.FragmentPagerAdapter(fm) {
        override fun getItem(p0: Int) = arrayPg[p0]
        override fun getCount() = arrayPg.size
        override fun getPageTitle(position: Int): CharSequence? {
            var array = arrayOf("پربحث ترین", "پربازدیدترین", "تازه ترین")
            return array[position]
        }
    }

}
