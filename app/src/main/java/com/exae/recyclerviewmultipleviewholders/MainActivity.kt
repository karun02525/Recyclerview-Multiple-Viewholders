package com.exae.recyclerviewmultipleviewholders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exae.recyclerviewmultipleviewholders.adapter.LandmarkAdapter
import com.exae.recyclerviewmultipleviewholders.data.LandmarkModel
import com.exae.recyclerviewmultipleviewholders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // remember to set this value to null in the onDestroy method to avoid memory leaks.
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val landmarks = LandmarkModel.getLandmarks()
        mainBinding.landmarkRecyclerview.apply {
            adapter = LandmarkAdapter(landmarks)
        }
    }
}