package com.guyuuan.gradle.plugin

import com.guyuuan.gradle.plugin.extension.configureKotlinAndroid
import com.android.build.gradle.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 *@author: guyuuan
 *@createTime: 2022/11/13 19:57
 *@description:
 **/
class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33
            }
        }
    }
}