package es.Miulpgc.software.apps.windows.view;

import es.Miulpgc.software.apps.IO.Api_Configuration;
import es.Miulpgc.software.apps.IO.Api_endpoints;
import es.Miulpgc.software.architecture.model.exchangeRate;
import es.Miulpgc.software.architecture.view.ExchangeRateDisplay;

import javax.swing.*;

public class SwingExchangeRateDisplay extends JPanel implements ExchangeRateDisplay {
    private final JLabel label;

    public SwingExchangeRateDisplay() {
        this.add(label = createLabel());

    }

    private JLabel createLabel() {
        return new JLabel();
    }


    @Override
    public void show(exchangeRate exchangeRate) {
        label.setText("Exchange rate = " + String.valueOf(exchangeRate.rate()));
    }
}
