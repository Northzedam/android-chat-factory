# Diagnóstico de compilación

## El workflow falla sin crear jobs

La definición YAML es inválida o una expresión no puede evaluarse. Revisar especialmente valores `run:` que comienzan con comillas; usar bloques `run: |` para comandos complejos.

## `sdkmanager: command not found`

Invocar la ruta fijada por el workflow:

```bash
"$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager"
```

No asumir que `sdkmanager` está en `PATH`.

## `Failed to find package tools`

No usar `android-actions/setup-android` con su lista predeterminada antigua. La imagen fijada ya contiene command-line tools. Instalar únicamente plataforma, build-tools y platform-tools.

## Error de Gradle/AGP

Verificar la matriz documentada en el README. `AGP 8.7.3` usa `Gradle 8.9` y Java 17 en esta Factory.

## Error de recursos Android

Revisar primero la línea de `aapt2`, luego referencias `R.*`, nombres XML y existencia de recursos. No instalar dependencias para resolver errores de recursos locales.

## APK no publicado

Confirmar que `assembleDebug` terminó y que existe `app/build/outputs/apk/debug/app-debug.apk`. La acción de artifact debe usar una ruta relativa al checkout, no al `working-directory` del paso anterior.
