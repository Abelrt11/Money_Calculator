package es.Miulpgc.software.architecture.model;

import java.time.LocalDate;

public record exchangeRate(Currency from, Currency to, double rate, LocalDate date) {
}
