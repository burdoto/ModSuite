package com.ampznetwork.buildSrc.model

import lombok.Value
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.Provider

@Value
class ArtifactMapping {
    String name
    Provider<FileCollection> components
    String classifier

    ArtifactMapping(String name, Provider<FileCollection> components, String classifier) {
        this.name = name
        this.components = components
        this.classifier = classifier
    }
}
