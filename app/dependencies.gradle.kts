extra.apply {
    set("kotlinVersion", "1.3.61")
    set("appCompatVersion", "1.1.0")

    val kotlinVersion: String by extra
    val appCompatVersion: String by extra
    val coreKtxVersion = "1.1.0"
    val uiFrameworkVersion = "0.1.0-dev03"
    val uiLayoutVersion = "0.1.0-dev03"
    val uiMaterialVersion = "0.1.0-dev03"
    val uiToolingVersion = "0.1.0-dev03"
    val jUnitVersion = "4.12"
    val jUnitExtVersion = "1.1.1"
    val espressoCoreVersion = "3.2.0"

    val mainDependencies = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion",
        "androidx.appcompat:appcompat:$appCompatVersion",
        "androidx.core:core-ktx:$coreKtxVersion",
        "androidx.core:core-ktx:$coreKtxVersion",
        "androidx.ui:ui-framework:$uiFrameworkVersion",
        "androidx.ui:ui-layout:$uiLayoutVersion",
        "androidx.ui:ui-material:$uiMaterialVersion",
        "androidx.ui:ui-tooling:$uiToolingVersion",
        "junit:junit:$jUnitVersion",
        "androidx.test.ext:junit:$jUnitExtVersion",
        "androidx.test.espresso:espresso-core:$espressoCoreVersion"
    )

    set("mainDependencies", mainDependencies)
}