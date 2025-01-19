package es.Miulpgc.software.apps.App;

import es.Miulpgc.software.architecture.model.Money;


public class MoneyDisplay implements es.Miulpgc.software.architecture.view.MoneyDisplay {


    @Override
    public void show(Money money){
        System.out.println(money);
    }
}
