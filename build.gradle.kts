plugins {
  id("org.jetbrains.kotlin.jvm") version "1.9.21"
  id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
  id("org.jetbrains.dokka") version "1.7.20"
  `java-library`
  id("com.diffplug.spotless") version "6.15.0"
}

spotless {
  kotlin {
    target("**/*.kt")
    targetExclude("**/build/**")
    ktfmt("0.42").googleStyle()
  }
  kotlinGradle {
    target("**/*.gradle.kts")
    targetExclude("**/build/**")
    ktfmt("0.42").googleStyle()
  }
}

ext {
  set("PUBLISH_GROUP_ID", "dev.sasikanth")
  set("PUBLISH_ARTIFACT_ID", "android-resource-poet")
  set("PUBLISH_VERSION", "1.1.0")
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

apply(plugin = "org.jetbrains.dokka")

apply(from = "${rootDir}/scripts/publish-module.gradle")
