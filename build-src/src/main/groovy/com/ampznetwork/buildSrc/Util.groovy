package com.ampznetwork.buildSrc

import java.time.Instant;

class Util {
    static int getCommitTimestampMinutes() {
        def result = new StringBuilder()
        var proc = 'git log -1 --format=%ct'.execute()
        proc.consumeProcessOutputStream(result)
        proc.waitFor()

        long seconds
        if (result.toString().isBlank())
            seconds = (long) (Instant.now().toEpochMilli() / 1000)
        else seconds = result.toString().trim().toLong()
        return (int) seconds / 600
    }

    static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)).toString() + str.substring(1)
    }
}
