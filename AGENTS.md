# Android Chat Factory maintenance instructions

These instructions apply to this entire repository.

## Goal

Keep the Factory reproducible for users who operate exclusively from a phone and communicate through Codex. Prefer predictability over novelty.

## Invariants

- Do not introduce Node.js, npm, Capacitor, React, Firebase, paid services, or mandatory local tooling.
- Keep `templates/native-lite` compilable using only the Android SDK and Java standard/platform APIs.
- Pin the runner and build tool versions. Never replace a pinned version with `latest` without a dedicated compatibility test.
- Keep the reusable workflow callable by repositories owned by `Northzedam`.
- Preserve the stable development signing strategy and automatic `versionCode` behavior.
- Every workflow must have explicit permissions and a timeout.
- Do not report completion until the smoke test produced its APK artifact.

## Change procedure

1. Explain the intended compatibility change.
2. Update documentation and template together.
3. Validate XML and resource references locally when possible.
4. Commit atomically.
5. Monitor `factory-smoke-test.yml` through completion.
6. Inspect only the failed job and relevant log lines if it fails.
7. Correct and retry; do not rerun unchanged failures.

Use Spanish for user-facing text and documentation. Code identifiers may remain in English.
