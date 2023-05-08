buildscript {
    val kotlinVersion = "1.5.21"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("com.android.tools.build:gradle:8.0.1")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.1").apply(false)
    id("com.android.library").version("8.0.1").apply(false)
    kotlin("android").version("1.8.10").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
    kotlin("plugin.serialization") version("1.8.10")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
