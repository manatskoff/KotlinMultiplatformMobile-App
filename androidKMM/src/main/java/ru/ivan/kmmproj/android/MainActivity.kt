package ru.ivan.kmmproj.android

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.ivan.composeapplication.ui.theme.ComposeApplicationTheme
import ru.ivan.kmmproj.FirstClass
import ru.ivan.kmmproj.android.compose.Greeting
import ru.ivan.kmmproj.di.Configuration
import ru.ivan.kmmproj.di.EngineSDK
import ru.ivan.kmmproj.di.PlatformType
import ru.ivan.kmmproj.di.modules.engine
import ru.ivan.kmmproj.dsl.*
import ru.ivan.kmmproj.features.hubble.hubble


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(greet() + " Configuration: Android")
                }
            }
        }

        EngineSDK.init(configuration = Configuration(platformType = PlatformType.Android("1.0", "1")))
        EngineSDK.engine.greeting()



        // DSL - Генерация статьи
        compileArticle(page {
            number = 1
            pageBlocks {
                headerBlock("Header text")
                mainBlock("Main text")
                endBlock("End text")
            }
        })


        // Вызов API
        /*
        GlobalScope.launch {
        var result = EngineSDK.hubble.hubbleRepository.fetchNews()
        Log.e("TAG", "Result -> ${result.count()}")
        }
         */


    }
}





fun compileArticle(page: Page) {
    page.pageBlocks?.forEach {
        Log.e("TAG", "Type -> ${it.type}, Content -> ${it.content}")
    }
}

fun greet(): String {
    return FirstClass().greeting()
}

