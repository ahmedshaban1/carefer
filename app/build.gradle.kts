import Versions.compose

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
}

android {

    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.androidCore)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composePreView)
    implementation(Deps.lifeCycle)
    implementation(Deps.composeActivity)
    implementation(Deps.composeNavigation)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltCompiler)
    implementation(Deps.hitlNavigation)
    implementation(Deps.daggerHiltAndroid)
    kapt(Deps.daggerCompiler)
    implementation(Deps.roomRunTime)
    kapt(Deps.roomCompiler)
    implementation(Deps.roomExtension)
    implementation(Deps.retrofitCoroutinesAdapter)
    implementation(Deps.gson)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitGsonAdapter)
    implementation(Deps.httpLogger)
    implementation(Deps.retrofitScalarsAdapter)
    implementation(Deps.constraintLayoutCompose)
    implementation(Deps.coil)
    implementation(Deps.pager)

    testImplementation(Deps.testJunit)
    testImplementation(Deps.mockk)
    androidTestImplementation(Deps.androidTestJunit)
    androidTestImplementation(Deps.espressoTest)
    androidTestImplementation(Deps.composeUiTest)
    debugImplementation(Deps.debugCompose)
}
