package com.example.imagedowloadandcaching.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PointF
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.example.imagedowloadandcaching.R
import com.example.imagedowloadandcaching.model.ImageModel
import com.squareup.picasso.Picasso
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.ColorFilterTransformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import jp.wasabeef.picasso.transformations.CropTransformation
import jp.wasabeef.picasso.transformations.gpu.BrightnessFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.SketchFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation


class GlideRecyclerViewAdapter(private val context: Context, private val glideList : ArrayList<ImageModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val uri : String = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
    class GlideRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView = itemView.findViewById(R.id.image_view)
        var textView : TextView = itemView.findViewById(R.id.text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picasso_list,parent,false)
        return GlideRecyclerHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(glideList[position].type){
            0 -> {
                imageDownloadingAndCachingPicasso0(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            1 -> {
                imageDownloadingAndCachingPicasso1(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            2 -> {
                imageDownloadingAndCachingPicasso2(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            3 -> {
                imageDownloadingAndCachingPicasso3(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            4 -> {
                imageDownloadingAndCachingPicasso4(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            5 -> {
                imageDownloadingAndCachingPicasso5(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            6 -> {
                imageDownloadingAndCachingPicasso6(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            7 -> {
                imageDownloadingAndCachingPicasso7(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            8 -> {
                imageDownloadingAndCachingPicasso8(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }
            9 -> {
                imageDownloadingAndCachingPicasso9(uri,(holder as GlideRecyclerHolder).imageView,R.drawable.spinner)
                holder.textView.text = glideList[position].name
            }

        }

    }

    override fun getItemCount(): Int {
        return glideList.size
    }
    private fun imageDownloadingAndCachingPicasso0(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso1(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(BlurTransformation(5))
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso2(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(CenterCrop())
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso3(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(jp.wasabeef.glide.transformations.CropSquareTransformation())
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso4(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(CircleCrop())
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso5(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(jp.wasabeef.glide.transformations.ColorFilterTransformation(Color.argb(80, 125, 120, 120)))
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso6(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation(0.5f))
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso7(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation( PointF(0.5f, 0.5f),
                floatArrayOf(0.0f, 0.0f, 0.0f),
                0f,
                0.75f))
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso8(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation(0.5f,1f, PointF(0.5f, 0.5f)))
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso9(uri : String, imageView: ImageView,resourceId : Int){
        Glide.with(context)
            .load(uri)
            .transform(jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation())
            .placeholder(resourceId)
            .error(R.drawable.spinner)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Maybe Toast Message
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

            })
            .into(imageView)
    }
}