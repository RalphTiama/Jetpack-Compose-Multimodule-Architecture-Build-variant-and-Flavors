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

rootProject.name = "SneakerUps"
include(":app", ":core", ":featureModuleA", ":featureModuleB")
include(":featureModuleD")
include(":featureModuleB:account")



include(":featureHomeModule")
include(":featureHomeModule:data")
include(":featureHomeModule:presentation")
