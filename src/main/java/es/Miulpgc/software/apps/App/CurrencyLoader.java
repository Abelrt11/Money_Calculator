package es.Miulpgc.software.apps.App;

import es.Miulpgc.software.apps.IO.Api_Configuration;
import es.Miulpgc.software.apps.IO.Api_endpoints;
import es.Miulpgc.software.architecture.model.Currency;

import java.util.List;


public class CurrencyLoader {

    public List<Currency> load(){
        Api_endpoints api = new Api_endpoints();
        Api_Configuration configuration = new Api_Configuration();
        return api.read_codes(configuration.getBaseUrl(), configuration.getApiKey());




    }
}
