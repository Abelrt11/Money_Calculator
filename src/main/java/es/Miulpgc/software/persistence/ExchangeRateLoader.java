package es.Miulpgc.software.persistence;

import es.Miulpgc.software.model.Currency;
import es.Miulpgc.software.model.exchangeRate;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    exchangeRate load(Currency from, Currency to, LocalDate Date);
}
