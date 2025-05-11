package id.idham.techdemo.core.ui.utils

import id.idham.techdemo.core.model.Result
import id.idham.techdemo.core.ui.UiState
import id.idham.techdemo.core.ui.error.ErrorMessageMapper

/**
 * Converts Result<T> to UiState<T>, optionally validating if data is empty.
 */
inline fun <T> Result<T>.toUiState(
    isEmpty: (T) -> Boolean = { false } // by default, we assume non-empty
): UiState<T> {
    return when (this) {
        is Result.Loading -> UiState.Loading
        is Result.Error -> UiState.Error(ErrorMessageMapper.from(this.error))
        is Result.Success -> {
            if (isEmpty(data)) UiState.Empty else UiState.Success(data)
        }
    }
}
