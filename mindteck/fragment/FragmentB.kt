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
import kotlinx.android.synthetic.main.fragment_b.view.*


class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val list = ArrayList<String>()

        list.add("Akanshita")
        list.add("Yashasvi")
        list.add("Farheen")

        list.add("Gaurav")
        list.add("Irfan")
        list.add("Rima")
        list.add("Isha")
        list.add("Usman")
        list.add("Praksh")
        list.add("Vikaz")
        list.add("Amit")
        list.add("Ankush")
        list.add("Rohan")
        val adapter = Fragment_A_Adapter(context!!, list)

        view.recyclerViewB.layoutManager = LinearLayoutManager(context)
        view.recyclerViewB.itemAnimator = DefaultItemAnimator()
//        view.  recyclerViewA.setNestedScrollingEnabled(false);

        view.recyclerViewB.adapter = adapter

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