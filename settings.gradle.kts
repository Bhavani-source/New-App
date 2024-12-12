pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

    }
    /*plugins {
        id("com.google.devtools.ksp") version "1.8.0-1.0.10"  // Update to this version or similar
    }*/

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}


rootProject.name = "ComposeEcartapp"
include(":app")
 