package evidencia.zamestnancov;

import java.util.Scanner;
import java.io.*;
/**
 * Vypisovanie zamestnancov usporiadane 
 * 
 * @author Martin Zahora 
 */
public class Vypis {
    /**instancia triedy Scanner pre citanie z klav.*/
    private static Scanner klav = new Scanner(System.in);;
    /**pole stringov = text zahlavia pri stlpcovom vypise*/
    public static String []hlavicka = {"MENO", "PRIEZVISKO", "ROD.Č.", "TEL.Č.", "ULICA", "MESTO"};
    /**pomocne pole pri usporiadavani*/
    private static String [] p;
    /**ukladam dlzku stringu v porovanieSlov()*/
    private static int r;
    /***/
    private static String menu = "Menu vypisu zamestnancov\n" + 
                                "[0]menu vypisu,\nAbecedny vypis podla:\n"+
                                "[1]mena, [2]priezviska, [3]rod.cisla [4]ulice [5]mesta\n"+
                                "[6]return do hl.menu";
    /**
    * metoda pre formatovany vypis evidencie na konzolu,
    * @param int stlpec - index stlpca v poli[][] podla ktoreho ma abecedne vypisat,
    */
    public static void vypisNaKonzolu(int stlpec) throws IOException {
        zoradenie(stlpec);
        if (stlpec < 0 || stlpec > 5)
            stlpec = 1;
            System.out.println("----Zamestnanci-----");
                for (int r = 0; r < hlavicka.length; r++) {
                    System.out.printf("%-" + (Pole.max()+4) + "s", hlavicka[r]); 
                }
                System.out.println();
                for (int i=0; i<Pole.nenuloveRiadkyPola(); i++){
        
                for (int j=0; j<EvidenciaZamestnancov.pole[i].length; j++){
                    System.out.printf("%-" + (Pole.max() + 4) + "s", EvidenciaZamestnancov.pole[i][j]);
                }   
                System.out.println();
                if (i > 9&i%10 == 0) {
                    System.out.print("ENTER");klav.nextLine();
                }
            }
            System.out.println();
        }
 
    private static void zoradenie(int stlpec)throws IOException {
    int i,j,x;
    p = new String[6];
        for (i = 0; i < Pole.nenuloveRiadkyPola() - 1; i++) {
            for (j = 0; j < Pole.nenuloveRiadkyPola() - 1; j++) {
                if (porovnanieSlov(EvidenciaZamestnancov.pole[j][stlpec], EvidenciaZamestnancov.pole[j + 1][stlpec]) == true) {
                    for(x=0;x<6;x++) {
                        p[x]                              = EvidenciaZamestnancov.pole[j][x];
                        EvidenciaZamestnancov.pole[j][x]  = EvidenciaZamestnancov.pole[j+1][x];
                        EvidenciaZamestnancov.pole[j+1][x]= p[x];}
                    }  
                }
            }
    }
 
     /**
      *zisti ktore slovo by bolo dalej v abecednom zozname
      *@param String prve
      *@param String druhe
      *@return true ak prve
      *@return false ak druhe
      */
     private static boolean porovnanieSlov(String prve, String druhe ) {
     r=prve.trim().length();
     if(r< druhe.trim().length())r= druhe.trim().length();
     prve=prve.toLowerCase().trim();
     druhe=druhe.toLowerCase().trim();
         for(int i=0; i<r; i++){
             if (prve.charAt(i) > druhe.charAt(i))return true;
             if (prve.charAt(i) < druhe.charAt(i))return false;
            }   
            return false;
    }
 
     public static void main()throws IOException{
      System.out.println(menu);
      String vstup;  
      boolean koniec=false;
        do {
            System.out.println("\nZadaj cislo volby(0 je zobrazenie menu)");
            vstup = klav.nextLine().trim();
            if (vstup.length() != 1 || vstup.charAt(0) > '6' || vstup.charAt(0) < '0') 
            { System.out.println("Nezadal si ziadnu z moznosti, vyber znova\n");}
        
            else{
            /**
             * v switchi sa robi vyber z menu
             * parameter je ascii hodnota znaku z vstupu
             */           
            switch(vstup.codePointAt(0)) {
              /**vypis menu*/
              case 48: System.out.println(menu); break; 
        
              case 49: vypisNaKonzolu(0);break; 
        
              case 50: vypisNaKonzolu(1);break;     
        
              case 51: vypisNaKonzolu(2);break;
        
              case 52: vypisNaKonzolu(4);break;
        
              case 53: vypisNaKonzolu(5);break;      
              /**nesplni sa podmienka v cykle a navrat do hl. menu*/  
              case 54: koniec=true;System.out.println("=>hl.menu");break; 
              /**tuto vetva asi ani netreba lebo vstup je osetreny*/  
              default: System.out.println("Nezadal si ziadnu z moznosti, vyber znova");break;
         
                     }
                }
            } while (koniec==false);
        } 
    }

