plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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
    dynamicFeatures = mutableSetOf(":home")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":core"))
    implementation(project(":domain"))

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
