package base

import androidx.compose.runtime.Composable


interface IView {

}

abstract class AbstractView<S : IState> : IView {
    val state: S = createState()

    abstract fun createState(): S

    //subclass implementation must add `@Composable` annotation
    //write layout in `viewCompose()` method
    @Composable
    abstract fun viewCompose()
}