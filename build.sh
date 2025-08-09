#!/usr/bin/bash

git fetch --all && git reset --hard origin/main

# prepare buildscript dependency
(cd japi && ./gradlew publishToMavenLocal && echo "japi was built and published locally") || (echo "Could not build japi" && exit 1)

# cleanup & run tests to show results of current build
./gradlew clean test

# try to build
./gradlew prepareSpigotTest prepareFabricTest || (echo "Could not build ModSuite Files" && exit 1)
