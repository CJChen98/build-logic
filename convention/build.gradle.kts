plugins {
    `kotlin-dsl`
}
group = "cn.chitanda.gradle.build-logic"

kotlin{
    jvmToolchain(21)
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.androidx.room.gradle)
//    implementation(libs.truth)
}

gradlePlugin {
    plugins {
        with(libs.plugins.guyuuan.android) {
            create("androidAppCompose") {
                id = app.compose.get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidAppComposeConventionPlugin"
            }
            register("androidApp") {
                id = app.asProvider().get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidAppConventionPlugin"
            }
            register("androidLibCompose") {
                id = lib.compose.get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidLibComposeConventionPlugin"
            }
            register("androidLib") {
                id = lib.asProvider().get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidLibConventionPlugin"
            }
            register("androidFeature") {
                id = feature.get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidFeatureConventionPlugin"
            }
            register("androidHilt") {
                id = hilt.get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidHiltConventionPlugin"
            }
            register("androidTest") {
                id = test.get().pluginId
                implementationClass = "com.guyuuan.gradle.plugin.AndroidTestConventionPlugin"
            }
        }

    }
}