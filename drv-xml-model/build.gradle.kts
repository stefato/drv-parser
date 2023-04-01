@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.xjc)
}

sourceSets.named("main") {
    xjcExtraArgs.addAll("-Xxew", "-Xsetters", "-XsimpleEquals", "-XsimpleHashCode")
}

dependencies {
    "xjcClasspath"(libs.bundles.jaxb.plugins)

    implementation(libs.jaxb.adapter.threeten)
    implementation(libs.jakarta.xml.api)
}
