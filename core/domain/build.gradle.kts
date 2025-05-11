plugins {
    alias(libs.plugins.techdemo.android.library)
    alias(libs.plugins.techdemo.hilt)
}

android {
    namespace = "id.idham.techdemo.core.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)
}
