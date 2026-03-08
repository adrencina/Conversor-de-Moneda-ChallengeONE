# Conversor de Monedas - Challenge ONE Java

Bienvenido al **Conversor de Monedas**, un desafío de programación desarrollado como parte del programa **Oracle Next Education (ONE)** en conjunto con **Alura**.

Este proyecto consiste en una aplicación de consola en Java que permite realizar conversiones de divisas en tiempo real utilizando la **ExchangeRate-API**.

## 📋 Características

- **Conversión en tiempo real:** Obtiene las tasas de cambio actualizadas directamente desde una API externa.
- **Interfaz interactiva:** Menú de opciones amigable para el usuario a través de la consola.
- **Soporte multimoneda:** Conversiones entre Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL), Peso Colombiano (COP) y Euro (EUR).
- **Historial de búsquedas:** Registro detallado de todas las conversiones realizadas durante la sesión.
- **Marcas de tiempo:** Cada conversión queda registrada con la fecha y hora exacta de la consulta.
- **Manejo de errores:** Validación de entradas de usuario para asegurar la estabilidad del programa.

## 🛠️ Tecnologías Utilizadas

- **Java 17 (LTS):** Lenguaje de programación principal.
- **Gson 2.11.0:** Biblioteca de Google para el procesamiento y mapeo de datos JSON.
- **HttpClient:** Para la gestión de solicitudes y respuestas HTTP.
- **ExchangeRate-API:** Servicio externo para la obtención de tasas de cambio.

## 🚀 Instalación y Ejecución

### Requisitos previos
- Tener instalado **Java JDK 17** o superior.
- Contar con una **API Key** de [ExchangeRate-API](https://www.exchangerate-api.com/).

### Instrucciones de ejecución
1. Clona este repositorio o descarga los archivos.
2. Asegúrate de tener la librería `gson-2.11.0.jar` en la carpeta `lib/`.
3. Compila el proyecto desde la terminal:
   ```bash
   javac -d bin -cp "lib/gson-2.11.0.jar" src/lad/com/alura/conversormoneda/*.java
   ```
4. Ejecuta la aplicación:
   ```bash
   java -cp "bin:lib/gson-2.11.0.jar" lad.com.alura.conversormoneda.ConversorApp
   ```

## 📂 Estructura del Proyecto

- `src/`: Contiene el código fuente organizado por paquetes.
- `lib/`: Carpeta para las bibliotecas externas (JARs).
- `bin/`: Archivos compilados del proyecto (.class).
- `README.md`: Documentación del proyecto.

## ✒️ Autor
**Adrian** - *Desarrollo de Software* - [GitHub](https://github.com/adrencina)
