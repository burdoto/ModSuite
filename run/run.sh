#!/bin/bash

if [[ -z "$1" ]] || [[ -z "$2" ]]; then
  echo 'Must define server type (spigot, fabric, ...) as first argument and jar type (spigot, paper, arclight, ...) as second'
  exit 1
fi



cd "$1" || (echo 'Could not cd into server directory' && exit)

# apply defaults
cp -rf .defaults/* .

# launch server
java -Xmx4G -jar "$2" nogui
