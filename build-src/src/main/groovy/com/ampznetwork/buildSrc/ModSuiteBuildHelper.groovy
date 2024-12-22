package com.ampznetwork.buildSrc

import com.ampznetwork.buildSrc.task.BuildArtifactsTask
import com.ampznetwork.buildSrc.task.DownloadRequirementsTask
import com.ampznetwork.buildSrc.task.PublishArtifactsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class ModSuiteBuildHelper implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.tasks.register('downloadRequirements', DownloadRequirementsTask)
        project.tasks.register('buildArtifactsTask', BuildArtifactsTask)
        project.tasks.register('PublishArtifactsTask', PublishArtifactsTask)
    }
}