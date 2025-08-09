#!/usr/bin/bash

git fetch --all && git reset --hard origin/main
(cd japi && ./gradlew publishToMavenLocal && echo "japi was built and published locally") || (echo "Could not build japi" && exit 1)
./gradlew clean prepareSpigotTest prepareFabricTest || echo "Could not build ModSuite Files"
