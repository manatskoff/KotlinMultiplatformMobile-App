package ru.ivan.kmmproj.di

import org.kodein.di.*
import ru.ivan.kmmproj.core.coreModule
import ru.ivan.kmmproj.di.modules.engineModule
import ru.ivan.kmmproj.features.featuresModule
import kotlin.native.concurrent.ThreadLocal


@ThreadLocal
object EngineSDK {

    private var _di: DirectDI? = null
    internal val di: DirectDI
        get() = requireNotNull(_di)

    fun init(configuration: Configuration) {
        val configurationModule = DI.Module(
            name = "configurationModule",
            init = {
                bind<Configuration>() with singleton { configuration }
            }
        )


        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                configurationModule,
                engineModule,
                coreModule,
                featuresModule
            )
        }.direct

        _di = direct
    }
}

