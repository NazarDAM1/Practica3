package Objects;

import java.time.LocalDate;
import java.time.Period;

public class PreparadorFisic extends MembrePlantilla {


    
    protected LocalDate diaFitxa;
    protected int anysExperiencia;

    public PreparadorFisic(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS,LocalDate diaFitxa) {
        super(dni, nom, cognom, dataNaix, telefon, email,  souBase, nSS);

        this.diaFitxa = diaFitxa;

        anysExperiencia = Period.between(diaFitxa, LocalDate.now()).getYears();

        calcularSalari();
        //TODO Auto-generated constructor stub
    }




    @Override
    public String toString() {
        return super.toString() + "anysExperiencia=" + anysExperiencia + ", diaFitxa=" + diaFitxa + "]";
    }




    @Override
    public void calcularSalari() {

        this.salari = (souBase +(anysExperiencia * 2));

    }




}
