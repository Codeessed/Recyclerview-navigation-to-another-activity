package com.example.wk5assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ProtoypesAdapter(private val contactsList: ArrayList<ContactsVariables>):RecyclerView.Adapter<ProtoypesAdapter.MyViewHolder>(){
    private lateinit var mListener: onItemClickListener

    class MyViewHolder(itemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val images: ImageView = itemView.findViewById(R.id.prototype_image)
        val names: TextView = itemView.findViewById(R.id.prototype_name)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_prototype,parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items = contactsList[position]
        holder.images.setImageResource(items.image)
        holder.names.text = items.name
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }


}