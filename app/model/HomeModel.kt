package app.model

import base.mvvm.AbstractModel
import kotlinx.coroutines.delay

class HomeModel : AbstractModel() {

    suspend fun requestLogin(userName: String, userPassword: String): String {
        //pretend to log in.
        delay(2000L)
        return "{\"code\":0, \"msg\":\"success.\",\"name\":\"$userName\",millis:${System.currentTimeMillis()}}"
    }

    override fun dispose() {

    }
}