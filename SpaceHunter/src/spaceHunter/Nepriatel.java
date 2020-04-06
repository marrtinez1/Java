
package spaceHunter;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Abstraktná trieda pre rôznych nepriateľov.
 * @author martin
 */
public abstract class Nepriatel {
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    private int rychlost;
    private ImageIcon obrazok;
    
    /**
     * Konštruktor, ktorý dedia treidy Foe1, Foe2 a Meteor.
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     * @param rychlost
     * @param obrazok
     * @param strely 
     */
    public Nepriatel(int x, int y, int sirka, int vyska, int rychlost, ImageIcon obrazok, ArrayList<Strela> strely) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
        this.rychlost = rychlost;
        this.obrazok  = obrazok;
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.sirka, this.vyska);
    }
    

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSirka() {
        return this.sirka;
    }

    public int getVyska() {
        return this.vyska;
    }

    public ImageIcon getObrazok() {
        return this.obrazok;
    }
    
    /**
     * Metóda na pohyb nepriateľovej lode.
     */
    public void pohyb() {
        this.y += this.rychlost;
    }
    
    /**
     * Slúži na vystrelenie strely.
     * @param strely 
     */
    public void vystrel(ArrayList<Strela> strely) {
    
    }
    
    /**
     * Zistí, či došlo k zásahu nepriateľa.
     * @param strela
     * @return 
     */
    public boolean zasah(Strela strela) {
        if (strela.getRectangle().intersects(this.getRectangle()) && strela.getSmerLetu() < 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Metóda, aby sa nepriateľ nedostal mimo obrazovky.
     * @return 
     */
    public boolean odletNepriatela() {
        if (this.y > Toolkit.getDefaultToolkit().getScreenSize().getHeight()) {
            return true;
        }
        return false;
    }
}
