object NavigationDependencies {
    val implementation = arrayOf(
        Dependencies.appCompat,
        Dependencies.kodeinJvm,
        Dependencies.kodeinAndroidX,
        Dependencies.kotlinExtensions,
        Dependencies.okHttpLoggingInterceptor,
        Dependencies.retrofit,
        Dependencies.retrofitGsonConverter
    )

    val testImplementation = arrayOf(
        Dependencies.jUnit
    )

    val androidTestImplementation = arrayOf(
        Dependencies.androidJUnit,
        Dependencies.espresso
    )
}