import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin)
}

dependencies {
    api(project(":drv-xml-model"))

    implementation(libs.bundles.jackson.xml)

    testApi(testFixtures(project(":common-test")))
    testImplementation(libs.bundles.test)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

