package com.android.mindteck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mindteck.R
import com.app.pharmadawa.ui.notification.Fragment_A_Adapter
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*


class FragmentA : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_a, container, false)

        val list = ArrayList<String>()


        list.add("Kbir")
        list.add("Ehatesham")
        list.add("Pawan")
        list.add("Rahul")
        list.add("Himanshi")
        list.add("Akhilesh")
        list.add("Govind")
        list.add("Waseem")
        list.add("Vicky")
        list.add("Shino")
        val adapter= Fragment_A_Adapter(context!!,list)

        view. recyclerViewA.layoutManager=LinearLayoutManager(context)
        view. recyclerViewA.itemAnimator=DefaultItemAnimator()
        view.  recyclerViewA.adapter=adapter


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