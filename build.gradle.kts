import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

plugins {
    application
    kotlin("jvm") version Versions.kotlin
}

group = "com.androidmaestro"
version = "0.0.1"

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    // Kotlin
    implementation(Dependencies.kotlin)

    // Ktor
    implementation(Dependencies.Ktor.netty)
    implementation(Dependencies.Ktor.locations)
    implementation(Dependencies.Ktor.gson)

    // Koin for DI
    implementation(Dependencies.Koin.ktor)
    implementation(Dependencies.Koin.logger)

    // Logback
    implementation(Dependencies.logback)

    // Validation
    implementation(Dependencies.valiktor)

    // DB
    implementation(Dependencies.Database.postgreSql)
    implementation(Dependencies.Database.h2)
    implementation(Dependencies.Database.hikari)
    implementation(Dependencies.Database.flyway)
    implementation(Dependencies.Database.Exposed.core)
    implementation(Dependencies.Database.Exposed.dao)
    implementation(Dependencies.Database.Exposed.jdbc)
    implementation(Dependencies.Database.Exposed.javaTime)

    // Testing
    testImplementation(TestDependencies.Ktor.serverTests)
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")


