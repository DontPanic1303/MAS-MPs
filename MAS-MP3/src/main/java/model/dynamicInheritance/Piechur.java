package model.dynamicInheritance;

import exceptions.AttributeConstraintViolationException;

public abstract class Piechur {

    private String zbroja;

    public Piechur(String zbroja) {
        this.setZbroja(zbroja);
    }

    public String getZbroja() {
        return zbroja;
    }

    public void setZbroja(String zbroja) {
        if (zbroja == null)
            throw new AttributeConstraintViolationException("Zbroja can not by null");
        if (zbroja.isEmpty())
            throw new AttributeConstraintViolationException("Zbroja can not by empty");
        this.zbroja = zbroja;
    }
}
