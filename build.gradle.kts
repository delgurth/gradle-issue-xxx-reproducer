plugins {
    id("com.gorylenko.gradle-git-properties") version "2.5.0"
    java
}

gitProperties {
    dotGitDirectory = project.rootProject.layout.projectDirectory.dir(".git")
}

tasks.register("finalize") {
    doLast {
        if (layout.buildDirectory.file("resources/main/git.properties").get().asFile.exists()) {
            println("we have the git.properties file")
        } else {
            throw IllegalStateException("git.properties file is missing!")
        }
    }
}
