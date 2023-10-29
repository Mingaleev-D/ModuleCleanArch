package com.example.search_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.search_domain.model.Article
import com.example.search_domain.use_case.GetSearchUseCase
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
class SearchViewModel @Inject constructor(
    private val searchUseCase: GetSearchUseCase
) : ViewModel() {

   private val _searchUiState = MutableStateFlow(SearchUiState())
   val searchUiState: StateFlow<SearchUiState> = _searchUiState

   fun getSearchArticles(map: MutableMap<String, String>) {
      searchUseCase(map).onEach { result ->
         when (result) {
            is Resource.Loading -> {
               _searchUiState.value = SearchUiState(isLoading = true)
            }

            is Resource.Success -> {
               _searchUiState.value = SearchUiState(data = result.data ?: emptyList())
            }

            is Resource.Error -> {
               _searchUiState.value = SearchUiState(
                   error = result.message ?: "An unexpected error occurred"
               )
            }
         }
      }.launchIn(viewModelScope)
   }
}

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article> = emptyList()
)