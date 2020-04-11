package com.vedmitryapps.exhibitapp.screen.main.support

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.vedmitryapps.exhibitapp.R
import com.vedmitryapps.exhibitapp.base.adapter.BaseRecyclerAdapter
import com.vedmitryapps.exhibitapp.base.adapter.BaseViewHolder

class ImageAdapter : BaseRecyclerAdapter<String, ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.exhinit_image_item, parent,false
        )
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(items[position])
    }

}

class ImageViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {

    private var image: ImageView = itemView.findViewById(R.id.image_view_EIVH)

    override fun initUI() {
        image.setImageURI(Uri.parse(item))
    }
}