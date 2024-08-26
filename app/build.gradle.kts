import com.android.utils.TraceUtils.simpleId

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
   // alias(libs.plugins.hilt)
    //alias(libs.plugins.ksp)
}

android {
    namespace = "com.sneakerups"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.sneakerups"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        // Define custom BuildConfig fields
        buildConfigField("boolean", "FEATURE_ENABLED", "true")

        //Define Manifest placeholders
        manifestPlaceholders["appName"] = "MyApp"
        manifestPlaceholders["apiKey"] = "default_api_key"


    }

    buildTypes {

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            manifestPlaceholders["apiKey"] = "release_api_key"
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            manifestPlaceholders["apiKey"] = "debug_api_key"

        }


    }

    // Specifies one flavor dimension.
    flavorDimensions += "version"
    productFlavors {
        create("demo"){
            dimension = "version"
            applicationIdSuffix = ".demo"
            versionNameSuffix = "-demo"
            // Define custom BuildConfig fields
            buildConfigField("boolean", "FEATURE_ENABLED", "true")

            //App Info
            manifestPlaceholders["appName"] = "Gold App"

        }

        create("full"){
            dimension = "version"
            applicationIdSuffix = ".full"
            versionNameSuffix = "-full"
            // Define custom BuildConfig fields
            buildConfigField("boolean", "FEATURE_ENABLED", "false")

            //App Info
            manifestPlaceholders["appName"] = "PurpleApp"

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

    buildFeatures {
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(project(":featureModuleD"))

    implementation(project(":featureModuleB:account"))

    implementation((project(":featureHomeModule:presentation")))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.material3.adaptive.navigation.suite.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //dagger
    implementation(libs.hilt.android)
   // ksp(libs.hilt.compiler)

    //room database
    implementation((libs.androidx.room.ktx))




}