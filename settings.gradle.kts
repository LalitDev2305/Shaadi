pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Shaadi"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":network")
include(":features:home")
include(":features:home:data")
include(":features:home:domain")
include(":common:data")
include(":common:domain")
include(":common:utils")


include(":theme")
include(":database")
