package Objects;

import java.time.LocalDate;

public class Entrenador extends PreparadorFisic {

    protected int numeroTrofeus;


    
    public Entrenador(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS) {
        super(nie, nom, cognom, dataNaix, telefon, email,  souBase, nSS, dataNaix);
        //TODO Auto-generated constructor stub
    }



   
    @Override
    public String toString() {
        return super.toString() + "numeroTrofeus=" + numeroTrofeus + "]";
    }




    @Override
    public void calcularSalari() {
       
        this.salari = (souBase +(numeroTrofeus * 2));

    }

    

}
