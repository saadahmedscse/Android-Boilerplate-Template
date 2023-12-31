plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.saadahmedev.baseboilerplate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.saadahmedev.baseboilerplate"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        android.buildFeatures.buildConfig = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")

    //Popup Dialog
    implementation("com.saadahmedev.popup-dialog:popup-dialog:1.0.5")

    //Short Intent
    implementation("com.saadahmedev.shortintent:shortintent:3.0.0")

    //Tiny DB
    implementation("com.saadahmedev.tinydb:tinydb:1.0.0")

    //sSP sDP
    implementation("com.intuit.ssp:ssp-android:1.0.6")
    implementation("com.intuit.sdp:sdp-android:1.0.6")

    //Circle Image View
    implementation("de.hdodenhof:circleimageview:3.1.0")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.71828")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //OkHTTP
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    //Rounded Image View
    implementation("com.makeramen:roundedimageview:2.3.0")
}