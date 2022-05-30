package Objects;


import java.time.LocalDate;

public class Davanter extends JugadorBalonsRecuperats {
    protected int golsFets;







    
    @Override
    public String toString() {
        return super.toString() + " golsFets=" + golsFets + "]";
    }



    public Davanter(String nie, String nom, String cognom, LocalDate dataNaix, int telefon, String email, 
            int souBase, String nSS,  boolean esTitular, int balonsRecuperats,int golsFets) {
        super(nie, nom, cognom, dataNaix, telefon, email,  souBase, nSS,   esTitular, balonsRecuperats);
        this.golsFets = golsFets;
        calcularSalari();
        //TODO Auto-generated constructor stub
    }

   

    @Override
    public void calcularSalari() {
        this.salari = souBase+ (golsFets * 2) + (this.balonsRecuperats * 2);
    }



    public int getGolsFets() {
        return golsFets;
    }



    public void setGolsFets(int golsFets) {
        this.golsFets = golsFets;
    }


    
}
