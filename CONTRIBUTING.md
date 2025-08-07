the intellij run configs shipped give many options to start various parts of the project

# before first start

## git clone

```bash
git clone https://github.com/burdoto/ModSuite --recurse-submodules
```

## buildscript dependencies

needs a version of japi published at least to maven local.

```bash
(cd japi && ./gradlew publishToMavenLocal)
```

## intellij run config dependencies

needs docker installed and ready to the current user

# test runs

anything here will be handled by intellij run configurations

## before test server runs

requires server and dependency jars [as defined](https://github.com/burdoto/ModSuite/blob/main/gradle/scripts/setup/requirements.gradle#L7) to be present

```bash
./gradlew downloadRequirements
```

and build & copy plugins into respective `run/` directory

```bash
./gradlew prepareSpigotTest
```

```bash
./gradlew prepareFabricTest
```

# committing

simply open a pr in each respective repository where necessary
