plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"

    defaultConfig {
        applicationId = "me.okawa.androidexperiment"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    dynamicFeatures = mutableSetOf(":launches:home", ":account:settings")
}

dependencies {
    implementation(project(":core:feature"))
    AppDependencies.api.forEach { dependency ->
        api(dependency)
    }
    AppDependencies.implementation.forEach { dependency ->
        implementation(dependency)
    }
    AppDependencies.testImplementation.forEach { dependency ->
        testImplementation(dependency)
    }
    AppDependencies.androidTestImplementation.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}
