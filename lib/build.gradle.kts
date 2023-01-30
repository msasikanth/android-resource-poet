plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
    `java-library`
}

ext {
    set("PUBLISH_GROUP_ID", "dev.sasikanth")
    set("PUBLISH_ARTIFACT_ID", "android-resource-poet")
    set("PUBLISH_VERSION", "1.0.0")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("com.google.truth:truth:1.1.3")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")
