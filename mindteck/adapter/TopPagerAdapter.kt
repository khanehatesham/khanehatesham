package com.android.mindteck.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.android.mindteck.R

class TopPagerAdapter(
   mContext: Context,
    private var listOfPhotos: List<Int>
) : PagerAdapter() {


    override fun getCount(): Int {
        return listOfPhotos.size
    }

    internal var mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun isViewFromObject(@NonNull view: View, @NonNull `object`: Any): Boolean {
        return view === `object`
    }

    @SuppressLint("CutPasteId")
    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val itemView =
            mLayoutInflater.inflate(R.layout.item_pager_layout, container, false)

        val ivPhoto = itemView.findViewById<ImageView>(R.id.iv_photo)
        ivPhoto.setImageResource(listOfPhotos[position])

        container.addView(itemView)
        itemView.setTag("myview" + position)
        return itemView
    }


    override fun destroyItem(@NonNull container: ViewGroup, position: Int, @NonNull `object`: Any) {
        container.removeView(`object` as ImageView)
    }


    override fun getItemPosition(@NonNull `object`: Any): Int {
        return POSITION_NONE
    }
}