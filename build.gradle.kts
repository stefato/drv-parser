plugins {
    id("com.palantir.git-version") version "0.15.0" apply false
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "com.palantir.git-version")

    group = "de.luebeckregatta"
    val gitVersion: groovy.lang.Closure<String> by extra
    version = gitVersion()

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_11
    }

    configure<PublishingExtension> {
        publications {
            create<MavenPublication>("library") {
                from(components["java"])
            }
        }
        repositories {
            maven {
                val rootApiUrl = System.getenv("CI_API_V4_URL")
                val projectId = System.getenv("CI_PROJECT_ID")
                url = uri("$rootApiUrl/projects/$projectId/packages/maven")
                name = "Gitlab"
                credentials(HttpHeaderCredentials::class) {
                    name = "Job-Token"
                    value = System.getenv("CI_JOB_TOKEN")
                }
                authentication {
                    create<HttpHeaderAuthentication>("header")
                }
            }
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        reports {
            junitXml.required.set(true)
        }
    }
}


