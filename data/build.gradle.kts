plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":domain"))

    DataDependencies.dataApi.forEach { dependency ->
        api(dependency)
    }

    DataDependencies.dataImplementation.forEach { dependency ->
        implementation(dependency)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}