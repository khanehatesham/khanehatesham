package com.android.mindteck.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mindteck.R
import com.app.pharmadawa.ui.notification.Fragment_A_Adapter
import kotlinx.android.synthetic.main.fragment_c.view.*

class FragmentC : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_c, container, false);


        val list = ArrayList<String>()
        list.add("Imelda")
        list.add("Faron")
        list.add("Houda Al-Rez")
        list.add("John Wahba")
        list.add("Abdullah Dasnan")
        list.add("Akhilesh")
        list.add("Hasan")
        list.add("Omar")
        list.add("Aadam")
        list.add("Bilal")
        list.add("Hasan")
        list.add("Izabendra")
        list.add("Eliza")
        list.add("Mariam")
        list.add("Nourhan")
        val adapter= Fragment_A_Adapter(context!!,list)

        view. recyclerViewC.layoutManager= LinearLayoutManager(context)
        view. recyclerViewC.itemAnimator= DefaultItemAnimator()
        view.  recyclerViewC.adapter=adapter

        view.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
        return view

    }


}