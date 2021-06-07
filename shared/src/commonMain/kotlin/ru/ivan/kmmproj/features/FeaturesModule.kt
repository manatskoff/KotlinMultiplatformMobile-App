package ru.ivan.kmmproj.features

import org.kodein.di.DI
import ru.ivan.kmmproj.features.hubble.hubbleModule


val featuresModule = DI.Module {
    importAll(
            hubbleModule
    )
}