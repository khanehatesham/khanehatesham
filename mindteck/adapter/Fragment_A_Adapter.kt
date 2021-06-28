package com.app.pharmadawa.ui.notification

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.mindteck.R


class Fragment_A_Adapter(private var context: Context,
    private var listOfItem: ArrayList<String>
) :
    RecyclerView.Adapter<Fragment_A_Adapter.MyViewHolder>(),Filterable{

    private var mFilteredList: List<String>? = null

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)

    }

    //Inflate view for recycler
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_layout, p0, false)
        return MyViewHolder(view)
    }

    //Return size
    override fun getItemCount(): Int {
        return listOfItem.size
    }

    //Bind View Holder
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder. tvName.setText(getItem(position))

    }


    fun getItem(position: Int):String {
        return listOfItem[position]
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            @SuppressLint("DefaultLocale")
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val oReturn = FilterResults()
                val results = ArrayList<String>()

                if (mFilteredList == null)
                    mFilteredList = listOfItem
                if (constraint != null) {
                    if (mFilteredList != null && mFilteredList!!.size > 0) {
                        for (item in mFilteredList!!) {
                            if (item.toLowerCase().contains(
                                    constraint.toString().toLowerCase()
                                )
                            )
                                results.add(item)
                        }
                    }
                    oReturn.count = results.size
                    oReturn.values = results
                } else {
                    oReturn.count = listOfItem.size
                    oReturn.values = listOfItem
                }
                return oReturn
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                listOfItem =
                    results.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }


}