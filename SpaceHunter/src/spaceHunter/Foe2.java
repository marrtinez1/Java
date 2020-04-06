package spaceHunter;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Trieda na vytvorenie silnejšieho nepriateľa, ktorý strieľa dve strely.
 *
 * @author martin
 */
public class Foe2 extends Nepriatel {

    private ArrayList<Strela> strely;

    /**
     * Konštruktor, ktorý vytvorí silnejšieho nepriateľa. Jeho parametrami budú
     * x-ová a y-lonová suradnica, šírka, výška, rýchlosť, obrázok a strely.
     * Všetky tieto atribúty bude dediť z triedy Nepriateľ.
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     * @param rychlost
     * @param obrazok
     * @param strely 
     */
    public Foe2(int x, int y, int sirka, int vyska, int rychlost, ImageIcon obrazok, ArrayList<Strela> strely) {
        super(x, y, sirka, vyska, rychlost, obrazok, strely);
        this.strely = strely;
    }
    
    /**
     * Metóda na vystrelenie novej strely nepriateľom.
     * @param strely 
     */

    @Override
    public void vystrel(ArrayList<Strela> strely) {
        this.strely.add(new Strela(this.getX() + 10, this.getY() + this.getVyska(), 8));
        this.strely.add(new Strela(this.getX() + this.getSirka() - 12, this.getY() + this.getVyska(), 8));
    }
}
