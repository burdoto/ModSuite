package com.ampznetwork.modsuite.buildscripts.task

import com.ampznetwork.modsuite.buildscripts.model.FileRequirement
import de.undercouch.gradle.tasks.download.Download
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input

import static com.ampznetwork.modsuite.buildscripts.Util.capitalize

class DownloadRequirementsTask extends DefaultTask {
    @Input
    public final ListProperty<FileRequirement> neededFiles = getProject().getObjects().listProperty(FileRequirement);

    {
        group = "setup"
        description = "This task downloads all required files that are registered with it"

        dependsOn neededFiles.get().collect { f ->
            project.tasks.maybeCreate("download${capitalize(f.name)}For${capitalize(project.name)}", Download).configure {
                it.src f.url

                var destPath = "${f.path}/${f.name}"
                outputs.file destPath
                it.dest destPath
            }
        }
    }
}