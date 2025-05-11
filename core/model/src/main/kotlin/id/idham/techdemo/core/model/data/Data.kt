package id.idham.techdemo.core.model.data

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val createdAt: String,
    val name: String,
    val avatar: String,
    val city: String,
    val country: String,
    val county: String,
    val addressNo: String,
    val street: String,
    val zipCode: String,
    val id: String
)
