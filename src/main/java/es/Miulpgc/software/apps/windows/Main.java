package es.Miulpgc.software.apps.windows;

import es.Miulpgc.software.apps.App.CurrencyLoader;
import es.Miulpgc.software.apps.App.ExchangeRateLoader;

import es.Miulpgc.software.architecture.control.ExchangeCommand;
import es.Miulpgc.software.architecture.model.Currency;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Currency> currencies = new CurrencyLoader().load();
        MainFrame mainFrame = new MainFrame(currencies);
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                new ExchangeRateLoader(),
                mainFrame.moneyDialog(),
                mainFrame.currencyDialog(),
                mainFrame.moneyDisplay(),
                mainFrame.exchangeRateDisplay()
                );
        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);

    }
}
