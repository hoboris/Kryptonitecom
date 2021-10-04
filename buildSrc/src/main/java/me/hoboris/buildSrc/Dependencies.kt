package me.hoboris.buildSrc

import org.gradle.api.JavaVersion

object Libs {
    const val material = "com.google.android.material:material:1.4.0"
    object AndroidX {
        const val core = "androidx.core:core-ktx:1.6.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.6"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
        object Hilt {
            private const val version = "1.0.0"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
            const val lifecycleViewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
            object Dagger {
                private const val version = "2.38.1"
                const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
                const val android = "com.google.dagger:hilt-android:$version"
                const val compiler = "com.google.dagger:hilt-android-compiler:$version"
            }
        }
        object Lifecycle {
            object Ktx {
                private const val version = "2.4.0-alpha02"
                const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
                const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
                const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            }
        }
        object Room {
            private const val version = "2.3.0"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val runtime = "androidx.room:room-runtime:$version"
        }
    }
    object Kotlin {
        @Suppress("MemberVisibilityCanBePrivate")
        const val version = "1.5.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"

        object Coroutines {
            private const val version = "1.5.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }
}
object Jvm {
    val version = JavaVersion.VERSION_11
}
object Sdk {
    const val buildToolsVersion = "30.0.3"
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
}