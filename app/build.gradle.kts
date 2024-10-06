plugins {
    //alias(libs.plugins.android.application)
    //alias(libs.plugins.google.gms.google.services)
        id("com.android.application")
        id("com.google.gms.google-services")
}

android {
    namespace = "com.example.dogfood"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dogfood"
        minSdk = 23
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }

}

//dependencies {
    //implementation(libs.appcompat)
    //implementation(libs.material)
    //implementation(libs.activity)
    //implementation(libs.constraintlayout)
//    implementation(libs.firebase.auth)
    //implementation(libs.firebase.database)
    //implementation(libs.engage.core)

    //testImplementation(libs.junit)
    //androidTestImplementation(libs.ext.junit)
    //androidTestImplementation(libs.espresso.core)

    //implementation("com.github.bumptech.glide:glide:4.12.0")
    //annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    //implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    //implementation("com.google.firebase:firebase-auth-ktx")

    //implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
//    implementation("com.google.firebase:firebase-auth")
//    implementation("com.google.firebase:firebase-auth-ktx")

    //implementation("com.google.firebase:firebase-auth-ktx")

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.engage.core)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    implementation("com.google.firebase:firebase-auth-ktx")
}
