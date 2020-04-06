package spaceHunter;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Trieda, ktorá slúži na vytvorenie nového okna. Nastaví sa jeho názov, správu
 * na exit a prispôsobitelnosť obrazovke.
 *
 * @author martin
 */
public class Main extends JFrame {

    private Panel panel;

    public Main() {

        this.setTitle("SEMESTRÁLNA PRÁCA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);

        this.panel = new Panel();
        this.add(this.panel);
        this.pack();

    }

    /**
     * Spúšťa celú hru.
     *
     * @param args
     */
    public static void main(String[] args) {
        Main okno = new Main();
        okno.setVisible(true);
    }
}
