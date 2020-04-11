package com.vedmitryapps.exhibitapp.screen.main.support

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vedmitryapps.exhibitapp.R
import com.vedmitryapps.exhibitapp.base.adapter.BaseRecyclerAdapter
import com.vedmitryapps.exhibitapp.base.adapter.BaseViewHolder
import com.vedmitryapps.model.Exhibit


class ExhibitsAdapter() : BaseRecyclerAdapter<Exhibit, ExhibitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.exhinit_item, parent,false
        )
        return ExhibitViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        holder.onBind(items[position])
    }

}

class ExhibitViewHolder(itemView: View) : BaseViewHolder<Exhibit>(itemView) {

    private var title: TextView = itemView.findViewById(R.id.text_view_title_EVH)
    private var recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_EVH)

    override fun initUI() {
        title.text = item.title
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        var men = LinearLayoutManager(recyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false)

        val adapter = ImageAdapter()
        recyclerView.adapter = adapter
        if(recyclerView.itemDecorationCount == 0)
            recyclerView.addItemDecoration(ImageItemDecoration())
        adapter.addItems(item.images)
    }
}