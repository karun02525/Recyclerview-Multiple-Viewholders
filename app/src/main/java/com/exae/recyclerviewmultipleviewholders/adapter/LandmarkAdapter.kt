package com.exae.recyclerviewmultipleviewholders.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exae.recyclerviewmultipleviewholders.HasImage
import com.exae.recyclerviewmultipleviewholders.adapter.Const.HASIMAGE
import com.exae.recyclerviewmultipleviewholders.adapter.Const.NOIMAGE
import com.exae.recyclerviewmultipleviewholders.data.Landmark
import com.exae.recyclerviewmultipleviewholders.databinding.LandmarkWithImageBinding
import com.exae.recyclerviewmultipleviewholders.databinding.LandmarkWithoutImageBinding

class LandmarkAdapter(private var landmarks: ArrayList<Landmark>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var count=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
            val view =
                LandmarkWithImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LandmarkWithImageViewHolder(view)
        } else {
            val view =
                LandmarkWithoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LandmarkWithoutImageViewHolder(view)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (landmarks[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }

    override fun getItemCount(): Int {
        Log.d("TAGS", "getItemCount: "+landmarks.size)
        return landmarks.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HASIMAGE){
            (holder as LandmarkWithImageViewHolder).bind(landmarks[position])
        } else{
            (holder as LandmarkWithoutImageViewHolder).bind(landmarks[position])
        }
    }


    inner class LandmarkWithImageViewHolder(private val landmarkWithImage: LandmarkWithImageBinding) :
        RecyclerView.ViewHolder(landmarkWithImage.root) {
        fun bind(landmark: Landmark) {
            count++
            Log.d("TAGS", "ViewHolder: "+count)
            landmarkWithImage.landmarkImage.setImageResource(landmark.resource!!)
            landmarkWithImage.landmarkWithImageTitle.text = landmark.title
            landmarkWithImage.landmarkWithImageDesc.text = landmark.desc
        }
    }

    inner class LandmarkWithoutImageViewHolder(private val landmarkWithoutImage: LandmarkWithoutImageBinding) :
        RecyclerView.ViewHolder(landmarkWithoutImage.root) {
        fun bind(landmark: Landmark) {
            landmarkWithoutImage.landmarkTitle.text = landmark.title
            landmarkWithoutImage.landmarkDesc.text = landmark.desc
        }
    }
}
private object Const{
    const val HASIMAGE = 0 // random unique value
    const val NOIMAGE = 1
}