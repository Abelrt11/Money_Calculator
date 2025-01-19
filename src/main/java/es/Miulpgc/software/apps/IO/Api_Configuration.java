package es.Miulpgc.software.apps.IO;

import io.github.cdimascio.dotenv.Dotenv;

public class Api_Configuration {

    private final String apiKey;
    private final String baseUrl;

    public Api_Configuration() {
        Dotenv dotenv = Dotenv.configure().directory("./MoneyCalculator").load();
        apiKey = dotenv.get("API_KEY");
        baseUrl = dotenv.get("BASE_URL");
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
