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
val selenideVersion: String by project
val log4jSlf4jVersion: String by project
val log4jApiKotlinVersion: String by project
val okhttpVersion: String by project
val wireMockVersion: String by project
val mysqlConnectorJavaVersion: String by project
val kotlinJdbcVersion: String by project

dependencies {
  implementation("org.apache.logging.log4j:log4j-api-kotlin:$log4jApiKotlinVersion")
  implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
  implementation("com.codeborne:selenide:$selenideVersion")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonDataformatYamlVersion")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion")
  implementation("org.junit.jupiter:junit-jupiter")
  implementation(platform("org.junit:junit-bom:$junitBomVersion"))
  implementation("com.github.tomakehurst:wiremock-jre8:$wireMockVersion")
  implementation("mysql:mysql-connector-java:$mysqlConnectorJavaVersion")
  implementation("com.vladsch.kotlin-jdbc:kotlin-jdbc:$kotlinJdbcVersion")
  testImplementation("io.mockk:mockk:$mockkVersion")
  testImplementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jSlf4jVersion")
}

tasks.test {
  useJUnitPlatform()
  systemProperties.putAll(project.gradle.startParameter.systemPropertiesArgs)

  testLogging {
    events("passed", "skipped", "failed")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}
