package evidencia.zamestnancov;

import java.util.Scanner;
/**
 * Tieda,ktorá pracuje s polom
 * 
 * @author Martin Zahora 
 * @version 3.12.2016
 */
public class Pole {
    /**sluzi pri inkrementacii*/
    private static int r;
    private static Scanner klav = new Scanner(System.in);
    private static String vstup;
    private static int pocetZmaz;
    public static int nenuloveRiadkyPola() {
        r = 0;
        for (int i = 0;i < EvidenciaZamestnancov.pole.length;i++) {
            if (EvidenciaZamestnancov.pole[i][0] != null) {
                r++;
            }
        }
        return r;
    }
    
    public static int max() {
        r = 1;
        for (int i = 0;i < nenuloveRiadkyPola(); i++) {
            for (int j = 0;j < EvidenciaZamestnancov.pole[i].length;j++) {
                if (EvidenciaZamestnancov.pole[i][j].length() > r) {
                    r = EvidenciaZamestnancov.pole[i][j].length();
                }
            }
        }   
        return r;
    }
 
    /**
    * Metóda na výpis z pola.
    */
    public static void vypisRiadka(int cisloRiadka) {    
        for ( int i = 0;i < nenuloveRiadkyPola(); i++) {
            if (i == cisloRiadka) {
                for (int j = 0;j < EvidenciaZamestnancov.pole[i].length; j++) {
                    System.out.printf("%-" + max() + "s", EvidenciaZamestnancov.pole[i][j]);
                }        
            }   
        }
    }
     
       /**
       * Metóda slúžiaca na zmazanie riadka.Vyhľadá meno a priezvisko 
       * zamestnanca z Hlavny pomocou toLowerCase().matches 
       * a opýta sa či ho chceme zmazať alebo nie.
       */
    public static void zmazRiadokPola(String meno, String priez) {
        meno = meno.toLowerCase();
        priez = priez.toLowerCase();
        pocetZmaz = 0;
        for ( int i = 0;i < nenuloveRiadkyPola();i++) {
            if (EvidenciaZamestnancov.pole[i][0] != null) {
                if (EvidenciaZamestnancov.pole[i][0].toLowerCase().matches("(?i).*" + meno + ".*") &&
                      EvidenciaZamestnancov.pole[i][1].toLowerCase().matches("(?i).*" + priez + ".*"))
                {   
                    System.out.println("Mam zmazat?\n");
                    vypisRiadka(i);  
                    System.out.println();
                    do {
                        System.out.println("[1]ano, [0]nie, : ");
                        vstup = klav.nextLine();
                    }
              while (vstup.equals("1") && vstup.equals("0"));
                    if (vstup.equals("1")) {
                        for (int j = 0;j < EvidenciaZamestnancov.pole[i].length;j++) {
                            EvidenciaZamestnancov.pole[i][j] = "";
                            System.out.println("zmazane\n");
                            pocetZmaz++;
                        }
                    }
                }               
            }
        }
    
    }
  
    public static int getPocetZmaz() {
        return pocetZmaz;
    }
}

