#!/usr/bin/bash

git pull

# prepare buildscript dependency
(cd japi && ./gradlew publishToMavenLocal && echo "japi was built and published locally") || (echo "Could not build japi" && exit 1)

# cleanup & run tests to show results of current build
./gradlew clean test

# try to build
./gradlew :ChatMod:discord:run || (echo "Could not execute DiscordBot" && exit 1)
