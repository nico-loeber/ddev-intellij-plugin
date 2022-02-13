plugins {
    id("org.jetbrains.intellij") version "1.3.1"
    java
}

group = "de.php_perfect.intellij.ddev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.3.2")
    type.set("IU")
    plugins.add("com.jetbrains.php:213.6777.58")
    plugins.add("org.jetbrains.plugins.phpstorm-remote-interpreter:213.5744.125")
    plugins.add("org.jetbrains.plugins.remote-run")
    plugins.add("org.jetbrains.plugins.phpstorm-docker:213.5744.125")
    plugins.add("Docker:213.6461.58")
}
tasks {
    patchPluginXml {
        changeNotes.set(
            """
            Add change notes here.<br>
            <em>most HTML tags may be used</em>        """.trimIndent()
        )
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
