#!/bin/bash
set -x

BUILD_NUMBER=5
COMMIT_HASH=$(git rev-parse HEAD)

echo "Gradle clean"
./gradlew clean

echo "Gradle build"
./gradlew build -PPACKAGE_VERSION=1.1.$BUILD_NUMBER -PBUILD_NUMBER=$BUILD_NUMBER -PBUILD_SOURCEVERSION=$COMMIT_HASH -PallEditable=false