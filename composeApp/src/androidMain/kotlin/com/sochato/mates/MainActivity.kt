package com.sochato.mates

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.toArgb
import com.arkivanov.decompose.retainedComponent
import com.sochato.mates.core.util.extension.getComponent
import com.sochato.mates.root.RootComponent
import com.sochato.mates.root.RootScreen
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        getKoin().declare<Context>(this)

        val rootComponent = retainedComponent {
            getComponent<RootComponent>(it)
        }

        setContent {
            window.apply {
                navigationBarColor = MaterialTheme.colorScheme.background.toArgb()
            }
            RootScreen(component = rootComponent)
        }
    }

}
