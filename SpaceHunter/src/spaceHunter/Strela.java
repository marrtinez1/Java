package spaceHunter;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Trieda pre strely.
 * @author martin
 */
public class Strela {

    private int x;
    private int y;
    private int sirka;
    private int vyska;
    private int smerLetu;
    private ImageIcon obrazok;
    private boolean pomPreZnicenieStrely;
    
    /**
     * Konštuktor pre strely. Sú škálovateľné na základe rozlíšenia obrazovky.
     * @param x
     * @param y
     * @param smerLetu 
     */
    public Strela(int x, int y, int smerLetu) {
        this.x = x;
        this.y = y;
        this.sirka = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 200);         
        this.vyska = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 50);  
        this.smerLetu = smerLetu;
        this.obrazok = new ImageIcon(new ImageIcon(this.getClass().getResource("/grafika/Strela.png")).getImage().getScaledInstance(this.sirka, this.vyska, Image.SCALE_DEFAULT));
        this.pomPreZnicenieStrely = false;
    }

    public boolean getPomPreZnicenieStrely() {
        return this.pomPreZnicenieStrely;
    }

    public void setPomPreZnicenieStrely(boolean pomPreZnicenieStrely) {
        this.pomPreZnicenieStrely = pomPreZnicenieStrely;
    }
    
    public int getSmerLetu() {
        return this.smerLetu;
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

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.sirka, this.vyska);
    }
    
    /**
     * Metóda, ktorá slúži na pohyb strely.
     */
    public void pohyb() {
        this.y += this.smerLetu;
    }
    
    /**
     * Zistí, či sa strela dostala za okraj obrazovky.
     * @return 
     */
    public boolean odletenaStrela() {
        if (this.y > Toolkit.getDefaultToolkit().getScreenSize().getHeight() || this.y < 0) {
            return true;
            
        }
        return false;
            
    }
}
