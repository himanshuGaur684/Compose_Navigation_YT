package gaur.himanshu.composenavigation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import gaur.himanshu.composenavigation.AuthNavGraph
import gaur.himanshu.composenavigation.NavGraphs
import gaur.himanshu.composenavigation.destinations.LoginScreenDestination

@AuthNavGraph(start = true)
@Destination
@Composable
fun SignUpScreen(navigator: DestinationsNavigator) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column() {

            Text(text = "SignUp Screen")
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navigator.navigate(LoginScreenDestination)
            }) {
                Text(text = "GO to Login Screen")
            }

        }
    }
}

@AuthNavGraph
@Destination
@Composable
fun LoginScreen(navigator: DestinationsNavigator) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column() {
            Text(text = "Login Screen")
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navigator.navigate(route = NavGraphs.home.route)
            }) {
                Text(text = "Go to Home Graph")
            }

        }
    }
}