package evidencia.zamestnancov;

import java.util.Scanner;
import java.io.*;

/**
 * Trieda na pridanie nového zamestnanca do existujúcej evidencie.
 * 
 * @author (Martin Záhora) 
 * @version (a version number or a date)
 */
public class Add {
    private static Scanner klav;
    private static String vstup;
    /**
    * na ulozenie info o pocte neprazdnych riadkov Hlavnypola[][]
    */
    private static int r;
    /**
    * metoda prida na zaklade vstupu z klavesnice do Hlavny.pola[][] novy riadok,
    * prepise subor uz s novou polozkou,
    */
    public static void pridat()throws IOException {   
        FileWriter fw = new FileWriter("a.txt", true);
        BufferedWriter b = new BufferedWriter(fw);
        klav = new Scanner(System.in);
        /**int r obsahuje pocet 'riadkov' pola[][] v kt. nie je null*/
        r = Pole.nenuloveRiadkyPola();
        b.newLine();
        do {
            System.out.print("Krsné meno: ");
            vstup = klav.nextLine().trim();
        } while (TestVstupov.slovo(vstup, false) == false); 
        EvidenciaZamestnancov.pole[r][0] = vstup;          
        b.write(vstup + ",");
      
        do {
            System.out.print("Priezvisko: ");
            vstup = klav.nextLine().trim();
        } while (TestVstupov.slovo(vstup, false) == false); 
        EvidenciaZamestnancov.pole[r][1] = vstup;   
        b.write(vstup + ",");
      
        do {
            System.out.print("Rodné číslo(bez / ): ");
            vstup = klav.nextLine().trim();
        } while (TestVstupov.cislo(vstup, false) == false);
        EvidenciaZamestnancov.pole[r][2] = vstup;          
        b.write(vstup + ",");
      
        do { 
            System.out.print("tel./mobil. číslo "); 
            vstup = klav.nextLine().trim();
        } while (TestVstupov.cislo(vstup, true) == false);
        EvidenciaZamestnancov.pole[r][3] = vstup;          
        b.write(vstup + ",");
        System.out.println("Adresa bydliska:");
        do {
            System.out.print("\tulica: ");
            vstup = klav.nextLine().trim();
        } while (TestVstupov.slovo(vstup, true) == false);
        EvidenciaZamestnancov.pole[r][4] = vstup;          
        b.write(vstup + ",");
      
        do {
            System.out.print("\tmesto: ");
            vstup = klav.nextLine().trim();
        } while (TestVstupov.slovo(vstup, false) == false);
        EvidenciaZamestnancov.pole[r][5] = vstup;          
        b.write(vstup + ","); 
      
        b.close();
          
    }
}
