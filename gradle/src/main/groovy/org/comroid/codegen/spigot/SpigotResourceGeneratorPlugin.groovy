package org.comroid.codegen.spigot

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSetContainer

class SpigotResourceGeneratorPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        if (!project.plugins.hasPlugin('java'))
            throw new IllegalStateException("A java module is required")

        project.configurations.compileClasspath.extendsFrom project.configurations.create('generated')

        def sources = project.extensions.getByType(SourceSetContainer)
        sources.maybeCreate('generated').java.srcDirs "${project.layout.buildDirectory.get().asFile.absolutePath}/generated/sources/r"

        def tasks = project.tasks
        var task = tasks.register("generateSpigotResourceClasses", GenerateSpigotResourceClassesTask).get().configure {
            it.group = 'build'
            it.description = 'Generates Resource Accessors for Spigot plugin.yml and other resources'
        }
        tasks.named('compileJava').get().dependsOn task
    }
}