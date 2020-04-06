package spaceHunter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Trieda ktorá vytvára nový Panel. Obsahuje moju loď, nepriateľov, časovač,
 * skóre atď.
 *
 * @author martin
 */
public class Panel extends JPanel implements KeyListener {

    private Timer timer;
    private MojaLod hrac;
    private ArrayList<Strela> strely;
    private Nepriatel[] nepriatelia;
    private int pomPreZjavenieNepriatela;
    private ImageIcon foe1;
    private ImageIcon foe2;
    private ImageIcon meteor;
    private ImageIcon pozadie;
    private JLabel napisGameOver;
    private JLabel skore;
    private int skoreint;
    private int obrazovkaSirka;
    private int obrazovkaVyska;
    private Dimension screenSize;

    /**
     * Konštruktor na vytvorenie panelu. Pridí mu šírku, výšku, font, farbu. Budú sa na ňom náhodne generovať nepriatelia, ich strely
     */
    public Panel() {
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.obrazovkaSirka = (int)this.screenSize.getWidth();
        this.obrazovkaVyska = (int)this.screenSize.getHeight();

        this.setPreferredSize(new Dimension(this.obrazovkaSirka, this.obrazovkaVyska));
        this.setFocusable(true);

        this.napisGameOver = new JLabel("GAME OVER   ");
        this.napisGameOver.setForeground(Color.white);
        this.napisGameOver.setFont(new Font("Serif", Font.BOLD, 80));
        this.napisGameOver.setVisible(false);
        this.add(this.napisGameOver);

        this.skore = new JLabel(Integer.toString(this.skoreint));
        this.skore.setForeground(Color.white);
        this.skore.setFont(new Font("Serif", Font.BOLD, 80));
        this.skore.setVisible(true);
        this.add(this.skore);

        this.pozadie = new ImageIcon(new ImageIcon(this.getClass().getResource("/grafika/pozadie.png")).getImage().getScaledInstance(this.obrazovkaSirka, this.obrazovkaVyska, Image.SCALE_DEFAULT));
        this.foe1 = new ImageIcon(new ImageIcon(this.getClass().getResource("/grafika/foe1.png")).getImage().getScaledInstance((this.obrazovkaSirka / 30), 70, Image.SCALE_DEFAULT));
        this.foe2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/grafika/foe2.png")).getImage().getScaledInstance(50, 70, Image.SCALE_DEFAULT));
        this.meteor = new ImageIcon(new ImageIcon(this.getClass().getResource("/grafika/meteor.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        this.pomPreZjavenieNepriatela = 0;

        this.strely = new ArrayList<Strela>();
        this.nepriatelia = new Nepriatel[10];

        this.hrac = new MojaLod(this.obrazovkaSirka / 2 - 30, this.obrazovkaVyska - 150, (this.obrazovkaSirka / 20));
        this.timer = new Timer(15, null);
        this.timer.start();
        this.timer.addActionListener((ae) -> {

            if (this.pomPreZjavenieNepriatela > 0) {
                this.pomPreZjavenieNepriatela--;
            } else {
                Random rand = new Random();
                int randomNepriatel = rand.nextInt(3) + 1;
                int pomx = 0 + (int)(Math.random() * this.obrazovkaSirka - 40);
                int pomy = -100;

                for (int i = 0; i < 10; i++) {
                    if (this.nepriatelia[i] == null) {
                        switch (randomNepriatel) {
                            case 1:
                                this.nepriatelia[i] = (new Meteor(pomx, pomy, (this.obrazovkaSirka / 20), (this.obrazovkaSirka / 20), 5, this.meteor, this.strely));
                                this.pomPreZjavenieNepriatela = 65;
                                break;
                            case 2:
                                this.nepriatelia[i] = (new Foe1(pomx, pomy, (this.obrazovkaSirka / 20), (this.obrazovkaSirka / 20), 3, this.foe1, this.strely));
                                this.pomPreZjavenieNepriatela = 65;
                                break;
                            case 3:
                                this.nepriatelia[i] = (new Foe2(pomx, pomy, (this.obrazovkaSirka / 20), (this.obrazovkaSirka / 20), 2, this.foe2, this.strely));
                                this.pomPreZjavenieNepriatela = 65;
                                break;
                        }
                        return;
                    }
                }
            }

            this.hrac.pohyb();

            for (int i = 0; i < 20; i++) {
                if (this.hrac.getMojeStrely(i) != null) {
                    this.hrac.getMojeStrely(i).pohyb();

                    if (this.hrac.getMojeStrely(i).odletenaStrela()) {
                        this.hrac.setMojeStrely(i, null);
                    }
                }

            }

            for (Strela strela : this.strely) {
                strela.pohyb();
                if (strela.getRectangle().intersects(this.hrac.getRectangle())) {
                    this.timer.stop();
                    this.napisGameOver.setVisible(true);
                }
            }

            for (int i = 0; i < 10; i++) {
                if (this.nepriatelia[i] != null) {

                    this.nepriatelia[i].pohyb();

                    if (Math.random() > 0.99) {
                        this.nepriatelia[i].vystrel(this.strely);
                    }

                    for (int j = 0; j < 20; j++) {
                        if (this.hrac.getMojeStrely(j) != null) {
                            if (this.nepriatelia[i].zasah(this.hrac.getMojeStrely(j))) {
                                if (!(this.nepriatelia[i] instanceof Meteor)) {
                                    this.nepriatelia[i] = null;
                                    this.skoreint++;
                                    this.skore.setText(Integer.toString(this.skoreint));
                                }

                                this.hrac.setMojeStrely(j, null);
                                break;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 10; i++) {

                if (this.nepriatelia[i] != null) {

                    if (this.nepriatelia[i].getRectangle().intersects(this.hrac.getRectangle())) { // ak narazia
                        this.timer.stop();
                        this.napisGameOver.setVisible(true);
                    }
                    if (this.nepriatelia[i].odletNepriatela()) {
                        this.nepriatelia[i] = null;
                    }
                }

            }

            for (int i = 0; i < this.strely.size(); i++) {
                if (this.strely.get(i).getY() > this.obrazovkaVyska) {
                    this.strely.remove(i);
                }
            }

            repaint();
        });
        this.addKeyListener(this);
    }
    
    /**
     *Ovládanie mojej lode pri stlačení šípok. 
     * @param ke 
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        int stlacenaKlavesa = ke.getKeyCode();
        switch (stlacenaKlavesa) {
            case KeyEvent.VK_LEFT:
                this.hrac.setRychlost(-5);
                break;
            case KeyEvent.VK_RIGHT:
                this.hrac.setRychlost(5);
        }
    }
    
    /**
     *Ovládanie mojej lode pri pustení šípok. 
     * @param ke 
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        int stlacenaKlavesa = ke.getKeyCode();
        switch (stlacenaKlavesa) {
            case KeyEvent.VK_LEFT:
                this.hrac.setRychlost(0);
                break;
            case KeyEvent.VK_RIGHT:
                this.hrac.setRychlost(0);
                break;
            case KeyEvent.VK_SPACE:

                this.hrac.vystrel();

        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    /**
     * Vykreslovanie komponentov.
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.pozadie.getImage(), 0, 0, this.obrazovkaSirka, this.obrazovkaVyska, this);
        g.drawImage(this.hrac.getObrazok().getImage(), this.hrac.getX(), this.hrac.getY(), this.hrac.getSirka(), this.hrac.getVyska(), this);

        for (int i = 0; i < 20; i++) {
            if (this.hrac.getMojeStrely(i) != null) {
                g.drawImage(this.hrac.getMojeStrely(i).getObrazok().getImage(), this.hrac.getMojeStrely(i).getX(), this.hrac.getMojeStrely(i).getY(), this.hrac.getMojeStrely(i).getSirka(), this.hrac.getMojeStrely(i).getVyska(), this);
            }
        }

        for (Strela s : this.strely) {
            g.drawImage(s.getObrazok().getImage(), s.getX(), s.getY(), s.getSirka(), s.getVyska(), this);
        }
        for (Nepriatel n : this.nepriatelia) {
            if (n != null) {
                g.drawImage(n.getObrazok().getImage(), n.getX(), n.getY(), n.getSirka(), n.getVyska(), this);
            }
        }
    }

}
