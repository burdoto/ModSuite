package com.ampznetwork.modsuite.buildscripts.model

import lombok.Value
import org.jetbrains.annotations.Nullable

@Value
class FileRequirement {
    String name
    String path
    String url
    @Nullable
    String md5url

    FileRequirement(String name, String path, String url, @Nullable String md5url = null) {
        this.name = name
        this.path = path
        this.url = url
        this.md5url = md5url
    }
}