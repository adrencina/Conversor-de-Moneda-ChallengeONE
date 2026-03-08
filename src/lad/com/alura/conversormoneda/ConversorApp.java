package lad.com.alura.conversormoneda;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Punto de entrada de la aplicación
        Conversor.eleccionUserMenu();
    }

    // Método técnico para conectar con la API y obtener la tasa de cambio
    public static double obtenerTasa(String urlFinal) {
        HttpClient client = HttpClient.newHttpClient();
        
        // Configuramos la solicitud GET a la URL de la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .GET()
                .build();

        try {
            // Enviamos la petición y recibimos la respuesta en formato String (JSON)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Usamos Gson para parsear el JSON y extraer solo el valor que nos interesa
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            
            return jsonObject.get("conversion_rate").getAsDouble();
        } catch (IOException | InterruptedException e) {
            // Manejamos posibles fallos de red o conexión
            throw new RuntimeException("Error al procesar la respuesta de la API");
        }
    }
}
