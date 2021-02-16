package com.obv.spacephotogallery.ui.listScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.obv.spacephotogallery.R
import com.obv.spacephotogallery.data.ImageDetail

class ImageGridAdapter(val arrayList: List<ImageDetail>): RecyclerView.Adapter<ImageGridAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById<ImageView>(R.id.img_image)
        val title = itemView.findViewById<TextView>(R.id.tv_image_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item_grid,parent,false)
        return ViewHolder(itemViewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayList[position]
        holder.title.text = "Image no: ${arrayList[position].title}"
    }

    override fun getItemCount(): Int {
        return arrayList.count()
    }

}