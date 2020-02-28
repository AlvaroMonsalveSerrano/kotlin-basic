/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    kotlin("jvm") version "1.3.61"

    // Apply the application plugin to add support for building a CLI application.
    application
}

group = "es.ams"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    jcenter()

    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.ninja-squad:springmockk:1.1.3")
}

application {
    // Define the main class for the application.
    mainClassName = "es.ams.app.AppKt"
}

// Para el tratamiento de valores null.
tasks.withType<KotlinCompile>{
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
