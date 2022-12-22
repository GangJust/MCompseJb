package base.mvvm

import androidx.compose.runtime.Composable


interface IView {

    //subclass implementation must add `@Composable` annotation
    //write layout in `viewCompose()` method
    @Composable
    fun viewCompose()
}

abstract class AbstractView<S : IState> : IView {
    val state: S = initState()

    private fun initState(): S {
        val s = createState()
        StateManager.addState(this::class.java, s)
        return s
    }

    abstract fun createState(): S
}

@Composable
fun ViewCompose(view: () -> IView) {
    view().viewCompose()
}