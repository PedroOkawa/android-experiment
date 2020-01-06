object CoreDependencies {
    val implementation = arrayOf(
        Dependencies.appCompat,
        Dependencies.koinAndroidXScope,
        Dependencies.koinAndroidXViewModel,
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