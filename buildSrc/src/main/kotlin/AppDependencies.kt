object AppDependencies {
    val api = arrayOf(
        Dependencies.androidViewModel,
        Dependencies.androidLiveData,
        Dependencies.androidLifecycleExtensions,
        Dependencies.appCompat,
        Dependencies.koinAndroidXScope,
        Dependencies.koinAndroidXViewModel,
        Dependencies.kotlinExtensions,
        Dependencies.navigation,
        Dependencies.navigationUi,
        Dependencies.retrofit,
        Dependencies.uiFoundation,
        Dependencies.uiFramework,
        Dependencies.uiLayout,
        Dependencies.uiMaterial,
        Dependencies.uiTooling
    )

    val implementation = arrayOf(
        Dependencies.coil
    )

    val testImplementation = arrayOf(
        Dependencies.jUnit
    )

    val androidTestImplementation = arrayOf(
        Dependencies.androidJUnit,
        Dependencies.espresso
    )
}