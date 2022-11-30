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