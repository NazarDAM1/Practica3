package Objects;

import java.time.LocalDate;

public abstract class JugadorBalonsRecuperats extends Jugador{

    protected int balonsRecuperats;

    @Override
    public String toString() {
        return super.toString()+ " balonsRecuperats=" + balonsRecuperats + "";
    }

    public JugadorBalonsRecuperats(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS,   boolean esTitular, int balonsRecuperats) {
        super(nie, nom, cognom, dataNaix, telefon, email,  souBase, nSS,   esTitular);
        this.balonsRecuperats = balonsRecuperats;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    
}
