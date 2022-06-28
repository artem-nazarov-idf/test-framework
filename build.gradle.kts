import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.6.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val jacksonDataformatYamlVersion: String by project
val jacksonModuleKotlinVersion: String by project
val junitBomVersion: String by project
val mockkVersion: String by project

dependencies {
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonDataformatYamlVersion")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion")
  testImplementation(platform("org.junit:junit-bom:$junitBomVersion"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks.test {
  useJUnitPlatform()
  systemProperty("config.file.type", System.getProperty("config.file.type"))


  testLogging {
    events("passed", "skipped", "failed")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}
