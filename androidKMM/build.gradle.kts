plugins {
    id("com.android.application")
    kotlin("android")
}

val compose_version = "1.0.0-beta08"

dependencies {
    implementation(project(":shared"))

    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")


    // Compose
    implementation("androidx.compose.ui:ui:${compose_version}")
    // --Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${compose_version}")
    // --Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${compose_version}")
    // --Material Design
    implementation("androidx.compose.material:material:${compose_version}")
    // --Material design icons
    implementation("androidx.compose.material:material-icons-core:${compose_version}")
    implementation("androidx.compose.material:material-icons-extended:${compose_version}")
    // --Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:${compose_version}")
    implementation("androidx.compose.runtime:runtime-rxjava2:${compose_version}")
    // --UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${compose_version}")


    implementation("androidx.activity:activity-compose:1.3.0-alpha08")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha05")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.core:core-ktx:1.5.0")
}


android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "ru.ivan.kmmproj.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = compose_version
//    }
}

