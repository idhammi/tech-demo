package id.idham.techdemo.core.model

sealed class ErrorType {
    data object RateLimitExceeded : ErrorType()
    data object NetworkError : ErrorType()
    data object Unauthorized : ErrorType()
    data object NotFound : ErrorType()
    data class Generic(val message: String) : ErrorType()
}
