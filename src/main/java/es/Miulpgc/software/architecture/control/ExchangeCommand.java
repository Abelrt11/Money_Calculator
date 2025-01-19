package es.Miulpgc.software.architecture.control;


import es.Miulpgc.software.architecture.view.ExchangeRateDisplay;
import es.Miulpgc.software.architecture.view.MoneyDialog;
import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.model.exchangeRate;
import es.Miulpgc.software.architecture.model.Money;
import es.Miulpgc.software.architecture.persistence.ExchangeRateLoader;
import es.Miulpgc.software.architecture.view.MoneyDisplay;
import es.Miulpgc.software.architecture.view.currencyDialog;

import java.time.LocalDate;

public class ExchangeCommand implements Command{
    private final ExchangeRateLoader loader;
    private final MoneyDialog moneyDialog;
    private final currencyDialog currencyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateDisplay exchangeRateDisplay;


    public ExchangeCommand(ExchangeRateLoader loader, MoneyDialog moneyDialog, currencyDialog currencyDialog, MoneyDisplay moneyDisplay, ExchangeRateDisplay exchangeRateDisplay) {
        this.loader = loader;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyDisplay = moneyDisplay;
        this.exchangeRateDisplay = exchangeRateDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();


        exchangeRate exchangeRate = loader.load(money.currency(), currency, LocalDate.now());
        Money result = new Money(money.amount() * exchangeRate.rate(), currency);

        moneyDisplay.show(result);
        exchangeRateDisplay.show(exchangeRate);



    }
}

