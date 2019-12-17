extra.apply {
    val mainDependencies = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.61",
        "androidx.appcompat:appcompat:${Versions.appCompat}",
        "androidx.core:core-ktx:${Versions.coreKtx}",
        "androidx.ui:ui-framework:${Versions.uiFramework}",
        "androidx.ui:ui-layout:${Versions.uiLayout}",
        "androidx.ui:ui-material:${Versions.uiMaterial}",
        "androidx.ui:ui-tooling:${Versions.uiTooling}"
    )

    val testDependencies = arrayOf(
        "junit:junit:${Versions.jUnit}",
        "androidx.test.ext:junit:${Versions.jUnitExt}",
        "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    )

    set("mainDependencies", mainDependencies)
    set("testDependencies", testDependencies)
}