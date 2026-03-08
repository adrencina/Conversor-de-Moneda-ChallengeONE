package lad.com.alura.conversormoneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversor {
    // Almacenamos temporalmente las conversiones de la sesión
    private static final List<String> historial = new ArrayList<>();

    public static void eleccionUserMenu() {
        Scanner lectura = new Scanner(System.in);
        String apiKey = "eda8fc291263a25bf1575fb7";
        int opcion = 0;

        // Bucle principal para que el programa no se cierre hasta elegir Salir
        while (opcion != 10) {
            System.out.println("***************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Euro");
            System.out.println("8) Euro =>> Dólar");
            System.out.println("9) Ver historial de conversiones");
            System.out.println("10) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("***************************************************");

            try {
                // Leemos la opción como texto para evitar problemas con el búfer del Scanner
                opcion = Integer.parseInt(lectura.nextLine());

                if (opcion == 10) break;

                // Llamamos al método de conversión según la opción elegida
                switch (opcion) {
                    case 1 -> realizarConversion("USD", "ARS", lectura, apiKey);
                    case 2 -> realizarConversion("ARS", "USD", lectura, apiKey);
                    case 3 -> realizarConversion("USD", "BRL", lectura, apiKey);
                    case 4 -> realizarConversion("BRL", "USD", lectura, apiKey);
                    case 5 -> realizarConversion("USD", "COP", lectura, apiKey);
                    case 6 -> realizarConversion("COP", "USD", lectura, apiKey);
                    case 7 -> realizarConversion("USD", "EUR", lectura, apiKey);
                    case 8 -> realizarConversion("EUR", "USD", lectura, apiKey);
                    case 9 -> mostrarHistorial();
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número del 1 al 10.");
            }
        }
        System.out.println("Programa finalizado. ¡Hasta luego!");
    }

    private static void realizarConversion(String base, String target, Scanner lectura, String apiKey) {
        System.out.println("Ingrese el valor que desea convertir:");
        try {
            double valor = Double.parseDouble(lectura.nextLine());
            
            // Construimos la URL personalizada para la pareja de monedas
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base + "/" + target;
            
            double tasa = ConversorApp.obtenerTasa(url);
            double resultado = valor * tasa;

            // Registro de marca de tiempo para el historial
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            String log = String.format("[%s] %.2f %s => %.2f %s", fecha, valor, base, resultado, target);
            historial.add(log);

            System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n%n", 
                             valor, base, resultado, target);
        } catch (NumberFormatException e) {
            System.out.println("Valor numérico no válido.");
        } catch (Exception e) {
            System.out.println("Error en la conexión con el servidor.");
        }
    }

    private static void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Aún no se han realizado conversiones.");
        } else {
            System.out.println("--- HISTORIAL DE LA SESIÓN ---");
            historial.forEach(System.out::println);
            System.out.println("------------------------------");
        }
        System.out.println("");
    }
}
