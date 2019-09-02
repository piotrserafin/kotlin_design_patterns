import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"

}

group = "dev.piotrserafin"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.12")
}

tasks.test {
    useJUnit()

    maxHeapSize = "1G"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
