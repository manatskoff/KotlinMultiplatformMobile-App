buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {


        // For Compose
//        classpath("com.android.tools.build:gradle:7.0.0-beta03")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")

        // For KMM
        val kotlinVersion = "1.5.10"
        classpath("com.android.tools.build:gradle:4.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")

        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }


}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
