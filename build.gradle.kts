plugins {
    id("net.kyori.indra") version "2.0.2"
    id("net.kyori.indra.checkstyle") version "2.0.2"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "broccolai"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("com.destroystokyo.paper", "paper-api", "1.16.5-R0.1-SNAPSHOT")
}

tasks {
    indra {
        javaVersions {
            target(16)
        }
    }

    build {
        dependsOn(shadowJar)
    }

    processResources {
        expand("version" to rootProject.version)
    }

    shadowJar {
        archiveClassifier.set(null as String?)
        archiveFileName.set(project.name + ".jar")
    }
}
