// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import app.view.HomeUI
import base.mvvm.StateManager
import base.mvvm.ViewCompose

fun main() = application {
    Window(
        onCloseRequest = {
            StateManager.clearStateMaps()
            this.exitApplication()
        },
        title = "Login In",
        state = WindowState(
            size = DpSize(420.dp, 480.dp),
            position = WindowPosition.Aligned(Alignment.Center)
        )
    ) {
        MaterialTheme {
            //HomeUI().viewCompose()
            //or
            ViewCompose {
                HomeUI()
            }
        }
    }
}