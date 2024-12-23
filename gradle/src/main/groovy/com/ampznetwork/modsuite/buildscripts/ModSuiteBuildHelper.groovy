package com.ampznetwork.modsuite.buildscripts

import com.ampznetwork.modsuite.buildscripts.task.BuildArtifactsTask
import com.ampznetwork.modsuite.buildscripts.task.DownloadRequirementsTask
import com.ampznetwork.modsuite.buildscripts.task.PublishArtifactsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class ModSuiteBuildHelper implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.tasks.register('downloadRequirements', DownloadRequirementsTask)
        project.tasks.register('buildArtifactsTask', BuildArtifactsTask)
        project.tasks.register('publishArtifactsTask', PublishArtifactsTask)
    }
}