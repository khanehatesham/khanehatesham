package com.android.mindteck.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.android.mindteck.R
import com.android.mindteck.adapter.TopPagerAdapter
import com.android.mindteck.fragment.FragmentA
import com.android.mindteck.fragment.FragmentB
import com.android.mindteck.fragment.FragmentC
import kotlinx.android.synthetic.main.content_activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = ArrayList<Int>()
        list.add(R.drawable.main_banner)
        list.add(R.drawable.baimnner_img_b)
        list.add(R.drawable.bainner_img_c)
        val pagerAdapter = TopPagerAdapter(baseContext, list)
        viewPagerTop.adapter = pagerAdapter
        viewPagerTop.setCurrentItem(0)

        tablayout.setupWithViewPager(viewPagerTop)
        val frag = FragmentA()
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.framelayout, frag, "FragmentA")
        transaction.commit()

        viewPagerTop.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    ;
                    val frag = FragmentA()
                    val manager: FragmentManager = supportFragmentManager
                    val transaction: FragmentTransaction = manager.beginTransaction()
                    transaction.replace(R.id.framelayout, frag, "FragmentA")
                    transaction.commit()
                    // if you want the second page, for example
                } else if (position == 1) {
                    val frag = FragmentB()
                    val manager: FragmentManager = supportFragmentManager
                    val transaction: FragmentTransaction = manager.beginTransaction()
                    transaction.replace(R.id.framelayout, frag, "FragmentB")
                    transaction.commit()
                } else if (position == 2) {
                    val frag = FragmentC()
                    val manager: FragmentManager = supportFragmentManager
                    val transaction: FragmentTransaction = manager.beginTransaction()
                    transaction.replace(R.id.framelayout, frag, "FragmentB")
                    transaction.commit()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
}