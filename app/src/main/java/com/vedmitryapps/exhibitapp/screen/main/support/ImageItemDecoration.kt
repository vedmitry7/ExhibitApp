package com.vedmitryapps.exhibitapp.screen.main.support

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vedmitryapps.exhibitapp.R

class ImageItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (position >= 1)
            outRect.left = view.context.resources.getDimensionPixelSize(R.dimen.item_image_padding)
    }
}