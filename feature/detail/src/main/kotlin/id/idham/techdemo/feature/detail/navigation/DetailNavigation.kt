package id.idham.techdemo.feature.detail.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import id.idham.techdemo.core.model.data.Data
import id.idham.techdemo.feature.detail.DetailScreen
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

@Serializable
data class DetailRoute(val data: Data)

fun NavController.navigateToDetail(data: Data, navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = DetailRoute(data)) {
        navOptions()
    }
}

fun NavGraphBuilder.detailScreen() {
    composable<DetailRoute>(
        typeMap = mapOf(typeOf<Data>() to DataType)
    ) {
        val args = it.toRoute<DetailRoute>()
        DetailScreen(data = args.data)
    }
}

val DataType = object : NavType<Data>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Data? {
        return Json.decodeFromString(bundle.getString(key) ?: return null)
    }

    override fun parseValue(value: String): Data {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: Data): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: Data) {
        bundle.putString(key, Json.encodeToString(value))
    }
}
