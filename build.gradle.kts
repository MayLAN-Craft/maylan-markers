plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.4.1"
}

group = "dev.deimoslabs"
version = "0.10.1"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven ( "https://repo.bluecolored.de/releases" )
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")
    compileOnly("de.bluecolored:bluemap-api:2.7.8")
}

tasks.compileJava {
    options.encoding = Charsets.UTF_8.name()
    options.release.set(25)
}

tasks.processResources {
    filteringCharset = "UTF-8"
    filesMatching(listOf("plugin.yml", "**/*.yml", "**/*.yaml", "**/*.properties", "**/*.txt", "**/*.md")) {
        expand(
            mapOf(
                "version" to project.version,
                "name" to project.name
            )
        )
    }
    inputs.property("version", project.version)
}

tasks.shadowJar {
    archiveClassifier.set("")
    mergeServiceFiles()
}

tasks.jar {
    enabled = false
}

tasks.assemble {
    dependsOn(tasks.shadowJar)
}
