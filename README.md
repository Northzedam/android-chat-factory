# Android Chat Factory

Sistema reproducible para crear, modificar y compilar aplicaciones Android conversando con Codex desde un teléfono. La persona usuaria solamente describe la aplicación; Codex solicita y crea el repositorio, prepara el código, publica los commits, monitorea GitHub Actions y entrega el APK.

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

1. La persona indica por chat el nombre, objetivo y funciones de la aplicación.
2. Codex crea una solicitud de provisión autenticada en esta Factory.
3. GitHub Actions crea e inicializa un repositorio privado.
4. Codex usa `templates/native-lite`, completa `app-spec.yml` y desarrolla la aplicación.
5. El repositorio generado llama al workflow reutilizable de esta Factory.
6. Codex sigue la ejecución, corrige errores y entrega el enlace del APK.

Ejemplo de directiva:

> Creá una app de gastos personales en `Northzedam/mis-gastos` usando Android Chat Factory. Debe funcionar sin conexión y exportar CSV.

## Componentes

- [`SKILL.md`](SKILL.md): protocolo portable de ejecución para Codex.
- [`AGENTS.md`](AGENTS.md): reglas para mantener esta Factory.
- [`templates/native-lite`](templates/native-lite): proyecto Android base, compilable y sin dependencias externas.
- [`build-android.yml`](.github/workflows/build-android.yml): workflow reutilizable central.
- [`provision-repository.yml`](.github/workflows/provision-repository.yml): creación segura de repositorios desde solicitudes del chat.
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

## Creación de repositorios desde el chat

El provisionador escucha issues con el prefijo `[factory:create]`, pero solo ejecuta solicitudes cuyo autor sea el propietario `Northzedam`. Usa el secreto `REPO_CREATOR_TOKEN` y crea repositorios privados por defecto. Ver [docs/provisioning.md](docs/provisioning.md).

## Firma de desarrollo

La plantilla incluye una clave pública de desarrollo estable. Permite instalar una compilación sobre otra sin desinstalar la aplicación. No debe utilizarse para Play Store ni para distribuir una aplicación de producción. Ver [docs/signing.md](docs/signing.md).

## Costos

La Factory usa herramientas gratuitas y minutos de GitHub Actions incluidos en la cuenta. No activa servicios pagos.
