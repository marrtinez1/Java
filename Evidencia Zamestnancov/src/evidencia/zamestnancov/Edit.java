package evidencia.zamestnancov;

import java.util.Scanner;
import java.io.*;
/**
 * Trieda, ktorá slúži na zmenu údajov o zamestnanov.
 * 
 * @author (Martin Záhora) 
 * @version (a version number or a date)
 */
public class Edit {
    /**retazec s obsahom textu menu editacie*/
    static String menu = "EDITOVANIE\nnajst polozku na editovanie podľa:\n[1]mena\n[2]priezviska\n[3]rod. cisla\n[4]tel.cisla\n[5]ulice\n" + 
                "[6]mesta\n[7]návrat do hlavného MENU";
    public static boolean end;
    /**String vstup na ulozenie vstupu z evidencie*/
    private static String vstup;
    private static Scanner klav = new Scanner(System.in);
    
    private static void najdi(int stlpec, String ret) {
    
        /**zmeni sa na true ak sa nieco edituje*/
        boolean z = false;
        /**meni hodnotu v metode editovat(),ak true tak sa uz dalsia editacia neuskutocni*/
        end = false;
        if (!ret.isEmpty()) {
            ret = ret.toLowerCase();   
            for (int r = 0;r < Pole.nenuloveRiadkyPola(); r++) {
                if (end == false && EvidenciaZamestnancov.pole[r][stlpec].toLowerCase().matches("(?i).*" + ret.trim() + ".*")) {
                    for (int i = 0;i < 6;i++) {
                        System.out.print(EvidenciaZamestnancov.pole[r][i] + ", ");
                    }
                    System.out.println("\n");
                    edituj(r);
                    z = true;       
                }
            }    
            if (z == false) {
                System.out.println("Nájdených  '0'");
            }
        
        } else {
            System.out.println("Nezadal si ziadny podretazec");
        }
        end = false;
    }
  
    /**
    * pre dany riadok ponukne editaciu ak uzivatel zada "1"(ano)
    * ak "0"(nie) tak metoda najdi() ponukne dalsi riadok ktory obsahuje hladany podretazec
    * ak "k" String konec nastavi na true
    * @param int r - index riadku, kt. mozeme editovat
    */
    public static void edituj(int r) {
        System.out.println("Chceš editovat túto položku? stlač:");
        do {
            System.out.print("[1]-pre áno, [0]-pre nie, [k]-pre koniec hladania:  ");
            vstup = klav.nextLine();
        } while (!(vstup.equals("1") | vstup.equals("0") | vstup.equals("k") ));
     
        if (vstup.equals("1")) {
            System.out.println("Staré meno: " + EvidenciaZamestnancov.pole[r][0]);
            do {
                System.out.print("Nové meno: "); 
                vstup = klav.nextLine().trim(); 
            } while (TestVstupov.slovo(vstup, false) == false);
            EvidenciaZamestnancov.pole[r][0] = vstup;
        
            System.out.println("Staré priezvisko: " + EvidenciaZamestnancov.pole[r][1]);
            do {
                System.out.print("Nové priezvisko: "); 
                vstup = klav.nextLine().trim(); 
            } while (TestVstupov.slovo(vstup, false) ==  false);
            EvidenciaZamestnancov.pole[r][1] = vstup;
        
            System.out.println("Staré rod. číslo.: " + EvidenciaZamestnancov.pole[r][2]);
            do {
                System.out.print("Nové rod. číslo: "); 
                vstup = klav.nextLine().trim(); 
            } while(TestVstupov.cislo(vstup, false) == false);
            EvidenciaZamestnancov.pole[r][2] = vstup;
        
            System.out.println("Staré tel. číslo: " + EvidenciaZamestnancov.pole[r][3]);
            do {
                System.out.print("Nové tel. číslo: "); 
                vstup = klav.nextLine().trim(); 
            } while(TestVstupov.cislo(vstup, true) == false);
            EvidenciaZamestnancov.pole[r][3] = vstup;
               
            System.out.println("Stará ulica: " + EvidenciaZamestnancov.pole[r][4]);
            do {
                System.out.print("Nová ulica: "); 
                vstup = klav.nextLine().trim(); 
            } while(TestVstupov.slovo(vstup, true) == false);
            EvidenciaZamestnancov.pole[r][4] = vstup;
                
            System.out.println("Staré mesto: " + EvidenciaZamestnancov.pole[r][5]);
            do {
                System.out.print("Nové mesto: "); 
                vstup = klav.nextLine().trim(); 
            } while(TestVstupov.slovo(vstup, false) == false);
            EvidenciaZamestnancov.pole[r][5] = vstup;
                        
        }
        if (vstup.equals("k") == true) {
            end = true;
            System.out.println("Skoncilo ss vyhladavanie"); 
        }
        System.out.println();
    }
    
  
    public static void main() throws IOException {
    /**parametrom switchu je ASCII hodota vstupu,čo je reťazec s dĺžkou 1 vďaka podmienke vyššie */
        String vstup;
        end = false;
        System.out.println(menu);
        do {
            System.out.println("zadaj číslo voľby: (0 zobraz menu EDIT.) ");
            vstup = klav.nextLine().trim();
            if (vstup.length() != 1 || vstup.charAt(0) < '0' && vstup.charAt(0) > '7') {
                System.out.println("Nespravne si zadal\n");
            
            } else {
                /**parametrom switchu je ASCII hodota vstupu,čo je reťazec s dĺžkou 1 vďaka podmienke vyššie */   
                switch (vstup.codePointAt(0)) { 
                    case 48: System.out.println(menu);break;
                    case 49: System.out.print("Napíš meno: ");   najdi(0, klav.nextLine());break;
                    case 50: System.out.print("Napíš priezvisko: ");         najdi(1, klav.nextLine());break;
                    case 51: System.out.print("Napíš rod.cislo: ");najdi(2, klav.nextLine());break;
                    case 52: System.out.print("Napíš te.cislo: ");          najdi(3, klav.nextLine());break;
                    case 53: System.out.print("Napíš ulicu: ");  najdi(4, klav.nextLine());break;
                    case 54: System.out.print("Napíš mesto: ");   najdi(5, klav.nextLine());break;
                    case 55: end = true;System.out.println("\n=>hl. menu");break;
                    default: System.out.println("Nespravne si zadal");
                }
            }
            Subor.prepisSubPolom();
        } while(end == false);
    }
}
