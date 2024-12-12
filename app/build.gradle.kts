plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
   // id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.composeecartapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.composeecartapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.kotlin.stdlib)

    implementation (libs.ui)
    implementation (libs.material3)
    implementation (libs.ui.tooling.preview)
    implementation (libs.androidx.navigation.compose)
    implementation (libs.glide) // For image loading
    implementation (libs.androidx.lifecycle.runtime.ktx.v251)

    implementation(libs.hilt.android.v2511)
    //ksp(libs.hilt.android.compiler)
    implementation (libs.androidx.room.ktx)


    // Room Database
    implementation (libs.androidx.room.runtime)
    //ksp (libs.androidx.room.compiler)

    // Coroutines for background work
    implementation (libs.kotlinx.coroutines.android)

    // Kotlin standard library
    implementation (libs.androidx.core.ktx.v190)
    implementation (libs.androidx.lifecycle.runtime.ktx.v260)



    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-compiler:2.51.1")  // Use KAPT for Hilt annotation processing
   // ksp("com.google.dagger:hilt-compiler:${extra["hilt_version"]}")  // KSP dependency
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    }

