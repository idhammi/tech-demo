plugins {
    alias(libs.plugins.techdemo.android.library)
    alias(libs.plugins.techdemo.hilt)
}

android {
    namespace = "id.idham.techdemo.core.network"

    buildTypes {
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://66b197c51ca8ad33d4f482c9.mockapi.io/\""
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(projects.core.model)

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.kotlin.codegen)

    // Logging
    implementation(libs.okhttp.logging)
}
