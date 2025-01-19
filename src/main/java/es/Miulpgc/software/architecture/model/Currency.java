package es.Miulpgc.software.architecture.model;

public record Currency(String code, String symbol, String name) {

    @Override
    public String toString() { return code; }
}


