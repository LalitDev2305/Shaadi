plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    id(libs.plugins.kotlin.serialization.get().pluginId)
}

dependencies {
    implementation(projects.network)
    implementation(projects.common.data)
    implementation(projects.common.domain)
    implementation(projects.common.utils)
    implementation(projects.features.home.data)
    implementation(libs.ktor.serialization)
    implementation(libs.javax.inject)
    testImplementation(libs.junit)
}