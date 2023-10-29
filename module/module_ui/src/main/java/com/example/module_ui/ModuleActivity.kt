package com.example.module_ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.common_utils.Activities
import com.example.common_utils.Navigator
import com.example.module_ui.databinding.ActivityModuleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class ModuleActivity : AppCompatActivity() {

   @Inject
   lateinit var provider: Navigator.Provider

   companion object {

      fun launchActivity(activity: Activity) {
         val intent = Intent(activity, ModuleActivity::class.java)
         activity.startActivity(intent)
      }
   }

   private val binding by lazy { ActivityModuleBinding.inflate(layoutInflater) }
   private val viewModel: ModuleVIewModel by viewModels()
   private val articleAdapter = ModuleAdapter()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      iniView()
      setObservers()
   }

   private fun iniView() {
      binding.recyclerView.adapter = articleAdapter
      binding.imgSearch.setOnClickListener {
         provider.getActivities(Activities.SearchActivity).navigate(this)
      }
   }

   private fun setObservers() {
      lifecycleScope.launchWhenStarted {
         viewModel.articles.collectLatest { state ->
            if (state.isLoading) {
               binding.progressBar.isVisible = true
            }
            if (state.error.isNotBlank()) {
               binding.progressBar.isVisible = false
               Toast.makeText(this@ModuleActivity, state.error, Toast.LENGTH_SHORT).show()
            }
            state.data?.let {
               binding.progressBar.isVisible = false
               articleAdapter.setData(it)
            }
         }
      }
   }
}

object GoToModuleActivity : Navigator {

   override fun navigate(activity: Activity) {
      ModuleActivity.launchActivity(activity)
   }
}