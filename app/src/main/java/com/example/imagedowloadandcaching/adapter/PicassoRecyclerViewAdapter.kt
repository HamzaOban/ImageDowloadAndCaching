package com.example.imagedowloadandcaching.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PointF
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imagedowloadandcaching.R
import com.example.imagedowloadandcaching.model.ImageModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.ColorFilterTransformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import jp.wasabeef.picasso.transformations.CropTransformation
import jp.wasabeef.picasso.transformations.gpu.BrightnessFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.SketchFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation


class PicassoRecyclerViewAdapter(private val context: Context, private val picassoList : ArrayList<ImageModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val uri : String = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
    class PicassoRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView = itemView.findViewById(R.id.image_view)
        var textView : TextView = itemView.findViewById(R.id.text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picasso_list,parent,false)
        return PicassoRecyclerHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(picassoList[position].type){
           0 -> {
               imageDownloadingAndCachingPicasso0(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           1 -> {
               imageDownloadingAndCachingPicasso1(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           2 -> {
               imageDownloadingAndCachingPicasso2(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           3 -> {
               imageDownloadingAndCachingPicasso3(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           4 -> {
               imageDownloadingAndCachingPicasso4(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           5 -> {
               imageDownloadingAndCachingPicasso5(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           6 -> {
               imageDownloadingAndCachingPicasso6(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           7 -> {
               imageDownloadingAndCachingPicasso7(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           8 -> {
               imageDownloadingAndCachingPicasso8(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }
           9 -> {
               imageDownloadingAndCachingPicasso9(uri,(holder as PicassoRecyclerHolder).imageView)
               holder.textView.text = picassoList[position].name
           }

       }

    }

    override fun getItemCount(): Int {
        return picassoList.size
    }

    private fun imageDownloadingAndCachingPicasso0(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso1(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .resize(300,200)
            .transform(jp.wasabeef.picasso.transformations.MaskTransformation(context,R.drawable.lion))
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso2(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(CropTransformation(300,100))
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso3(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(CropSquareTransformation())
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso4(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(CropCircleTransformation())
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso5(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(ColorFilterTransformation(Color.argb(80, 255, 0, 0)))
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso6(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(BrightnessFilterTransformation(context, 0.5f))
            .into(imageView)
    }

    private fun imageDownloadingAndCachingPicasso7(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(
                VignetteFilterTransformation(
                    context,
                    PointF(0.5f, 0.5f),
                    floatArrayOf(0.0f, 0.0f, 0.0f),
                    0f,
                    0.75f
                )
            )
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso8(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(SwirlFilterTransformation(context, 0.5f, 1.0f, PointF(0.5f, 0.5f)))
            .into(imageView)
    }
    private fun imageDownloadingAndCachingPicasso9(uri : String, imageView: ImageView){
        Picasso
            .get()
            .load(uri)
            .transform(SketchFilterTransformation(context))
            .into(imageView)
    }
}