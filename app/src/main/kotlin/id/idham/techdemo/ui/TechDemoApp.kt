package id.idham.techdemo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import id.idham.techdemo.core.ui.utils.enterTransition
import id.idham.techdemo.core.ui.utils.exitTransition
import id.idham.techdemo.core.ui.utils.popEnterTransition
import id.idham.techdemo.core.ui.utils.popExitTransition
import id.idham.techdemo.feature.detail.navigation.detailScreen
import id.idham.techdemo.feature.detail.navigation.navigateToDetail
import id.idham.techdemo.feature.home.navigation.HomeRoute
import id.idham.techdemo.feature.home.navigation.homeScreen

@Composable
fun TechDemoApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition
    ) {
        homeScreen(onItemClicked = navController::navigateToDetail)
        detailScreen()
    }
}
