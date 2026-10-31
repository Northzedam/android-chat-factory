# Proceso operativo

## Aplicación nueva

1. Resolver el repositorio exacto y su rama predeterminada.
2. Inspeccionar visibilidad, permisos y contenido existente.
3. Crear un commit inicial si el repositorio está completamente vacío.
4. Copiar todos los archivos de `templates/native-lite`, incluyendo archivos ocultos.
5. Generar y completar `app-spec.yml`.
6. Cambiar nombre, `namespace`, `applicationId`, paquete Java, etiqueta, tema e icono.
7. Implementar requisitos y verificar XML, recursos y sintaxis Java.
8. Crear un único árbol Git y commit atómico.
9. Mover `main` con compare-and-swap usando el SHA esperado.
10. Monitorear el workflow automático.
11. Verificar el artifact y entregar enlaces.

## Aplicación existente

1. Leer `AGENTS.md`, `app-spec.yml`, rama y estado de CI.
2. Preservar cambios no relacionados.
3. Crear una rama `codex/<objetivo>` desde el SHA exacto de `main`.
4. Implementar y publicar commits pequeños y coherentes.
5. Abrir un pull request.
6. Verificar el workflow antes de integrar.
7. Integrar mediante GitHub cuando esté autorizado y volver a verificar `main`.

## Feedback

Actualizar el chat en cada etapa. Durante una compilación larga, consultar el job cada 15–30 segundos. No iniciar una segunda compilación mientras la primera siga activa.

## Política de reintentos

- Sin job creado: validar YAML y referencias de acciones.
- Job fallido: leer pasos y solo las líneas relevantes del log.
- Corregir antes de crear otra ejecución.
- No hacer más de una hipótesis por commit cuando la causa es observable.
