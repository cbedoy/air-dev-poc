# AGENTS.md

## Project Overview
- Android app project with a single module: `:app`.
- Build system: Gradle Kotlin DSL via the wrapper scripts `./gradlew` and `gradlew.bat`.
- UI stack: Jetpack Compose with Material 3.
- Package/application id: `com.mx.airdevexample`.
- Main entry point: `app/src/main/java/com/mx/airdevexample/MainActivity.kt`.

## Repository Structure
- `app/`: Android application module.
- `app/src/main/java/com/mx/airdevexample/`: Kotlin source for the app.
- `app/src/main/res/`: Android resources.
- `app/src/test/`: local JVM unit tests.
- `app/src/androidTest/`: instrumentation and UI tests.
- `gradle/libs.versions.toml`: centralized dependency and plugin versions.
- `build.gradle.kts`, `settings.gradle.kts`: top-level Gradle configuration.

## Working Agreements
- Prefer changes that fit the existing single-module structure unless a multi-module split is explicitly requested.
- Preserve Kotlin DSL conventions already used in Gradle files.
- For UI changes, keep Compose code localized and avoid introducing XML layouts unless requested.
- When adding dependencies, update `gradle/libs.versions.toml` first and consume them through aliases where practical.
- Keep package names under `com.mx.airdevexample` unless there is a deliberate refactor.
- Do not edit `local.properties` for normal feature work.
- Do not commit generated outputs, IDE noise, or build artifacts.

## Kotlin And Compose Conventions
- Prefer small, focused composables and helper files over growing `MainActivity.kt` into a large screen file.
- Keep state hoisting straightforward: UI state should be passed down through composable parameters unless a more structured state holder is clearly justified.
- Reuse the existing app theme and resource names instead of introducing parallel styling systems.
- Prefer descriptive function and file names tied to app features or screens.
- Keep preview functions near the composables they validate when that remains readable.

## Gradle And Dependency Rules
- Use the Gradle wrapper for project tasks.
- Keep plugin and library versions centralized in `gradle/libs.versions.toml`.
- Prefer existing AndroidX and Compose dependencies before introducing new libraries.
- When changing SDK or toolchain settings, keep `app/build.gradle.kts`, top-level Gradle files, and dependency versions aligned.

## Testing Expectations
- Put pure logic tests in `app/src/test/`.
- Put device or Compose UI tests in `app/src/androidTest/`.
- For narrow changes, run the smallest relevant task first.
- If no automated test is added, state why the change does not justify one or what remains unverified.

## Common Commands
- Build debug app: `./gradlew :app:assembleDebug`
- Run unit tests: `./gradlew :app:testDebugUnitTest`
- Run instrumentation tests: `./gradlew :app:connectedDebugAndroidTest`
- Lint app: `./gradlew :app:lintDebug`

## Implementation Notes
- `MainActivity` currently hosts Compose content directly with `AirDevExampleTheme`.
- The app currently uses a minimal starter structure; if adding screens or state, prefer creating focused files under `app/src/main/java/com/mx/airdevexample/` instead of expanding `MainActivity.kt` indefinitely.
- Theme resources exist under `app/src/main/res/values/`; align new styling work with the existing app theme.
- The manifest currently declares a single launcher activity.

## Release And Delivery Notes
- There is no release-specific customization in the repo beyond the default `release` build type and ProGuard rules file.
- If release behavior changes, document any signing, shrinking, manifest, or environment assumptions in this file.
- Before handing off a release-oriented change, call out whether it was verified only with debug tasks or with a release build as well.

## Validation Expectations
- After code changes, prefer validating with the smallest relevant Gradle task before suggesting broader verification.
- If a change affects UI behavior, mention whether it was validated by build only, tests, or on-device/emulator run.
- Do not edit generated files or build outputs.
