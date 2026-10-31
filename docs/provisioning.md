# Provisión de repositorios desde el chat

El provisionador permite crear repositorios sin salir del chat. Codex crea un issue en `Northzedam/android-chat-factory`; GitHub Actions valida que su autor sea el propietario y usa `REPO_CREATOR_TOKEN` para crear el repositorio.

## Contrato de solicitud

Título exacto:

```text
[factory:create] nombre-del-repositorio
```

Cuerpo JSON:

```json
{
  "name": "nombre-del-repositorio",
  "visibility": "private",
  "description": "Descripción breve",
  "dry_run": false
}
```

`visibility` admite `private` o `public` y usa `private` por defecto. `dry_run` valida el circuito sin crear un repositorio.

## Seguridad

- El job solo se ejecuta cuando el autor del issue es exactamente `Northzedam` y su asociación es `OWNER`.
- El secreto nunca se imprime ni se entrega a la aplicación creada.
- El nombre se limita a caracteres válidos de GitHub.
- La descripción se pasa como dato, nunca como comando.
- Los pull requests y comentarios no activan el provisionador.
- Los repositorios son privados salvo directiva explícita en contrario.
- Si el token expira, el issue queda abierto y el log informa el bloqueo.

Los issues pertenecen a una Factory pública. No incluir requisitos sensibles en la solicitud; la especificación detallada permanece en el chat y se escribe después en el repositorio privado.
