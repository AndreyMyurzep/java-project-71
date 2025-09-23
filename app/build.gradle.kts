plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.52.0"
    id("application")
    id("checkstyle")
    id("jacoco")
    id("org.sonarqube") version "6.3.1.5724"
}

application {
    mainClass = "hexlet.code.App"
}

sonar {
    properties {
        property("sonar.projectKey", "AndreyMyurzep_java-project-71")
        property("sonar.organization", "andreymyurzep")
    }
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

checkstyle {
    toolVersion = "10.12.4"
    configFile = file("${project.rootDir}/config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
    isShowViolations = true
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.19.0")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.19.0")
    implementation("org.yaml:snakeyaml:2.5")
}

tasks.test {
    useJUnitPlatform()
}
jacoco {
    toolVersion = "0.8.9"
}


//jacocoTestReport {
//    reports {
//        xml.enabled true
//        html.enabled true
//    }
//}