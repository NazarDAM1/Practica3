package Objects;

import java.time.LocalDate;

public abstract class Jugador extends MembrePlantilla {

    // private static int dorsals;
    // private int dorsal;
    protected boolean esTitular;
    @Override
    public String toString() {
        return super.toString()+", esTitular=" + esTitular + "";
    }
    public Jugador(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS,   boolean esTitular) {
        super(dni, nom, cognom, dataNaix, telefon, email,  souBase, nSS );
        
        this.esTitular = esTitular;
       
        
    }
    public boolean isEsTitular() {
        return esTitular;
    }
    public void setEsTitular(boolean esTitular) {
        this.esTitular = esTitular;
    }


    
    
}
