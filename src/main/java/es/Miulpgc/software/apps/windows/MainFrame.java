package es.Miulpgc.software.apps.windows;

import es.Miulpgc.software.apps.windows.view.SwingCurrencyDialog;
import es.Miulpgc.software.apps.windows.view.SwingExchangeRateDisplay;
import es.Miulpgc.software.apps.windows.view.SwingMoneyDialog;
import es.Miulpgc.software.apps.windows.view.SwingMoneyDisplay;

import es.Miulpgc.software.architecture.control.Command;
import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.view.ExchangeRateDisplay;
import es.Miulpgc.software.architecture.view.MoneyDialog;
import es.Miulpgc.software.architecture.view.MoneyDisplay;
import es.Miulpgc.software.architecture.view.currencyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {

    private final List<Currency> currencies;
    private final SwingMoneyDialog moneyDialog;
    private final SwingCurrencyDialog currencyDialog;
    private final SwingMoneyDisplay moneyDisplay;
    private final Map<String, Command> commands;
    private final SwingExchangeRateDisplay exchangeRateDisplay;

    public MainFrame(List<Currency> currencies) {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(moneyDialog = createMoneyDialog());
        topPanel.add(currencyDialog = createCurrencyDialog());
        topPanel.add(moneyDisplay = createMoneyDisplay());
        topPanel.add(createCalculateButton());


        mainPanel.add(topPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(exchangeRateDisplay = createExchangeRateDisplay(),CENTER_ALIGNMENT);


        this.add(mainPanel);

        this.commands = new HashMap<>();

    }

    private SwingExchangeRateDisplay createExchangeRateDisplay() {
        return new SwingExchangeRateDisplay();
    }


    private SwingMoneyDisplay createMoneyDisplay() {
        return  new SwingMoneyDisplay();
    }

    private SwingCurrencyDialog createCurrencyDialog() {
        return new SwingCurrencyDialog(currencies);
    }

    private SwingMoneyDialog createMoneyDialog() {
        return new SwingMoneyDialog(currencies);
    }

    private Component createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("exchange").execute();
            }
        });
        return button;
    }

    public MoneyDialog moneyDialog() {
        return moneyDialog;
    }

    public currencyDialog currencyDialog() {
        return currencyDialog;
    }

    public MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    public ExchangeRateDisplay exchangeRateDisplay() {
        return exchangeRateDisplay;
    }

    public void add(String operation, Command command) {
        commands.put(operation, command);
    }


}
