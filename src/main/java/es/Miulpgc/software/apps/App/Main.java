package es.Miulpgc.software.apps.App;





import es.Miulpgc.software.architecture.control.Command;
import es.Miulpgc.software.architecture.control.ExchangeCommand;
import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.view.currencyDialog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Currency> currencies = new CurrencyLoader().load();
        es.Miulpgc.software.architecture.view.MoneyDialog moneyDialog = new MoneyDialog(currencies);
        currencyDialog currencyDialog = new CurrencyDialog(currencies);
        es.Miulpgc.software.architecture.persistence.ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoader();
        es.Miulpgc.software.architecture.view.MoneyDisplay moneyDisplay = new MoneyDisplay();
        es.Miulpgc.software.architecture.view.ExchangeRateDisplay exchangeRateDisplay = new ExchangeRateDisplay();
        Command command = new ExchangeCommand(
                exchangeRateLoader,
                moneyDialog,
                currencyDialog,
                moneyDisplay,
                exchangeRateDisplay
                );
        command.execute();
    }
}
