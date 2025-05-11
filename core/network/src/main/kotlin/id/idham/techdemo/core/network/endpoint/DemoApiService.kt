package id.idham.techdemo.core.network.endpoint

import id.idham.techdemo.core.network.model.NetworkData
import retrofit2.http.GET

interface DemoApiService {
    @GET("/getData/test")
    suspend fun getData(): List<NetworkData>
}
