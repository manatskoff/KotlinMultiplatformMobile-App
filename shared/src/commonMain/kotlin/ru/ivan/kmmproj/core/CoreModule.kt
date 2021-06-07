package ru.ivan.kmmproj.core

import org.kodein.di.DI
import ru.ivan.kmmproj.core.ktor.ktorModule
import ru.ivan.kmmproj.core.serialization.serializationModule



val coreModule = DI.Module {
    importAll(
            ktorModule,
            serializationModule
    )
}