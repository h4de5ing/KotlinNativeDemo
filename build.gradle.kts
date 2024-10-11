plugins {
    kotlin("multiplatform") version "2.0.21"
}

group = "org.github.h4de5ing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    jvmToolchain(19)
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "org.github.h4de5ing.main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting {

        }
    }
}
tasks.withType<Wrapper> {
    gradleVersion = "8.9"
    distributionType = Wrapper.DistributionType.BIN
}