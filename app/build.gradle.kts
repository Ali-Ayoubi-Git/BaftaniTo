plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.ksp) apply false
}

android {
    namespace = "com.baftanito"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.baftanito"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    //dagger-hilt
    implementation(libs.dagger)
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.dagger.compiler)
    implementation(libs.dagger.android)

    implementation(libs.dagger.android.processor)
    implementation(libs.dagger.hilt)

    implementation(libs.dagger.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    //room
    implementation(libs.room)
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    implementation(libs.lifecycle.viewmodel)
    //ksp(libs.room.compiler)
    implementation(libs.glide)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}


