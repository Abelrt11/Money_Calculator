package es.Miulpgc.software.apps.App;

import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.model.Money;

import java.util.List;

public class MoneyDialog implements es.Miulpgc.software.architecture.view.MoneyDialog {
    private final List<Currency> currencies;

    public MoneyDialog(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public Money get() {
        return new Money(100, currencies.get(currencies.size() - 1));
    }
}
