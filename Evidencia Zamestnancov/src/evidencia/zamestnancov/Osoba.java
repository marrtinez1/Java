package evidencia.zamestnancov;


public class Osoba {
    
    private String aMeno;
    private String aPriezvisko;
    private Pozicia aPoz;
    
    public Osoba(String paMeno, String paPriezvisko, Pozicia paPoz) {
        this.aMeno = paMeno;
        this.aPriezvisko = paPriezvisko;
        this.aPoz = paPoz;
    }
    
    public String toString() {
        return ("Meno a Priezvisko : " + this.aMeno + " " + this.aPriezvisko + "   " + "Poz: " + this.aPoz + "\n");
    }
}
