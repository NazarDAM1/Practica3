package Objects;

import java.time.LocalDate;

public abstract class MembrePlantilla extends Persona {

    protected int souBase;
    protected String NSS;
    
    protected int numeroEmpleat;
    protected static int numeroEmpleats;
    protected int salari;

    abstract public void calcularSalari();


    @Override
    public String toString() {
        return super.toString() + "NSS=" + NSS + ", salari=" + salari + ", souBase=" + souBase + " numeroEmpleat " + numeroEmpleat + " ";
    }

    public MembrePlantilla(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email,
            int souBase, String nSS) {
        super(dni, nom, cognom, dataNaix, telefon, email);
        this.souBase = souBase;
        NSS = nSS;
        this.numeroEmpleat = ++numeroEmpleats;
    }

    public int getSouBase() {
        return souBase;
    }

    public void setSouBase(int souBase) {
        this.souBase = souBase;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String nSS) {
        NSS = nSS;
    }

    public int getSalari() {
        return salari;
    }

    public void setSalari(int salari) {
        this.salari = salari;
    }



    abstract public void setGolsFets(int golsFets); 
    abstract public void setBalonsRecuperats(int balonsRecuperats); 


  

}
