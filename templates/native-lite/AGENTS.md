# Generated Android application instructions

These instructions apply to this application repository.

## Source of truth

Read `app-spec.yml` before changing code. Keep it synchronized with product identity, platform requirements, and artifact naming.

## Constraints

- Use native Java and XML unless the user explicitly authorizes a profile migration.
- Do not add Node.js, npm, Capacitor, React, Firebase, paid services, trackers, or advertising SDKs.
- Prefer Android platform APIs and document any required third-party dependency.
- Keep network work off the main thread and set connect/read timeouts.
- Implement visible loading, empty, success, and error states when applicable.
- Declare only permissions that are required by implemented functionality.
- Keep the `applicationId`, namespace, Java package, source path, and app-spec package aligned.
- Preserve the development signing configuration so APK updates remain installable.
- Never use the bundled development key for a production release.

## Delivery

Use the shared Android Chat Factory workflow. Show progress while working, inspect failed CI logs, correct failures, and do not declare completion until the APK artifact exists.

For an existing app, work on `codex/<goal>` and use a pull request unless the user explicitly requests a direct `main` update.
