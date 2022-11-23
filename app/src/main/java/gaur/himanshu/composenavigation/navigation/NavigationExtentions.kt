package gaur.himanshu.composenavigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import com.ramcosta.composedestinations.utils.composable
import gaur.himanshu.composenavigation.NavGraphs
import gaur.himanshu.composenavigation.auth.LoginScreen
import gaur.himanshu.composenavigation.auth.SignUpScreen
import gaur.himanshu.composenavigation.destinations.*
import gaur.himanshu.composenavigation.home.AccountScreen
import gaur.himanshu.composenavigation.home.HomeScreen
import gaur.himanshu.composenavigation.home.ProfileScreen

fun NavGraphBuilder.authNavigation(navController: NavController) {
    navigation(
        route = NavGraphs.auth.route,
        startDestination = SignUpScreenDestination.route
    ) {
        composable(SignUpScreenDestination) {
            SignUpScreen(navigator = destinationsNavigator(navController))
        }
        composable(LoginScreenDestination) {
            LoginScreen(navigator = destinationsNavigator(navController))
        }
    }
}

fun NavGraphBuilder.homeNavigation(navController: NavController) {
    navigation(
        route = NavGraphs.home.route,
        startDestination = HomeScreenDestination.route
    ) {
        composable(HomeScreenDestination) {
            HomeScreen(navigator = destinationsNavigator(navController), value = navArgs.value)
        }
        composable(
            ProfileScreenDestination
        ) {
            ProfileScreen(
                navigator = destinationsNavigator(navController),
                id = navArgs.id,
                fakeData = navArgs.fakeData
            )
        }

        composable(AccountScreenDestination) {
            AccountScreen(navigator = destinationsNavigator(navController))
        }
    }
}