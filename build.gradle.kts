// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
<<<<<<< HEAD
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
=======
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
>>>>>>> 741666d5f531318a1e5e769ec80c69d668a6c7fa
}