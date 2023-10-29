package com.example.module_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.module_domain.model.Article
import com.example.module_domain.use_case.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

@HiltViewModel
class ModuleVIewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

   private val _articles = MutableStateFlow(UiState())
   val articles: StateFlow<UiState> = _articles

   init {
      getArticles()
   }

   private fun getArticles() {
      getArticlesUseCase().onEach { result ->
         when (result) {
            is Resource.Loading -> {
               _articles.value = UiState(isLoading = true)
            }

            is Resource.Success -> {
               _articles.value = UiState(data = result.data ?: emptyList())
            }

            is Resource.Error -> {
               _articles.value = UiState(error = result.message.toString())
            }
         }
      }.launchIn(viewModelScope)
   }
}

data class UiState(
    val isLoading: Boolean = false,
    val data: List<Article> = emptyList(),
    val error: String = ""
)