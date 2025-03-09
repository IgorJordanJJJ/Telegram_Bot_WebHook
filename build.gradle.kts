plugins {
    java
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "ru.jordan"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(19)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.23.1")
    implementation("org.modelmapper:modelmapper:3.1.1")
    implementation("org.telegram:telegrambots-spring-boot-starter:6.9.7.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.1")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-amqp
    implementation("org.springframework.boot:spring-boot-starter-amqp:3.3.1")
    // https://mvnrepository.com/artifact/org.springframework.amqp/spring-rabbit
    //implementation("org.springframework.amqp:spring-rabbit:3.1.6")
    implementation("org.liquibase:liquibase-core")
    implementation("org.springframework.amqp:spring-rabbit-stream")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    //developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("com.oracle.database.jdbc:ojdbc11")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.amqp:spring-rabbit-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
