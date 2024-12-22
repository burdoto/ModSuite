package com.ampznetwork.buildSrc.task

import com.ampznetwork.buildSrc.model.ArtifactMapping
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input

class BuildArtifactsTask extends DefaultTask {
    @Input
    public final ListProperty<ArtifactMapping> mappings = project.objects.listProperty(ArtifactMapping)

    Iterable<ArtifactMapping> find(String classifier) {
        return mappings.get().findAll { it.classifier == classifier }
    }
}
