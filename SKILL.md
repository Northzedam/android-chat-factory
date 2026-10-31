---
name: android-chat-factory
description: Bootstrap, implement, publish, compile, diagnose, and deliver native Android applications from chat using the Northzedam Android Chat Factory and GitHub Actions, without npm or local desktop tooling.
---

# Android Chat Factory

Use this skill when the user asks to create or continue an Android application through chat, especially when they work only from a phone.

Announce that the Factory is being used and show a textual progress bar. Read `docs/process.md` before bootstrapping or publishing an application. Read `docs/architecture.md` before choosing or changing the application structure. Read `docs/signing.md` whenever application identity, signing, upgrades, releases, or repository visibility are relevant. Read `docs/troubleshooting.md` after any CI failure.

## Required outcome

Do not stop at instructions or source generation. Continue until all authorized in-scope work is complete and one of these outcomes is established:

1. A verified APK artifact exists and its repository, workflow run, commit, and download link are reported.
2. A specific external permission or user-only action blocks continuation, and all other work is complete.

## Golden path

1. Confirm the exact GitHub repository and inspect it read-only.
2. Never touch another repository.
3. If the repository is empty, bootstrap it from `templates/native-lite`.
4. Generate `app-spec.yml` from the user's natural-language requirements; never ask the user to edit it.
5. Replace the sample application name, package, colors, and Java package path consistently.
6. Implement only requested v1 functionality and platform permissions.
7. Prefer Android platform APIs. Add an external dependency only when a requested feature cannot reasonably be implemented with platform APIs, and record the reason.
8. Publish changes atomically using GitHub Git data APIs when local Git is unavailable.
9. Use a work branch and pull request for existing production applications. A new empty repository may be bootstrapped directly on `main`.
10. Monitor the workflow steps. Post progress at meaningful milestones and at least once per minute during active work.
11. On failure, inspect the failed step and narrow log excerpt, make a concrete correction, then create a new commit. Never rerun an unchanged failure.
12. Fetch and verify the APK artifact before declaring success.

## Progress protocol

Use these approximate stages:

- 10% repository verified
- 25% specification and architecture ready
- 50% core implementation complete
- 70% UI and error states complete
- 80% code published
- 90% Android SDK and Gradle ready
- 96% `assembleDebug` running
- 100% artifact verified

Commands that can wait on a network must have bounded waits. If a connector requests Connect, Reconnect, approval, or unavailable permissions, stop and tell the user exactly what action is required.

## Application rules

- Default profile: native Java 17 plus XML, min SDK 24.
- Interface language follows the user's request; default to Spanish.
- Network operations must run off the main thread with connect and read timeouts.
- Always implement visible loading, empty, success, and connection-error states where applicable.
- Declare only necessary Android permissions.
- Keep secrets out of source and logs.
- The bundled development key is for personal/debug installation only, never production distribution.
- Use the Factory workflow instead of copying build setup into each app.

## Handoff

Report the repository URL, final commit, successful workflow run, artifact expiration, and direct artifact link. Mention repository visibility and whether the APK is development-signed.
