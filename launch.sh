#!/usr/bin/bash

./pull.sh

# prepare buildscript dependency
(cd japi && ./gradlew publishToMavenLocal && echo "japi was built and published locally") || (echo "Could not build japi" && exit 1)

# cleanup & run tests to show results of current build
./gradlew clean test

# try to build
./gradlew :ChatMod:discord:installDist || (echo "Could not build DiscordBot" && exit 1)
./ChatMod/discord/build/install/discord/bin/discord
