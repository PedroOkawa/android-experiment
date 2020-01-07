import java.net.URI

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://ci.android.com/builds/submitted/6043188/androidx_snapshot/latest/repository/")
    }
    dependencies {
        classpath(Dependencies.gradle)
        classpath(kotlin(module = "gradle-plugin", version = Versions.kotlin))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://ci.android.com/builds/submitted/6043188/androidx_snapshot/latest/repository/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}