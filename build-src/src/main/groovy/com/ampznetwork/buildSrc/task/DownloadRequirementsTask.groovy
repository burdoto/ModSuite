package com.ampznetwork.buildSrc.task

import com.ampznetwork.buildSrc.Util
import com.ampznetwork.buildSrc.model.FileRequirement
import de.undercouch.gradle.tasks.download.Download
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input

class DownloadRequirementsTask extends DefaultTask {
    @Input
    public final ListProperty<FileRequirement> neededFiles = getProject().getObjects().listProperty(FileRequirement);

    {
        group = "setup"
        group = "This task downloads all required files that are registered with it"

        project.afterEvaluate {
            dependsOn neededFiles.get().collect { f ->
                project.tasks.maybeCreate("download${Util.capitalize(f.name)}For${Util.capitalize(project.name)}", Download).configure {
                    it.src f.url

                    var destPath = "${f.path}/${f.name}"
                    outputs.file destPath
                    it.dest destPath
                }
            }
        }
    }
}