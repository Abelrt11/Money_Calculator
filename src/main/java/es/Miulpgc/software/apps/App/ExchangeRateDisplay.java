package es.Miulpgc.software.apps.App;

import es.Miulpgc.software.architecture.model.exchangeRate;


public class ExchangeRateDisplay implements es.Miulpgc.software.architecture.view.ExchangeRateDisplay {

    @Override
    public void show(exchangeRate exchangeRate) {
        System.out.println(exchangeRate.rate());
    }
}
