package com.example.search_ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.search_domain.model.Article
import com.example.search_ui.databinding.ViewHolderSearchArticlesBinding

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

   private var list = listOf<Article>()

   fun setData(list: List<Article>) {
      this.list = list
      notifyItemInserted(this.list.lastIndex)
   }

   inner class MyViewHolder(val viewDataBinding: ViewHolderSearchArticlesBinding) :
       RecyclerView.ViewHolder(viewDataBinding.root)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding =
          ViewHolderSearchArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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