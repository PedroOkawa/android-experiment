object AppDependencies {
    val implementation = arrayOf(
        Dependencies.appCompat,
        Dependencies.androidLifecycleExtensions,
        Dependencies.androidLiveData,
        Dependencies.androidViewModel,
        Dependencies.coil,
        Dependencies.kodeinJvm,
        Dependencies.kodeinAndroidX,
        Dependencies.kotlinExtensions,
        Dependencies.uiFoundation,
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