# Arquitectura del perfil native-lite

`native-lite` es el camino estable por defecto. Busca reducir puntos de falla y mantener aplicaciones pequeñas.

## Capas recomendadas

- **UI:** una o más `Activity` con vistas XML y recursos Android.
- **Dominio:** clases Java sin dependencias de Android cuando sea posible.
- **Datos:** repositorios pequeños que encapsulan red, archivos, `SharedPreferences` o SQLite.
- **Plataforma:** permisos, notificaciones y servicios aislados detrás de clases específicas.

No es obligatorio crear todas las capas para aplicaciones pequeñas. Evitar abstracciones que no resuelvan una necesidad actual.

## Reglas técnicas

- Java 17 para compilación; usar APIs compatibles con min SDK 24.
- Sin AndroidX ni librerías externas en el perfil inicial.
- `HttpURLConnection` para HTTP/HTTPS y `org.json` o `JsonReader` para JSON.
- `ExecutorService` para trabajo en segundo plano y `runOnUiThread` para actualizar vistas.
- Tiempos máximos sugeridos: 10 segundos de conexión y 15 de lectura.
- Cerrar conexiones, streams y ejecutores.
- Recursos visibles en `res/values`; evitar textos de interfaz incrustados en Java.
- Soportar pantallas pequeñas y barras del sistema.

## Identidad

Cada app debe tener un `applicationId` único y estable. Cambiarlo crea una aplicación distinta en Android. El paquete Java, namespace y ruta de fuentes deben mantenerse alineados.

## Cuándo crear otro perfil

Kotlin, Compose, CameraX u otras bibliotecas deben incorporarse como perfiles separados y probados. No convertir `native-lite` en una plantilla universal con dependencias opcionales.
