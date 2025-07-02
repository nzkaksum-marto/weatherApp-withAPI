package com.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        String apiKey = "API_KEY"; // Replace with your WeatherAPI key
        String city = "Madrid";
        String url = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city + "&aqi=no";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body());
            System.out.println("City: " + jsonNode.get("location").get("name").asText());
            System.out.println("Temperature: " + jsonNode.get("current").get("temp_c").asDouble() + "°C");
            System.out.println("Condition: " + jsonNode.get("current").get("condition").get("text").asText());
            System.out.println("UV:" +jsonNode.get("current").get("uv").asText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
