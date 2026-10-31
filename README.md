# Android Chat Factory

Sistema reproducible para crear, modificar y compilar aplicaciones Android conversando con Codex desde un teléfono. La persona usuaria solamente crea el repositorio de destino y describe la aplicación; Codex prepara el código, publica los commits, monitorea GitHub Actions y entrega el APK.

[![Factory smoke test](https://github.com/Northzedam/android-chat-factory/actions/workflows/factory-smoke-test.yml/badge.svg)](https://github.com/Northzedam/android-chat-factory/actions/workflows/factory-smoke-test.yml)

## Principios

- Android nativo con Java y XML como perfil estable inicial.
- Sin Node.js, npm, React, Capacitor, Firebase ni servicios pagos.
- Dependencias de aplicación externas deshabilitadas por defecto.
- Compilación pesada exclusivamente en GitHub Actions.
- Versiones de Java, Gradle, Android SDK y runner fijadas.
- Progreso visible, límites de tiempo y diagnóstico automático de fallas.
- La tarea termina únicamente cuando existe un APK descargable verificado.

## Flujo para una aplicación nueva

1. La persona crea un repositorio vacío, preferentemente privado.
2. Indica por chat el repositorio, objetivo y funciones de la aplicación.
3. Codex usa `templates/native-lite`, completa `app-spec.yml` y desarrolla la aplicación.
4. El repositorio generado llama al workflow reutilizable de esta Factory.
5. Codex sigue la ejecución, corrige errores y entrega el enlace del APK.

Ejemplo de directiva:

> Creá una app de gastos personales en `Northzedam/mis-gastos` usando Android Chat Factory. Debe funcionar sin conexión y exportar CSV.

## Componentes

- [`SKILL.md`](SKILL.md): protocolo portable de ejecución para Codex.
- [`AGENTS.md`](AGENTS.md): reglas para mantener esta Factory.
- [`templates/native-lite`](templates/native-lite): proyecto Android base, compilable y sin dependencias externas.
- [`build-android.yml`](.github/workflows/build-android.yml): workflow reutilizable central.
- [`factory-smoke-test.yml`](.github/workflows/factory-smoke-test.yml): compila la plantilla en cada actualización.
- [`docs`](docs): arquitectura, proceso, firma y diagnóstico.

## Contrato de estabilidad v1

| Componente | Versión |
| --- | --- |
| Runner | `ubuntu-24.04` |
| Java | 17 |
| Gradle | 8.9 |
| Android Gradle Plugin | 8.7.3 |
| compile/target SDK | 35 |
| min SDK | 24 |

Estas versiones se actualizan deliberadamente y solo después de que la prueba automática compile la plantilla.

## Firma de desarrollo

La plantilla incluye una clave pública de desarrollo estable. Permite instalar una compilación sobre otra sin desinstalar la aplicación. No debe utilizarse para Play Store ni para distribuir una aplicación de producción. Ver [docs/signing.md](docs/signing.md).

## Costos

La Factory usa herramientas gratuitas y minutos de GitHub Actions incluidos en la cuenta. No activa servicios pagos.
