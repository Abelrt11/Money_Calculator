package es.Miulpgc.software.apps.App;

import es.Miulpgc.software.apps.IO.Api_Configuration;
import es.Miulpgc.software.apps.IO.Api_endpoints;
import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.model.exchangeRate;

import java.time.LocalDate;

public class ExchangeRateLoader implements es.Miulpgc.software.architecture.persistence.ExchangeRateLoader {

    @Override
    public exchangeRate load(Currency from, Currency to, LocalDate date) {
        Api_endpoints api = new Api_endpoints();
        Api_Configuration configuration = new Api_Configuration();
        return new exchangeRate(from, to, api.read_exchange_rate(configuration.getBaseUrl(), configuration.getApiKey(), from.code(), to.code()), LocalDate.now());
    }


}
