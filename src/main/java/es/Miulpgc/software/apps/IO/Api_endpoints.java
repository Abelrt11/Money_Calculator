package es.Miulpgc.software.apps.IO;

import es.Miulpgc.software.architecture.model.Currency;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;


import java.util.List;
import java.util.Set;

public class Api_endpoints {


    public List<Currency> read_codes(String base_url, String key) {
        String complete_url = base_url + "?api_key=" + key + "&base=" + "USD";
        try {
            HttpResponse<JsonNode> response = Unirest.get(complete_url)
                    .queryString("api_key", key)
                    .asJson();

            if (response.getStatus() == 200) {

                Set<String> codes = createCodeSet(response);
                List<Currency> currencies = new java.util.ArrayList<>(List.of());
                for (String code : codes) {
                    currencies.add(new Currency(code, "any", "any"));
                }
                return currencies;


            } else {

                throw new RuntimeException("Error en la solicitud: " + response.getStatus());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private Set<String> createCodeSet(HttpResponse<JsonNode> response) {
        var exchangeRates = response.getBody()
                .getObject()
                .getJSONObject("exchange_rates");

        return exchangeRates.keySet();
    }


    public double read_exchange_rate(String base_url, String key, String from, String to) {
        String complete_url = base_url + "?api_key=" + key + "&base=" + from + "&target=" + to;
        try {
            HttpResponse<JsonNode> response = Unirest.get(complete_url)
                    .queryString("api_key", key)
                    .asJson();

            if (response.getStatus() == 200) {

                return separate_rate(response, to);

            } else {

                throw new RuntimeException("Error en la solicitud: " + response.getStatus());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private double separate_rate(HttpResponse<JsonNode> response, String to){
        var exchangeRates = response.getBody()
                .getObject()
                .getJSONObject("exchange_rates");

        return exchangeRates.getDouble(to);
    }


}


