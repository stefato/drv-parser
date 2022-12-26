plugins {
    id("org.unbroken-dome.xjc") version "2.0.0"
}

sourceSets.named("main") {
    xjcExtraArgs.addAll("-Xxew", "-Xsetters", "-XsimpleEquals", "-XsimpleHashCode")
}

dependencies {
    "xjcClasspath"("com.github.jaxb-xew-plugin:jaxb-xew-plugin:1.11")
    "xjcClasspath"("org.jvnet.jaxb2_commons:jaxb2-basics:0.13.1")

    // higher versions use the jakarta package name for javax dependencies
    // and are not compatible with the 'org.unbroken-dome.xjc' gradle plugin in version 2.0.0
    // -> don't update threeten-jaxb-core to a version higher than 1.2 and jakarta.xml.bind-api to a version higher than 2.3.3
    implementation("io.github.threeten-jaxb:threeten-jaxb-core:1.2")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:2.3.3")
}
