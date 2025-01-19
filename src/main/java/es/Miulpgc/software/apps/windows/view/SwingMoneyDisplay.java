package es.Miulpgc.software.apps.windows.view;

import es.Miulpgc.software.architecture.model.Money;
import es.Miulpgc.software.architecture.view.MoneyDisplay;

import javax.swing.*;



public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private final JLabel label;

    public SwingMoneyDisplay() {
        this.add(label = createLabel());
    }

    private JLabel createLabel() {
        return new JLabel();
    }

    @Override
    public void show(Money money) {
        label.setText(money.amount() + " " + money.currency().code());
    }


}
