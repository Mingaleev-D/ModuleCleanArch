package com.example.module_ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.centerCropTransform
import com.example.module_domain.model.Article
import com.example.module_ui.databinding.ArticlesItemBinding

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class ModuleAdapter : RecyclerView.Adapter<ModuleAdapter.MyViewHolder>() {

   private var list = listOf<Article>()

   fun setData(list: List<Article>) {
      this.list = list
      notifyItemInserted(this.list.lastIndex)
   }

   inner class MyViewHolder(val viewDataBinding: ArticlesItemBinding) :
       RecyclerView.ViewHolder(viewDataBinding.root)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding =
          ArticlesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return MyViewHolder(binding)
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.viewDataBinding.apply {
         val item = list[position]
         ivArticle.loadImage(item.urlToImage)
         tvHeadlines.text = item.title
         tvContent.text = item.content
      }
   }

   override fun getItemCount(): Int {
      return this.list.size
   }

   fun ImageView.loadImage(url: String) {
      val circularProgressDrawable = CircularProgressDrawable(this.context)
      circularProgressDrawable.strokeWidth = 5f
      circularProgressDrawable.centerRadius = 30f
      circularProgressDrawable.start()
      Glide.with(this).load(url).placeholder(circularProgressDrawable)
          .error(R.drawable.no_image_1).into(this)
   }

}