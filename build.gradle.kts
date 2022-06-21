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

dependencies {
  val implementation by configurations
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonDataformatYamlVersion")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion")
  testImplementation(platform("org.junit:junit-bom:$junitBomVersion"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Test> {
  useJUnitPlatform()
  systemProperty("fileExtension", System.getProperty("fileExtension", "json"))
  systemProperties.putAll(project.gradle.startParameter.systemPropertiesArgs)

  testLogging {
    events("passed", "skipped", "failed")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}
