package gaur.himanshu.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.composenavigation.navigation.authNavigation
import gaur.himanshu.composenavigation.navigation.homeNavigation
import gaur.himanshu.composenavigation.ui.theme.ComposeNavigationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    ComposeNavigationTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavGraphs.auth.route) {
            authNavigation(navController)
            homeNavigation(navController)
        }
    }
}

