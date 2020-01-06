plugins {
    id("java-library")
    id("kotlin")
}
dependencies {
    implementation(project(":core:data"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}