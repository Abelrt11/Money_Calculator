package es.Miulpgc.software.control;


import es.Miulpgc.software.model.Currency;
import es.Miulpgc.software.model.exchangeRate;
import es.Miulpgc.software.model.Money;
import es.Miulpgc.software.persistence.ExchangeRateLoader;
import es.Miulpgc.software.view.MoneyDialog;
import es.Miulpgc.software.view.MoneyDisplay;
import es.Miulpgc.software.view.currencyDialog;

import java.time.LocalDate;

public class ExchangeCommand implements Command{
    private final ExchangeRateLoader loader;
    private final MoneyDialog moneyDialog;
    private final currencyDialog currencyDialog;
    private final MoneyDisplay moneyDisplay;


    public ExchangeCommand(ExchangeRateLoader loader, MoneyDialog moneyDialog, es.Miulpgc.software.view.currencyDialog currencyDialog, MoneyDisplay moneyDisplay) {
        this.loader = loader;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        exchangeRate exchangeRate = loader.load(money.currency(), currency, LocalDate.now());
        Money result = new Money(money.amount() * exchangeRate.rate(), currency);

        moneyDisplay.show(result);


    }
}

