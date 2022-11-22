package gaur.himanshu.composenavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import gaur.himanshu.composenavigation.destinations.AccountScreenDestination
import gaur.himanshu.composenavigation.destinations.HomeScreenDestination
import gaur.himanshu.composenavigation.destinations.ProfileScreenDestination

@Destination(start = true)
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {

            Text(text = "Home Screen")
            Spacer(modifier = Modifier.height(14.dp))
            Button(onClick = {
                navigator.navigate(
                    ProfileScreenDestination(
                        id = "this is id",
                        fakeData = FakeData(name = "Himanshu", age = 20, isAdult = true)
                    )
                )
            }) {
                Text(text = "Click Me")
            }
        }
    }
}

@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    id: String,
    fakeData: FakeData,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Profile Screen ${id} ${fakeData.name}  ${fakeData.age} ${fakeData.isAdult}")
            Spacer(modifier = Modifier.height(14.dp))
            Button(onClick = {
                // 1st variant of popBackStack()
//                navigator.popBackStack()
                navigator.navigate(AccountScreenDestination)
            }) {
                Text(text = "Go Back")
            }
        }
    }
}

@Destination
@Composable
fun AccountScreen(navigator: DestinationsNavigator) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Account Screen")
            Spacer(modifier = Modifier.height(14.dp))
            Button(onClick = {
                // 2st variant of popBackStack()
                navigator.popBackStack(
                    HomeScreenDestination,
                    inclusive = false,
                    saveState = false
                )
                // inclusive true means it will pop HomeScreenDestination too
                // inclusive false means it will not pop HomeScreenDestination
            }) {
                Text(text = "Go Back")
            }
        }
    }
}


data class FakeData(val name: String, val age: Int, val isAdult: Boolean) : java.io.Serializable