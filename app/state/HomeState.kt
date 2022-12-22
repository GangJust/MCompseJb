package app.state

import androidx.compose.runtime.mutableStateOf
import app.model.HomeModel
import base.mvvm.AbstractState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class HomeState : AbstractState<HomeModel>() {
    override fun createModel(): HomeModel = HomeModel()

    //stateValue
    val userName = mutableStateOf("")
    val userPass = mutableStateOf("")

    val userInputError = mutableStateOf(false)
    val passInputError = mutableStateOf(false)

    val showLoginMessage = mutableStateOf(false)
    val loginMessage = mutableStateOf("")

    //stateAction
    fun onLogin() {
        if (userName.value.isBlank()) {
            userInputError.value = true
            loginMessage.value = "please input the account."
            showTaskSnackbar {}
            return
        }

        if (userPass.value.isBlank()) {
            passInputError.value = true
            loginMessage.value = "please input the password."
            showTaskSnackbar {}
            return
        }

        loginMessage.value = "Signing in, please wait..."
        showTaskSnackbar {
            val loginResult = model.requestLogin(userName.value, userPass.value)
            //pretend to handle login logic.
            //....
            //
            if (loginResult.contains("success")) {
                loginMessage.value = "login success."
            } else {
                loginMessage.value = "login failed."
            }
        }
    }

    fun showTaskSnackbar(runTask: suspend () -> Unit) {
        showLoginMessage.value = true
        CoroutineScope(EmptyCoroutineContext).launch {
            runTask()
            delay(2000L)
            showLoginMessage.value = false
        }
    }
}