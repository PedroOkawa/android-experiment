object AppDependencies {
    val api = arrayOf(
        Dependencies.androidViewModel,
        Dependencies.androidLiveData,
        Dependencies.androidLifecycleExtensions,
        Dependencies.appCompat,
        Dependencies.kodeinJvm,
        Dependencies.kodeinAndroidX,
        Dependencies.kotlinExtensions,
        Dependencies.retrofit,
        Dependencies.uiFoundation,
        Dependencies.uiFramework,
        Dependencies.uiLayout,
        Dependencies.uiMaterial,
        Dependencies.uiTooling
    )

    val implementation = arrayOf(
        Dependencies.coil,
        Dependencies.navigationDynamicFeature
    )

    val testImplementation = arrayOf(
        Dependencies.jUnit
    )

    val androidTestImplementation = arrayOf(
        Dependencies.androidJUnit,
        Dependencies.espresso
    )
}