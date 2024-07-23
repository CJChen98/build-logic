package cn.chitanda.gradle.plugin

/**
 *@author: guyuuan
 *@createTime: 2022/11/13 19:35
 *@description:
 **/
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("chitanda.android.lib")
                apply("chitanda.android.lib.compose")
                apply("chitanda.android.hilt")
            }
//            extensions.configure<LibraryExtension> {
//                defaultConfig {
//                    testInstrumentationRunner = ""
//                }
//            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
//                add("implementation", project(":core:model"))
                add("implementation", project(":core:ui"))
//                add("implementation", project(":core:design"))
                add("implementation", project(":core:data"))
//                add("implementation", project(":core:common"))
//                add("implementation", project(":core:domain"))
//
//                add("testImplementation", project(":core:testing"))
//                add("androidTestImplementation", project(":core:testing"))
//
//                add("implementation", libs.findLibrary("coil.kt").get())
                add("implementation", libs.findLibrary("coil.compose").get())

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewmodel.compose").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}
