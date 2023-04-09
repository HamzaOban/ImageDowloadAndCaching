package com.example.imagedowloadandcaching

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagedowloadandcaching.adapter.GlideRecyclerViewAdapter
import com.example.imagedowloadandcaching.adapter.PicassoRecyclerViewAdapter
import com.example.imagedowloadandcaching.databinding.FragmentGlideBinding
import com.example.imagedowloadandcaching.model.ImageModel

class GlideFragment : Fragment() {
    private lateinit var binding : FragmentGlideBinding

    var glideList = ArrayList<ImageModel>()
    private lateinit var adapter : GlideRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGlideBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView2.layoutManager = LinearLayoutManager(context)
        glideList.clear()
        glideList.add(ImageModel("orjinal", ImageView(context),0))
        glideList.add(ImageModel("Blur", ImageView(context),1))
        glideList.add(ImageModel("crop", ImageView(context),2))
        glideList.add(ImageModel("Square", ImageView(context),3))
        glideList.add(ImageModel("Circle", ImageView(context),4))
        glideList.add(ImageModel("ColorFilter", ImageView(context),5))
        glideList.add(ImageModel("Brightness", ImageView(context),6))
        glideList.add(ImageModel("VignetteFilter", ImageView(context),7))
        glideList.add(ImageModel("SwirlFilter", ImageView(context),8))
        glideList.add(ImageModel("Sketch", ImageView(context),9))

        adapter = context?.let { GlideRecyclerViewAdapter(it,glideList) }!!
        binding.recyclerView2.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}