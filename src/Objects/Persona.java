package Objects;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
    protected int dorsal;
    protected static int dorsals;
    protected String nie;
    protected String nom;
    protected String cognom;
    protected LocalDate dataNaix;
    protected int edat;
    protected int telefon;
    protected String email;
    


    @Override
   
    public String toString() {
        return getClass().getSimpleName() + " nie=" + nie  + " Dorsal=" + dorsal + ", nom=" + nom + ", cognom=" + cognom + ", dataNaix=" + dataNaix + " edat= " + edat +
               ", email=" + email +  " telefon=" + telefon + " ";
    }

    public Persona(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email) {
        this.nie = nie;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaix = dataNaix;
        this.telefon = telefon;
        this.email = email;
        this.dorsal = ++dorsals;

        
        edat = Period.between(dataNaix, LocalDate.now()).getYears();
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public static int getDorsals() {
        return dorsals;
    }

    public static void setDorsals(int dorsals) {
        Persona.dorsals = dorsals;
    }

    public String getnie() {
        return nie;
    }

    public void setnie(String nie) {
        nie = nie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public LocalDate getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(LocalDate dataNaix) {
        this.dataNaix = dataNaix;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    

}
