#!/usr/bin/bash

function pull() {
  if [ -z "$1" ]; then
    branch="main"
  else
    branch="$1"
  fi

  if [ -f "force_commit.txt" ]; then
    echo "Checking out $(cat "force_commit.txt")"
    git checkout "$(cat "force_commit.txt")"
    return
  elif [ "$(git show-ref --verify --quiet "refs/heads/$branch")" ]; then
    echo "Checking out $branch"
    git checkout "$branch"
  fi

  echo "Pulling changes..."
  git pull
}

(
  cd '../japi' || exit;
  pull 'main';
  ./gradlew --no-daemon "clean publishToMavenLocal";
)

pull 'main';
./gradlew --no-daemon ":ChatMod:discord:run";
