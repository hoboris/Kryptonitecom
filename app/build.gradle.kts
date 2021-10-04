import me.hoboris.buildSrc.Jvm
import me.hoboris.buildSrc.Libs
import me.hoboris.buildSrc.Sdk

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Sdk.compileSdk
    buildToolsVersion = Sdk.buildToolsVersion

    defaultConfig {
        applicationId = "me.hoboris.kryptonitecom"
        minSdk = Sdk.minSdk
        targetSdk = Sdk.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(Jvm.version)
        targetCompatibility(Jvm.version)
    }

    buildFeatures{
        dataBinding = true
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = Jvm.version.toString()
    }
}

dependencies {

    implementation(Libs.material)
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.fragment)
    implementation(Libs.AndroidX.recyclerview)
    implementation(Libs.AndroidX.Hilt.lifecycleViewmodel)
    kapt(Libs.AndroidX.Hilt.compiler)
    implementation(Libs.AndroidX.Hilt.Dagger.android)
    kapt(Libs.AndroidX.Hilt.Dagger.compiler)
    implementation(Libs.AndroidX.Lifecycle.Ktx.viewmodel)
    implementation(Libs.AndroidX.Lifecycle.Ktx.runtime)
    implementation(Libs.AndroidX.Lifecycle.Ktx.livedata)
    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.ktx)
    kapt(Libs.AndroidX.Room.compiler)
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.Coroutines.android)
    implementation(Libs.Kotlin.Coroutines.core)
}