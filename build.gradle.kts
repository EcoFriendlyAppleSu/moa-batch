import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion = "3.4.2"
val mybatisVersion = "3.0.4"
val postgresqlVersion = "42.7.5"
val jacksonVersion = "2.18.2"
val coroutineVersion = "1.10.1"

// current plugins setting
plugins {
	  id("org.springframework.boot") version "3.3.2"
	  id("io.spring.dependency-management") version "1.1.4"

	  kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.10"
}

group = "dev.indie.moa"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	mavenLocal()
}

tasks.kotlinSourcesJar {
	archiveClassifier = "sources"
}

configurations.all {
	resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
}

tasks.test {
	useJUnitPlatform()
}

dependencies {
	// spring
	implementation("org.springframework.boot:spring-boot:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-logging:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-jdbc:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-batch:$springBootVersion")
	// postgresql
	implementation("org.postgresql:postgresql:$postgresqlVersion")
	// mybatis
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:$mybatisVersion")
	// coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
	// jackson
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
	implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
	implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
	// snakeyaml
	implementation("org.yaml:snakeyaml:2.2")
	// log
	implementation("org.slf4j:slf4j-api:2.0.17")
	implementation("ch.qos.logback:logback-classic:1.5.17")
	implementation("ch.qos.logback:logback-core:1.5.17")
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jar {
	manifest.attributes["Main-Class"] = "dev.indie.moa.batch.MoaBatchApplicationKt"
	val dependencies = configurations
		.runtimeClasspath
		.get()
		.map(::zipTree)
	from(dependencies)
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
