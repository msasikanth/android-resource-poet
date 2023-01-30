plugins {
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    id("org.jetbrains.dokka") version "1.7.20"
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

apply(from = "${rootDir}/scripts/publish-root.gradle")
