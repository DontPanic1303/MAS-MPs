package model.multiAspectInheritance;

import enums.Magic;

public class Rozdzka extends Czarodziej{

    private Double poziomPrzyspieszeniaRzucaniaZaklec;

    public Rozdzka(String imie, String nazwisko, Magic magia, String nazwaMagii, Double poziomPrzyspieszeniaRzucaniaZaklec) {
        super(imie, nazwisko, magia, nazwaMagii);
        this.setPoziomPrzyspieszeniaRzucaniaZaklec(poziomPrzyspieszeniaRzucaniaZaklec);
    }

    public Double getPoziomPrzyspieszeniaRzucaniaZaklec() {
        return poziomPrzyspieszeniaRzucaniaZaklec;
    }

    public void setPoziomPrzyspieszeniaRzucaniaZaklec(Double poziomPrzyspieszeniaRzucaniaZaklec) {
        if (poziomPrzyspieszeniaRzucaniaZaklec <= 0.0)
            throw new IllegalArgumentException("Poziom przyspieszenia rzucania zaklec nie może być ujemny");
        this.poziomPrzyspieszeniaRzucaniaZaklec = poziomPrzyspieszeniaRzucaniaZaklec;
    }
}
