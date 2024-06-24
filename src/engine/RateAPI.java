package engine;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class RateAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/d8ebec80f093647f41943d7d/latest/USD";

    public static HashMap<String, Double> getRates() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        HashMap<String, Double> rateMap = new HashMap<>();
        for (var entry : rates.entrySet()) {
            rateMap.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        return rateMap;
    }
}
