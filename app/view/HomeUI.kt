package app.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.state.HomeState
import base.mvvm.AbstractView

class HomeUI : AbstractView<HomeState>() {
    override fun createState(): HomeState = HomeState()

    @Composable
    override fun viewCompose() {
        Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {

            Spacer(modifier = Modifier.height(24.dp))
            //title
            Text(
                text = "Login In",
                style = TextStyle(fontSize = 36.sp, color = Color.Gray),
            )

            Spacer(modifier = Modifier.height(24.dp))

            //account
            OutlinedTextField(
                state.userName.value,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = state.userInputError.value,
                placeholder = { Text("please input the account.") },
                onValueChange = {
                    state.userName.value = it
                    state.userInputError.value = it.isBlank()
                })

            Spacer(modifier = Modifier.height(24.dp))

            //password
            OutlinedTextField(
                state.userPass.value,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = state.passInputError.value,
                placeholder = { Text("please input the password.") },
                onValueChange = {
                    state.userPass.value = it
                    state.passInputError.value = it.isBlank()
                })

            Spacer(modifier = Modifier.height(24.dp))

            //confirm
            Button(
                modifier = Modifier.align(Alignment.End),
                onClick = { state.onLogin() }) {
                Text("Login")
            }

            //message
            if (state.showLoginMessage.value) {
                Spacer(modifier = Modifier.height(24.dp))

                Snackbar { Text(state.loginMessage.value) }
            }
        }
    }
}