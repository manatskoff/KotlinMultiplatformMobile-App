package ru.ivan.kmmproj.di.modules

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.ivan.kmmproj.di.EngineSDK


internal val engineModule = DI.Module(
    name = "EngineModule",
    init = {
        bind<PageGenerator>() with singleton { PageGenerator() }
    }
)


val EngineSDK.engine: PageGenerator
    get() = EngineSDK.di.instance()