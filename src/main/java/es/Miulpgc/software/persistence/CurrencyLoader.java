package es.Miulpgc.software.persistence;

import es.Miulpgc.software.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
