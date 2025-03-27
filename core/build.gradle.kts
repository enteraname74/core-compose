import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("com.android.library")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = "com.github.enteraname74.corecompose"
description = "Core elements for compose"
version = "0.1.0"

kotlin {
    jvmToolchain(17)
    androidTarget()
    jvm("desktop")
    
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        // Common compiler options applied to all Kotlin source sets for expect / actual implementations
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.bundles.androidx)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.components.resources)
            implementation(compose.ui)
        }
    }
}

android {
    namespace = "com.github.enteraname74.corecompose.core"
    compileSdk = 35
    
    defaultConfig {
        minSdk = 26
    }
    
    buildTypes {
        create("dev-release")
    }
}