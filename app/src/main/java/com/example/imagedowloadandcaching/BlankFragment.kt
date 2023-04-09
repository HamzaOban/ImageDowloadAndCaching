package com.example.imagedowloadandcaching

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.imagedowloadandcaching.adapter.PicassoRecyclerViewAdapter
import com.example.imagedowloadandcaching.databinding.FragmentBlankBinding
import com.example.imagedowloadandcaching.model.ImageModel
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.squareup.picasso.Picasso
import jp.wasabeef.glide.transformations.BlurTransformation

class BlankFragment : Fragment() {
    private lateinit var binding : FragmentBlankBinding


    private lateinit var adapter : PicassoRecyclerViewAdapter
    var picassoList = ArrayList<ImageModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView2.layoutManager = LinearLayoutManager(context)
        picassoList.clear()
        picassoList.add(ImageModel("Orijinal", ImageView(context),0))
        picassoList.add(ImageModel("Mask",ImageView(context),1))
        picassoList.add(ImageModel("Crop",ImageView(context),2))
        picassoList.add(ImageModel("Square",ImageView(context),3))
        picassoList.add(ImageModel("Circle",ImageView(context),4))
        picassoList.add(ImageModel("ColorFilter",ImageView(context),5))
        picassoList.add(ImageModel("Brightness",ImageView(context),6))
        picassoList.add(ImageModel("VignetteFilter",ImageView(context),7))
        picassoList.add(ImageModel("SwirlFilter",ImageView(context),8))
        picassoList.add(ImageModel("Sketch",ImageView(context),9))

        adapter = context?.let { PicassoRecyclerViewAdapter(it,picassoList) }!!
        binding.recyclerView2.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    private fun imageDownloadingAndCachingPicasso(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(jp.wasabeef.picasso.transformations.MaskTransformation(context,R.drawable.spinner))
            .into(imageView)
    }
    private fun imageDownloadingAndCachingGlide(uri : String, imageView: ImageView, resourceId : Int){
        Glide.with(this)
            .load(uri)
            .transform(BlurTransformation(5))
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingUil(uri : String, imageView: ImageView){
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(activity))
        ImageLoader.getInstance().displayImage(uri,imageView,
            DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build())

    }
}