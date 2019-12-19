object AppDependencies {
    val implementation = arrayOf(
        Dependencies.appCompat,
        Dependencies.kodein,
        Dependencies.kotlin,
        Dependencies.kotlinExtensions,
        Dependencies.uiFramework,
        Dependencies.uiLayout,
        Dependencies.uiMaterial,
        Dependencies.uiTooling
    )

    val testImplementation = arrayOf(
        Dependencies.jUnit
    )

    val androidTestImplementation = arrayOf(
        Dependencies.androidJUnit,
        Dependencies.espresso
    )
}