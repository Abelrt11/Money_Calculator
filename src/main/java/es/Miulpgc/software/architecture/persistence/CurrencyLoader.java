package es.Miulpgc.software.architecture.persistence;

import es.Miulpgc.software.architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
