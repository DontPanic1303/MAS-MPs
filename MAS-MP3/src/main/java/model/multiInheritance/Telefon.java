package model.multiInheritance;

import exceptions.AttributeConstraintViolationException;

public class Telefon implements ITelefon{

    private String model;
    private Double cena;

    public Telefon(String model, Double cena) {
        this.model = model;
        this.cena = cena;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        if (model == null)
            throw new AttributeConstraintViolationException("model can not by null");
        if (model.isEmpty())
            throw new AttributeConstraintViolationException("model can not by empty");
        this.model = model;
    }

    @Override
    public Double getCena() {
        return cena;
    }

    @Override
    public void setCena(Double cena) {
        if (cena <= 0.0)
            throw new IllegalArgumentException("Cena nie może być ujemna");
        this.cena = cena;
    }
}
