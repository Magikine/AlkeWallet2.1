package marjoriemoya.miniguamvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import marjoriemoya.miniguamvvm.LoginViewModel

class RegisterViewModel(loginViewModel: LoginViewModel) : ViewModel() {
    //variable que almacena el resultado del login
    val loginResultLiveData = MutableLiveData<Boolean>()

    /**
     * funcion que implementa una corrutina para
     */
    fun login(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (email == "admin@test.cl" && password == "admin") {
                    loginResultLiveData.postValue(true)
                } else {
                    loginResultLiveData.postValue(false)
                }

            } catch (e: Exception) {
                //codigo de erorr
                loginResultLiveData.postValue(false)

            }
        }


        fun get(java: Class<LoginViewModel>) {
        }

    }

    fun get(java: Class<LoginViewModel>) {

    }
}
