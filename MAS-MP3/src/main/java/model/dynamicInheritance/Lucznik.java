package model.dynamicInheritance;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

public class Lucznik extends Piechur{

    private Double zasieg;

    public Lucznik(String zbroja, double zasieg) {
        super(zbroja);
        this.setZasieg(zasieg);
        EkstensjaClass.addLucznik(this);
    }

    public Lucznik(Wojownik wojownik, Double zasieg) {
        super(wojownik.getZbroja());
        this.setZasieg(zasieg);
        EkstensjaClass.removeWojownik(wojownik);
        EkstensjaClass.addLucznik(this);
    }

    public Double getZasieg() {
        return zasieg;
    }

    public void setZasieg(Double zasieg) {
        if (zasieg <= 0.0)
            throw new AttributeConstraintViolationException("Zasięg musi być powyżej zera");
        this.zasieg = zasieg;
    }
}
