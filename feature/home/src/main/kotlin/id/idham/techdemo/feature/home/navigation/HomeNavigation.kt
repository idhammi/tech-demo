package id.idham.techdemo.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.idham.techdemo.core.model.data.Data
import id.idham.techdemo.feature.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavGraphBuilder.homeScreen(
    onItemClicked: (Data) -> Unit
) {
    composable<HomeRoute> {
        HomeScreen(onItemClicked = onItemClicked)
    }
}
