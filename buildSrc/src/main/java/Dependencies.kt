/**
 * @author : Mingaleev D
 */

object Versions{

   const val core = "1.9.0"
   const val appcompat = "1.6.1"
   const val androidMaterial = "1.9.0"
   const val constraintLayout = "2.1.4"

   const val testImplJunit = "4.13.2"
   const val androidTestImplJunit = "1.1.5"
   const val androidTestEspresso = "3.5.1"

   const val retrofit = "2.9.0"
   const val gsonConvertor = "2.9.0"
   const val okHttp = "4.9.0"
   const val okhttpVersion = "4.9.0"

   const val lifecycle_version = "2.5.1"

   const val glide = "4.12.0"

   const val viewModelDelegateActivity = "1.7.2"
   const val viewModelDelegateFragment = "1.6.1"

   const val dagger = "2.44"

   const val roomVersion = "2.5.1"

   const val navigationComponents = "2.5.3"

   const val swipeRefresh = "1.1.0"

   const val lottieAnimations = "6.1.0"

   const val kotlinCoroutines = "1.6.4"

   const val intuit = "1.0.6"

   const val splashScreen = "1.0.1"

}

object Deps{
   const val core = "androidx.core:core-ktx:${Versions.core}"
   const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
   const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
   const val constraintLayout =
       "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}

object TestImplementation {
   const val junit = "junit:junit:${Versions.testImplJunit}"
}

object AndroidTestImplementation {
   const val junit = "androidx.test.ext:junit:${Versions.androidTestImplJunit}"
   const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"

}
object NavigationComponents {
   const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponents}"
   const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponents}"
}

object Retrofit {
   const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
   const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor}"
   const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
}

object OkHTTP {
   const val okHTTPInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
   const val okHTTP3 = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"

}

object ViewModelDelegate {
   const val viewModelDelegateActivity = "androidx.activity:activity-ktx:${Versions.viewModelDelegateActivity}"
   const val viewModelDelegateFragment = "androidx.fragment:fragment-ktx:${Versions.viewModelDelegateFragment}"
}

object DaggerHilt {
   const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
   const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
}

object Room {
   const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
   const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
   const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
}

object Glide {
   const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
   const val annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object Lifecycle {
   const val lifecycleViewModel =
       "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
   const val lifecycleRuntime =
       "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
   const val lifecycleLivedata =
       "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
   const val lifecycleCompiler =
       "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
   const val lifecycleSavedstate =
       "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle_version}"
}

object Coroutines {
   const val coroutineCore =
       "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
   const val coroutineAndroid =
       "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
}

object IntuitSdpSsp {
   const val sdp =
       "com.intuit.sdp:sdp-android:${Versions.intuit}"
   const val ssp =
       "com.intuit.ssp:ssp-android:${Versions.intuit}"
}

object CircularProgressBar {
   const val swipeRefresh =
       "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object LottieAnimations {
   const val lottieAnimations = "com.airbnb.android:lottie:${Versions.lottieAnimations}"
}

object SplashScreenAndroid {
   const val splashScreenAndroid = "androidx.core:core-splashscreen:${Versions.splashScreen}"
}