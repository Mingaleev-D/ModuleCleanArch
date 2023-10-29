package com.example.search_ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.common_utils.Navigator
import com.example.search_ui.databinding.ActivitySearchBinding
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import java.text.SimpleDateFormat

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

   companion object {

      fun launchActivity(activity: Activity) {
         val intent = Intent(activity, SearchActivity::class.java)
         activity.startActivity(intent)
      }

      const val START_DATE = "from"
      const val END_DATE = "to"
      const val apiKey = "apiKey"
      const val QUERY = "q"
      const val KEY = BuildConfig.API_KEY
   }

   private val binding by lazy { ActivitySearchBinding.inflate(layoutInflater) }
   private val viewModel: SearchViewModel by viewModels()
   private val searchAdapter = SearchAdapter()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      initView()
      setObserver()
   }

   private fun setObserver() {
      lifecycleScope.launchWhenStarted {
         viewModel.searchUiState.collectLatest { state ->
            if (state.isLoading) {
               binding.progressBar.isVisible = true
            }
            if (state.error.isNotBlank()) {
               binding.progressBar.isVisible = false
               Toast.makeText(this@SearchActivity, state.error, Toast.LENGTH_SHORT).show()
            }
            state.data?.let {
               binding.progressBar.isVisible = false
               searchAdapter.setData(it)
            }
         }
      }

   }

   private fun initView() {

      binding.rvSearch.adapter = searchAdapter

      binding.searchTitle.doAfterTextChanged {
         val map = mutableMapOf<String, String>()
         map[apiKey] = KEY
         map[QUERY] = it.toString()
         viewModel.getSearchArticles(map)
      }


      binding.ivRange.setOnClickListener {
         val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
         datePicker.show(this.supportFragmentManager,"range picker")

         datePicker.addOnPositiveButtonClickListener {
            val start = changeDateFormat(it.first)
            val end = changeDateFormat(it.second)

            val map = mutableMapOf<String,String>()
            map[apiKey]=KEY
            map[QUERY]=binding.searchTitle.text.toString()
            map[START_DATE]=start
            map[END_DATE]=end

            viewModel.getSearchArticles(map)
         }
      }
   }

   fun changeDateFormat(long:Long?):String{
      return try {
         val simpleDateFormat= SimpleDateFormat("yyyy-MM-dd")
         simpleDateFormat.format(long)
      }catch (e:Exception){
         ""
      }
   }
}

object GoToSearchActivity : Navigator {

   override fun navigate(activity: Activity) {
      SearchActivity.launchActivity(activity)
   }
}