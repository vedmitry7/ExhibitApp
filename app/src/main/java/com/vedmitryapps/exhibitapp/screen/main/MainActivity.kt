package com.vedmitryapps.exhibitapp.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vedmitryapps.exhibitapp.R
import com.vedmitryapps.exhibitapp.screen.main.support.ExhibitsAdapter
import com.vedmitryapps.exhibitapp.di.Injectable
import com.vedmitryapps.model.Exhibit
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: ExhibitsAdapter

    var getExhibitObserver = Observer<List<Exhibit>> { list -> list?.let { onGetExhibit(it) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()

        mainViewModel = ViewModelProviders.of(this@MainActivity, viewModelFactory).get(
            MainViewModel::class.java)
        mainViewModel.data.observe(this@MainActivity, getExhibitObserver)
        mainViewModel.getExhibits()
    }

    private fun setupAdapter() {
        adapter = ExhibitsAdapter()
        recycler_view_MA.layoutManager = LinearLayoutManager(this)
        recycler_view_MA.adapter = adapter
    }

    private fun onGetExhibit(list: List<Exhibit>) {
        adapter.addItems(list)
    }
}
