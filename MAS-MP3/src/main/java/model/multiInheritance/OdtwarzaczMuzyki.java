package model.multiInheritance;

public class OdtwarzaczMuzyki {

    private int IloscPiosenek;

    public OdtwarzaczMuzyki(int iloscPiosenek) {
        this.setIloscPiosenek(iloscPiosenek);
    }

    public int getIloscPiosenek() {
        return IloscPiosenek;
    }

    public void setIloscPiosenek(int iloscPiosenek) {
        if (iloscPiosenek<1)
            throw new IllegalArgumentException("Ilość piosenek musi być powyrzej zera");
        IloscPiosenek = iloscPiosenek;
    }
}
