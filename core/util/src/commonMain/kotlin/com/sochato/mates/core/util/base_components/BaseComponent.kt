package com.sochato.mates.core.util.base_components

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.local.Handler
import com.sochato.mates.core.util.local.message
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.Qualifier
import kotlin.coroutines.CoroutineContext

abstract class BaseComponent(
    componentContext: ComponentContext
): KoinComponent, CoroutineScope, ComponentContext by componentContext {

    private val tag = this::class.simpleName
    final override val coroutineContext: CoroutineContext
        = Handler.coroutineExceptionHandler + Dispatchers.Main.immediate + SupervisorJob()

    protected suspend fun <T> withMain(
        block: suspend CoroutineScope.() -> T
    ): T = withContext(
        context = coroutineContext,
        block = block
    )

    protected fun message(msg: String) {
        message(tag ?: "BaseComponent", msg)
    }

    protected inline fun <reified T> saveKoin(
        instance: T
    ) {
        getKoin().declare<T>(instance)
    }

    protected inline fun <reified T> saveKoin(
        instance: T,
        qualifier: Qualifier
    ) {
        getKoin().declare<T>(instance = instance, qualifier = qualifier)
    }

    protected inline fun <reified Binder, T: Binder> saveKoinWithBind(
        instance: T
    ) {
        getKoin().declare<Binder>(instance)
    }

    protected fun navigate(
        block: suspend CoroutineScope.() -> Unit
    ) {
        launch(coroutineContext) { block.invoke(this) }
    }
}