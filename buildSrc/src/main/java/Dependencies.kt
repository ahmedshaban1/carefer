import org.gradle.kotlin.dsl.provideDelegate

/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltPath}" }
    val ktLint by lazy {  "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLintGradle}" }
    val ktLintMeven = "https://plugins.gradle.org/m2/"


}

/**
 * To define dependencies
 */
object Deps {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "androidx.compose.material3:material3:${Versions.material_three}" }
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.compose}" }
    val composePreView by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val lifeCycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val testJunit by lazy { "junit:junit:${Versions.jUnit}" }
    val androidTestJunit by lazy { "androidx.test.ext:junit:${Versions.androidTest}" }
    val espressoTest by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoTest}" }
    val composeUiTest by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val debugCompose by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeNavigation by lazy { "androidx.navigation:navigation-compose:${Versions.composeNavigation}" }
    val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    val hitlNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    val daggerHiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val daggerCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.daggerHilt}" }
    val roomRunTime by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    var roomExtension = "androidx.room:room-ktx:${Versions.room}"
    val retrofitCoroutinesAdapter by lazy { "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitGsonAdapter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}" }
    val retrofitScalarsAdapter by lazy { "com.squareup.retrofit2:converter-scalars:${Versions.scalarsAdapter}" }
    val httpLogger by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}" }
    val constraintLayoutCompose by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}" }
    val coil by  lazy { "io.coil-kt:coil-compose:${Versions.coil}" }


}




