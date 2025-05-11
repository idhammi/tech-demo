package id.idham.techdemo.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.idham.techdemo.core.domain.GetDataUseCase
import id.idham.techdemo.core.model.data.Data
import id.idham.techdemo.core.ui.UiState
import id.idham.techdemo.core.ui.utils.toUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getDataUseCase: GetDataUseCase
) : ViewModel() {

    val dataState: StateFlow<UiState<List<Data>>> =
        getDataUseCase()
            .map { result ->
                result.toUiState { it.isEmpty() }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading
            )
}
