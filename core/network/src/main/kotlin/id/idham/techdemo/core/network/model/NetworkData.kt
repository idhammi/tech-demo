package id.idham.techdemo.core.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.idham.techdemo.core.model.data.Data

@JsonClass(generateAdapter = true)
data class NetworkData(
    val createdAt: String,
    val name: String,
    val avatar: String,
    val city: String,
    val country: String,
    val county: String,
    @Json(name = "address_no") val addressNo: String,
    val street: String,
    @Json(name = "zip_code") val zipCode: String,
    val id: String
)

fun NetworkData.asExternalModel(): Data {
    return Data(
        createdAt = createdAt,
        name = name,
        avatar = avatar,
        city = city,
        country = country,
        county = county,
        addressNo = addressNo,
        street = street,
        zipCode = zipCode,
        id = id
    )
}
