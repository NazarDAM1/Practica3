package Objects;

import java.time.LocalDate;

public class Migcampista extends JugadorBalonsRecuperats {


    protected int asistenciesGol;

    
    public Migcampista(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS,  boolean esTitular, int balonsRecuperats,int asistenciesGol) {
        super(dni, nom, cognom, dataNaix, telefon, email,  souBase, nSS,  esTitular, balonsRecuperats);
        
        this.asistenciesGol = asistenciesGol;
        
        
        calcularSalari();
    }

    

    @Override
    public String toString() {
        return super.toString() + "asistenciesGol=" + asistenciesGol + "]";
    }



    @Override
    public void calcularSalari() {
        this.salari = souBase+ (this.asistenciesGol *2)+(this.balonsRecuperats * 2);

    }



    public int getAsistenciesGol() {
        return asistenciesGol;
    }



    public void setAsistenciesGol(int asistenciesGol) {
        this.asistenciesGol = asistenciesGol;
    }

}
