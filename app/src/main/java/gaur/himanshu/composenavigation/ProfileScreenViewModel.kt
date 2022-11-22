package gaur.himanshu.composenavigation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(saveStateHandle: SavedStateHandle) : ViewModel() {

    init {
        saveStateHandle.getLiveData<String>("id").observeForever {
            Log.d("TAG", "Id: ${it}")
        }
        saveStateHandle.getLiveData<FakeData>("fakeData").observeForever {
            Log.d("TAG", "FakeData: ${it}")
        }
    }

}



