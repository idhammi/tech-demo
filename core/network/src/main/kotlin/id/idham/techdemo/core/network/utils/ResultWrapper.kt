package id.idham.techdemo.core.network.utils

import id.idham.techdemo.core.model.ErrorType

sealed class ResultWrapper<out T> {
    data class Success<T>(val data: T) : ResultWrapper<T>()
    data class Error(val error: ErrorType) : ResultWrapper<Nothing>()
}
