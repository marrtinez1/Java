package spaceHunter;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Trieda na vytvorenie vesmírnej lodi, ktorú budem ovládať ja.
 *
 * @author martin
 */
public class MojaLod {

    private int x;
    private int y;
    private int sirka;
    private int vyska;
    private ImageIcon obrazok;
    private int rychlost;
    private Strela[] mojeStrely;

    /**
     * Vytvorí vesmírnu loď. Bude mať vlastný obrázok a bude na súradnici x a y.
     *
     * @param x
     * @param y
     * @param sirkaAvyska
     */
    public MojaLod(int x, int y, int sirkaAvyska) {
        this.x = x;
        this.y = y;
        this.sirka = sirkaAvyska;
        this.vyska = sirkaAvyska;
        this.obrazok = new ImageIcon(new ImageIcon(this.getClass().getResource("/grafika/MojaLod.png")).getImage().getScaledInstance(this.sirka, this.vyska, Image.SCALE_DEFAULT));
        this.rychlost = 0;
        this.mojeStrely = new Strela[20];
    }

    public Strela getMojeStrely(int i) {
        return this.mojeStrely[i];
    }

    public void setMojeStrely(int i, Strela strela) {
        this.mojeStrely[i] = strela;
    }

    /**
     * Na prázdne miesto v poli pridá novú strelu.
     */
    public void vystrel() {
        for (int i = 0; i < 20; i++) {
            if (this.mojeStrely[i] == null) {
                this.setMojeStrely(i, (new Strela(this.getX() + (this.getSirka() / 2), this.getY(), -5)));
                break;
            }
        }
    }

    public int getSirka() {
        return this.sirka;
    }

    public int getVyska() {
        return this.vyska;
    }

    public int getRychlost() {
        return this.rychlost;
    }

    public void setRychlost(int rychlost) {
        this.rychlost = rychlost;
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

    public ImageIcon getObrazok() {
        return this.obrazok;
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.sirka, this.vyska);
    }

    /**
     * Metóda na pohyb lode.
     */
    public void pohyb() {
        this.x += this.rychlost;
    }

    /**
     * Zistí, či došlo k zásahu mojej lode.
     *
     * @param strela
     * @return
     */
    public boolean zasah(Strela strela) {
        if (strela.getRectangle().intersects(this.getRectangle())) {
            return true;
        }
        return false;
    }
}
