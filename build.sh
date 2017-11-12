#!/bin/sh
for f in *; do
    if [[ -d $f ]]; then
        # $f is a directory
        cd $f && ./gradlew clean build
    fi
done
