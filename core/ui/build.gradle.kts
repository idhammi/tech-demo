plugins {
    alias(libs.plugins.techdemo.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "id.idham.techdemo.core.ui"

    buildFeatures {
        compose = true
    }
}

dependencies {
    api(projects.core.designsystem)
    api(projects.core.model)

    api(libs.kotlinx.serialization.json)

    api(libs.androidx.navigation.compose)
    api(libs.androidx.hilt.navigation.compose)

    api(libs.coil.compose)
    api(libs.coil.network.okhttp)
}
