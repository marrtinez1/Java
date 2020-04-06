package evidencia.zamestnancov;

import java.util.*;
import java.io.*;
/**
 * trieda v ktorej sa pracuje s evidenciou zamestnancov.
 * 
 * @author Martin Zahora
 */
public class EvidenciaZamestnancov {
  
    /**pole ktore uchovava evidenciu ako maticu*/
    static String [][]pole;
    public static File f = new File("a.txt");
    /**String menu obsahuje text hlavneho menu*/
    static final String menu = "HLAV. MENU :\n[0] menu(vypisat)\n[1] Vypísať zamestnancov\n[2] Hladať \n[3] Pridať\n[4] Odstrániť\n[5] Editovať\n[6] EXIT\n";
    private static Scanner klav;
    /**na ulozenie retazca zadaneho z klav.*/
    private static String vstup;
  
    private static boolean koniec;
    /**
    * konstruktor ,
    * zisti pocet neprazdnych riadkov v a.txt pomocou metody pocetRiadkovSub(),
    * vytvori pole[][] s danym poctom riadkov + 5 navyse= volne riadky na pridavanie),
    * a s 6 stlpcami;
    * a naplni pole[][] zo suboru cez naplnPole(),
    */
    public EvidenciaZamestnancov()throws IOException {
        pole = new String[Subor.pocetRiadkovSub() + 5][6];
        Subor.naplnPole();
    }
 
    public static void main(String[] args) throws IOException {
    
    /**vytvaram instanciu triedy Hlavny len preto aby som vytvoril pole[][] a naplnil ho */
        EvidenciaZamestnancov program = new EvidenciaZamestnancov(); 
        klav = new Scanner(System.in);
        System.out.println("\f\tEVIDENCIA ZAMESTNANCOV\n\n");
        System.out.println(menu);
  
     /**cyklus aby sme si moholi opakovane zadavat volbu v menu*/       
        do {
            System.out.println("\nZadaj cislo volby(0 je zobrazenie menu)");
            vstup = klav.nextLine();
            if (vstup.length() != 1 || vstup.charAt(0) > '6' || vstup.charAt(0) < '0') {
                System.out.println("nespravne si zadal\n");
    
            } else {
        /**
         * v switchi sa robi vyber z menu
         * parameter je ascii hodnota znaku z vstupu
         */           
                switch(vstup.codePointAt(0)) {
                        /**vypis menu*/
                        case 48: System.out.println(menu); 
                        break; 
                        /**vypis celej evidencie*/    
                        case 49: Vypis.main();break; 
                        /**hladanie v evidencii */      
                        case 50: Hladat.main();break;     
                        /**pridanie polozky*/      
                        case 51: Add.pridat();break;
                        /**zmazanie polozky*/
                        case 52: Subor.zmazRiadok();break;
                        /**editovanie polozky*/
                        case 53: Edit.main();break;      
                        /**vetva '4' ktora ukonci program vdaka podmienke na konci*/  
                        case 54: koniec = true;System.out.print("\f");break; 
                        /**tuto vetva asi ani netreba lebo vstup je osetreny*/  
                        default: System.out.println("Nezadal si ziadnu z moznosti, vyber znova");break;
     
                    }
                }
            } while(koniec == false);
    }    
}