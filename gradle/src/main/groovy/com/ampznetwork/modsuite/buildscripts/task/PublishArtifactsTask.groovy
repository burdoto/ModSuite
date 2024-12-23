package com.ampznetwork.modsuite.buildscripts.task

import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.publish.PublicationContainer
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.tasks.Input

class PublishArtifactsTask extends DefaultTask {
    @Input
    Action<RepositoryHandler> repositories
    @Input
    Action<PublicationContainer> publications
    @Input
    Action<MavenPom> pom
}
