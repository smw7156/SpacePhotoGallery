package com.obv.spacephotogallery.ui.listScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.obv.spacephotogallery.R
import com.obv.spacephotogallery.data.ImageDetail

class ImageGridAdapter(val arrayList: List<ImageDetail>): RecyclerView.Adapter<ImageGridAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val rl_image = itemView.findViewById<RelativeLayout>(R.id.rl_image)
        val image: ImageView = itemView.findViewById<ImageView>(R.id.img_image)
        val title = itemView.findViewById<TextView>(R.id.tv_image_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item_grid,parent,false)
        return ViewHolder(itemViewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayList[position]
        holder.title.text = item.title
        Glide.with(holder.itemView).load(item.url).into(holder.image)
        holder.rl_image.setOnClickListener { view: View ->
            view.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(position))
        }
    }

    override fun getItemCount(): Int {
        return arrayList.count()
    }

}