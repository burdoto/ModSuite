package com.ampznetwork.modsuite.buildscripts.task

import com.ampznetwork.modsuite.buildscripts.model.ArtifactMapping
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.bundling.Jar

import static com.ampznetwork.modsuite.buildscripts.Util.capitalize

class BuildArtifactsTask extends DefaultTask {
    @Input
    public final ListProperty<ArtifactMapping> mappings = project.objects.listProperty(ArtifactMapping);

    {
        group = "build"
        description = "This task builds all Artifacts that are registered with it"

        dependsOn mappings.get().collect { artifact ->
            project.tasks.maybeCreate("build${capitalize(artifact.name)}${capitalize(artifact.classifier)}Artifact${capitalize(project.name)}", Jar).configure {
                it.from artifact.components.get()
                it.setDestinationDirectory(project.layout.buildDirectory.dir('artifacts'))

                it.archiveBaseName = "$project.name-${artifact.name}-$project.version"
                it.archiveClassifier = artifact.classifier

                it.zip64 = true
            }
        }
    }

    Iterable<ArtifactMapping> find(String classifier) {
        return mappings.get().findAll { it.classifier == classifier }
    }
}
