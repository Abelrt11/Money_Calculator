package es.Miulpgc.software.apps.windows.view;

import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.view.currencyDialog;

import javax.swing.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements currencyDialog {
    private final List<Currency> currencies;
    private final JComboBox<Currency> selector;

    public SwingCurrencyDialog(List<Currency> currencies) {
        this.currencies = currencies;
        this.add(selector = createSelector());
    }

    private JComboBox<Currency> createSelector() {
        JComboBox<Currency> comboBox = new JComboBox<>();
        for (Currency currency : currencies) {
            comboBox.addItem(currency);
        }
        return comboBox;
    }

    @Override
    public Currency get() {
        return currencies.get(selector.getSelectedIndex());
    }
}
