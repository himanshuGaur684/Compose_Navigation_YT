package gaur.himanshu.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.utils.composable
import com.ramcosta.composedestinations.utils.destination
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.composenavigation.auth.LoginScreen
import gaur.himanshu.composenavigation.auth.SignUpScreen
import gaur.himanshu.composenavigation.destinations.HomeScreenDestination
import gaur.himanshu.composenavigation.destinations.LoginScreenDestination
import gaur.himanshu.composenavigation.destinations.ProfileScreenDestination
import gaur.himanshu.composenavigation.destinations.SignUpScreenDestination
import gaur.himanshu.composenavigation.home.HomeScreen
import gaur.himanshu.composenavigation.home.ProfileScreen
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

