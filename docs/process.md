# Proceso operativo

## Aplicación nueva

1. Resolver el nombre deseado y comprobar que no exista.
2. Crear una solicitud según `docs/provisioning.md` y monitorear su workflow.
3. Esperar hasta que el nuevo repositorio aparezca en la conexión de GitHub.
4. Inspeccionar visibilidad, permisos y contenido inicial.
5. Copiar todos los archivos de `templates/native-lite`, incluyendo archivos ocultos.
6. Generar y completar `app-spec.yml`.
7. Cambiar nombre, `namespace`, `applicationId`, paquete Java, etiqueta, tema e icono.
8. Implementar requisitos y verificar XML, recursos y sintaxis Java.
9. Crear un único árbol Git y commit atómico.
10. Mover `main` con compare-and-swap usando el SHA esperado.
11. Monitorear el workflow automático.
12. Verificar el artifact y entregar enlaces.

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
