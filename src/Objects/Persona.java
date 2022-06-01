package Objects;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
    protected int dorsal;
    protected static int dorsals;
    protected String dni;
    protected String nom;
    protected String cognom;
    protected LocalDate dataNaix;
    protected int edat;
    protected int telefon;
    protected String email;
    


    @Override
   
    public String toString() {
        return getClass().getSimpleName() + " dni=" + dni  + " Dorsal=" + dorsal + ", nom=" + nom + ", cognom=" + cognom + ", dataNaix=" + dataNaix + " edat= " + calcularEdat() +
               ", email=" + email +  " telefon=" + telefon + " ";
    }

    public Persona(String dni, String nom, String cognom, LocalDate dataNaix, int telefon, String email) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaix = dataNaix;
        this.telefon = telefon;
        this.email = email;
        this.dorsal = ++dorsals;

        
        edat = Period.between(dataNaix, LocalDate.now()).getYears();
    }

    public Persona(){
        
    }

    public int calcularEdat(){
        edat = Period.between(dataNaix, LocalDate.now()).getYears();
        return edat;
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

    public String getdni() {
        return dni;
    }

    public static void setDni(String dni) {
        dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        nom = nom;
    }
    

    public String getCognom() {
        return cognom;
    }

    public static void setCognom(String cognom) {
        cognom = cognom;
    }

    public LocalDate getDataNaix() {
        return dataNaix;
    }

    public static void setDataNaix(LocalDate dataNaix) {
        dataNaix = dataNaix;
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

    public static void setTelefon(int telefon) {
        telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        email = email;
    }

   
    

}
