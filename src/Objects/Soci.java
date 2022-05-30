package Objects;

import java.time.LocalDate;

public class Soci extends Persona {

    protected int numSoci;
    protected static int numSocis;
    protected static int numLocalitats = 500;
    protected int numLocalitat;

    private int quotaAnual;

    public Soci(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int quotaAnual) {
        super(nie, nom, cognom, dataNaix, telefon, email);

        this.quotaAnual = quotaAnual;

        this.numSoci = ++numSocis;
        this.numLocalitat = ++numLocalitats;
    }

    @Override
    public String toString() {
        return super.toString() + " numLocalitat=" + numLocalitat + ", numSoci=" + numSoci + ", quotaAnual="
                + quotaAnual + "]";
    }

    public int getQuotaAnual() {
        return quotaAnual;
    }

    public void setQuotaAnual(int quotaAnual) {
        this.quotaAnual = quotaAnual;
    }

    public int getNumSoci() {
        return numSoci;
    }

    public void setNumSoci(int numSoci) {
        this.numSoci = numSoci;
    }

    public int getNumLocalitat() {
        return numLocalitat;
    }

    public void setNumLocalitat(int numLocalitat) {
        this.numLocalitat = numLocalitat;
    }

    

}
