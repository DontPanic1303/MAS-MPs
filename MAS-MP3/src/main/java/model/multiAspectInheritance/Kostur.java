package model.multiAspectInheritance;

import enums.Magic;

public class Kostur extends Czarodziej{

    private Double poziomWzmocnieniaSilyZaklec;

    public Kostur(String imie, String nazwisko, Magic magia, String nazwaMagii, Double poziomWzmocnieniaSilyZaklec) {
        super(imie, nazwisko, magia, nazwaMagii);
        this.setPoziomWzmocnieniaSilyZaklec(poziomWzmocnieniaSilyZaklec);
    }

    public Double getPoziomWzmocnieniaSilyZaklec() {
        return poziomWzmocnieniaSilyZaklec;
    }

    public void setPoziomWzmocnieniaSilyZaklec(Double poziomWzmocnieniaSilyZaklec) {
        if (poziomWzmocnieniaSilyZaklec <= 0.0)
            throw new IllegalArgumentException("Poziom wzmocnienia sily zaklec nie może być ujemny");
        this.poziomWzmocnieniaSilyZaklec = poziomWzmocnieniaSilyZaklec;
    }
}
