package model.multiAspectInheritance;

import enums.Magic;
import exceptions.AttributeConstraintViolationException;

public class Czarodziej {

    private String imie;
    private String nazwisko;
    private Magic magia;
    private String zywiol;
    private String runa;

    protected Czarodziej(String imie, String nazwisko, Magic magia, String nazwaMagii) {
        this.setImie(imie);
        this.setNazwisko(nazwisko);
        this.setMagia(magia);
        if (magia == Magic.ZYWIOLOW) {
            this.setZywiol(nazwaMagii);
            this.runa = null;
        } else {
            this.setRuna(nazwaMagii);
            this.zywiol = null;
        }
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        if (imie == null)
            throw new AttributeConstraintViolationException("Imie can not by null");
        if (imie.isEmpty())
            throw new AttributeConstraintViolationException("Imie can not by empty");
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        if (nazwisko == null)
            throw new AttributeConstraintViolationException("Nazwisko can not by null");
        if (nazwisko.isEmpty())
            throw new AttributeConstraintViolationException("Nazwisko can not by empty");
        this.nazwisko = nazwisko;
    }

    public Magic getMagia() {
        return this.magia;
    }

    private void setMagia(Magic magia){
        if (magia == null)
            throw new AttributeConstraintViolationException("Magia can not by null");
        this.magia = magia;
    }

    public String getZywiol() {
        return zywiol;
    }

    public void setZywiol(String zywiol) {
        if (zywiol == null)
            throw new AttributeConstraintViolationException("Żywioł can not by null");
        if (zywiol.isEmpty())
            throw new AttributeConstraintViolationException("Żywioł can not by empty");
        this.zywiol = zywiol;
    }

    public String getRuna() {
        return runa;
    }

    public void setRuna(String runa) {
        if (runa == null)
            throw new AttributeConstraintViolationException("Runa can not by null");
        if (runa.isEmpty())
            throw new AttributeConstraintViolationException("Runa can not by empty");
        this.runa = runa;
    }
}
