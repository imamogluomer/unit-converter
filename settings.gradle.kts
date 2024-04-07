pluginManagement {
    repositories {
<<<<<<< HEAD
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
=======
        google()
>>>>>>> 741666d5f531318a1e5e769ec80c69d668a6c7fa
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
rootProject.name = "CounterApp"
=======
rootProject.name = "UnitConverter"
>>>>>>> 741666d5f531318a1e5e769ec80c69d668a6c7fa
include(":app")
 