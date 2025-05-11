plugins {
    alias(libs.plugins.techdemo.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "id.idham.techdemo.core.model"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
