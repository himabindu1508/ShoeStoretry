package com.udacity.shoestore.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeStoreAdapter : RecyclerView.Adapter<ShoeStoreAdapter.ViewHolder>(){

    var data =  listOf<Shoe>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val shoeName: TextView = itemView.findViewById(R.id.shoe_name)
        val shoeSize: TextView = itemView.findViewById(R.id.shoe_shoesize)
        val shoeCompany: TextView = itemView.findViewById(R.id.shoe_company)
        val shoeDescription: TextView = itemView.findViewById(R.id.shoe_description)

        fun bind(item: Shoe) {
            val res = itemView.context.resources
            shoeName.text = item.name
            shoeCompany.text = item.company
            shoeDescription.text = item.description
            //shoeSize.text = item.
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_shoe, parent, false)

                return ViewHolder(view)
            }
        }
    }
}