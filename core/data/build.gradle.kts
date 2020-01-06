plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    DataDependencies.api.forEach { dependency ->
        api(dependency)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}