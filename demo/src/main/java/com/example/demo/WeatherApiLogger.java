package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.json.JSONObject;

public class WeatherApiLogger {

    private static final String API_KEY = "954b386c14df4e2cbdb43746250907";
    private static final String BASE_URL =
            "https://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no";
    private static final String LOG_FILE = "C:\\Users\\Dell\\java-program\\demo\\src\\main\\java\\com\\example\\demo\\weather_log.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();

        try {
            String url = String.format(BASE_URL, API_KEY, city);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (resp.statusCode() == 200) {
                logWeather(resp.body(), city);
            } else {
                System.err.println("Failed to fetch weather: HTTP " + resp.statusCode());
                System.err.println(resp.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void logWeather(String json, String city) {
        JSONObject root = new JSONObject(json);
        JSONObject current = root.getJSONObject("current");
        String condition = current.getJSONObject("condition").getString("text");
        double tempC = current.getDouble("temp_c");
        String timestamp = LocalDateTime.now().toString();

        String entry = String.format("%s | City: %s | Temp: %.1f °C | Condition: %s%n",
                timestamp, city, tempC, condition);

        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(entry);
            System.out.print("Logged: " + entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
