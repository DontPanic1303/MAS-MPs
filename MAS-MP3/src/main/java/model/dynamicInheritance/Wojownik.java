package model.dynamicInheritance;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

public class Wojownik extends Piechur{

    private String rodzajOreza;


    public Wojownik(String zbroja, String rodzajOreza) {
        super(zbroja);
        this.setRodzajOreza(rodzajOreza);
        EkstensjaClass.addWojownik(this);
    }

    public Wojownik(Lucznik lucznik, String rodzajOreza) {
        super(lucznik.getZbroja());
        this.setRodzajOreza(rodzajOreza);
        EkstensjaClass.removeLucznik(lucznik);
        EkstensjaClass.addWojownik(this);
    }

    public String getRodzajOreza() {
        return rodzajOreza;
    }

    public void setRodzajOreza(String rodzajOreza) {
        if (rodzajOreza == null)
            throw new AttributeConstraintViolationException("Rodzaj oreza can not by null");
        if (rodzajOreza.isEmpty()) {
            throw new AttributeConstraintViolationException("Rodzaj oreza can not by empty");
        }
        this.rodzajOreza = rodzajOreza;
    }

}
