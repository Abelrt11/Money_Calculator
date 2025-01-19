package es.Miulpgc.software.architecture.persistence;

import es.Miulpgc.software.architecture.model.Currency;
import es.Miulpgc.software.architecture.model.exchangeRate;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    exchangeRate load(Currency from, Currency to, LocalDate Date);
}
