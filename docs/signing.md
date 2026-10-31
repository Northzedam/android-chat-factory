# Firma y actualizaciones

Android exige que las actualizaciones de una aplicación estén firmadas con la misma clave y tengan un `versionCode` superior.

## Desarrollo personal

La plantilla incluye `app/factory-debug.keystore` con credenciales públicas de desarrollo. Esto garantiza una firma estable entre runners de GitHub Actions y permite instalar una compilación sobre la anterior.

Esta clave es intencionalmente pública y solo sirve para desarrollo:

- No demuestra identidad del autor.
- Cualquier persona puede firmar un APK con ella.
- No debe utilizarse para Play Store, tiendas alternativas ni distribución comercial.

Los repositorios de aplicaciones personales deberían ser privados, aunque la clave siga considerándose no secreta.

## Versionado

En GitHub Actions, `versionCode` toma `GITHUB_RUN_NUMBER`. En compilaciones fuera de CI usa `1`. El nombre visible de versión permanece definido en `app/build.gradle`.

## Producción

Una app destinada a distribución necesita una clave única generada para su propietario y guardada como secreto. Configurar secretos o custodiar una clave privada puede requerir una acción explícita del usuario y queda fuera del perfil v1 sin secretos.
