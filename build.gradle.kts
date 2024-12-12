// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}
buildscript {
    extra["kotlin_version"] = "1.8.0"  // Define Kotlin version
    extra["hilt_version"] = "2.51.1"     // Define Hilt version
    extra["compose_version"] = "1.7.4" // Define Compose version


    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")  // Kotlin plugin for Kotlin KAPT
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}





