package spaceHunter;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Trieda na vytvorenie meteoritu, ktorý sa nedá zničiť.
 *
 * @author martin
 */
public class Meteor extends Nepriatel {

    /**
     * Konštruktor, ktorý vytvorí meteorit. Jeho parametrami budú x-ová a
     * y-lonová suradnica, šírka, výška, rýchlosť, obrázok a strely. Všetky
     * tieto atribúty bude dediť z triedy Nepriateľ.
     *
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     * @param rychlost
     * @param obrazok
     * @param strely
     */
    public Meteor(int x, int y, int sirka, int vyska, int rychlost, ImageIcon obrazok, ArrayList<Strela> strely) {
        super(x, y, sirka, vyska, rychlost, obrazok, strely);
    }
}
