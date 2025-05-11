plugins {
    alias(libs.plugins.techdemo.android.library)
    alias(libs.plugins.techdemo.hilt)
}

android {
    namespace = "id.idham.techdemo.core.data"
}

dependencies {
    api(projects.core.network)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockwebserver)
}