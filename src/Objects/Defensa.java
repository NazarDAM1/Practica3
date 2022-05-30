package Objects;

import java.time.LocalDate;

public class Defensa extends JugadorBalonsRecuperats {

    protected int atacsAturats;

    @Override
    public void calcularSalari() {
        this.salari = (souBase + (atacsAturats * 2) + (this.balonsRecuperats * 2));

    }

    @Override
    public String toString() {
        return super.toString() + " atacsAturats=" + atacsAturats + "]";
    }

    public Defensa(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS, boolean esTitular, int balonsRecuperats,
            int atacsAturats) {

        super(nie, nom, cognom, dataNaix, telefon, email, souBase, nSS, esTitular,
                balonsRecuperats);

        this.atacsAturats = atacsAturats;

        calcularSalari();
    }

}
