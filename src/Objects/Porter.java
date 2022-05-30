package Objects;

import java.time.LocalDate;

public class Porter extends Jugador {

    protected int golsAturats;
    protected int golsRebuts;

    public Porter(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email, int dorsal,
            int souBase, String nSS, boolean esTitular, int golsRebuts, int atacsAturats) {
        super(nie, nom, cognom, dataNaix, telefon, email, souBase, nSS, esTitular);

        this.golsRebuts = golsRebuts;
        this.golsAturats = golsAturats;
        calcularSalari();

        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return super.toString() + "golsAturats=" + golsAturats + ", golsRebuts=" + golsRebuts + "]";
    }

    @Override
    public void calcularSalari() {

        this.salari = (souBase + (golsAturats * 2));

    }

    public int getGolsAturats() {
        return golsAturats;
    }

    public void setGolsAturats(int golsAturats) {
        this.golsAturats = golsAturats;
    }

    public int getGolsRebuts() {
        return golsRebuts;
    }

    public void setGolsRebuts(int golsRebuts) {
        this.golsRebuts = golsRebuts;
    }


    

}
