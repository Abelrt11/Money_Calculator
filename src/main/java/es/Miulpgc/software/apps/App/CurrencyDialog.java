package es.Miulpgc.software.apps.App;

import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.view.currencyDialog;

import java.util.List;

public class CurrencyDialog implements currencyDialog {
    private final List<Currency> currencies;

    public CurrencyDialog(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public Currency get() {
        return currencies.get(0);
    }
}
