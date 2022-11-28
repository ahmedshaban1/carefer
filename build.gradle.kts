/*buildscript {
    ext {
        compose_version = '1.3.1'
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id 'com.android.application' version '7.3.0' apply false
    id 'com.android.library' version '7.3.0' apply false
    id 'org.jetbrains.kotlin.android' version '1.7.10' apply false
}*/
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(BuildPlugins.ktLintMeven)

    }
    dependencies {
        classpath (BuildPlugins.android)
        classpath (BuildPlugins.kotlin)
        classpath(BuildPlugins.hilt)
        classpath(BuildPlugins.ktLint)
    }
}


tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}