package evidencia.zamestnancov;

import java.util.Scanner;
import java.io.*;
/**
 * vyhladavanie v poli podla kazdej polozky
 * 
 * @author Martin Záhora
 * @version (a version number or a date)
 */
public class Hladat {
   /**obsahuje text menu pre hladanie zamestnancov*/
   private static final String menu="MENU HLADATANIE\n hladat podla(staci zadat aj podretazec):\n[1]mena\n[2]priezviska\n"+
                               "[3]rod.cisla\n[4]tel.cisla\n[5]ulice\n[6]mesta\n"+
                               "[7]=>hl. menu";
   
   /**pomocna logic. premenna ktora uchovava info. ci sa nieco naslo alebo nie*/
   private static boolean b;
   /**na ulozenie vstupu z klavesnice*/
   private static String vstup;
   /**sluzi pri postupnom vypisovani*/
   private static int x;
   /**instan. triedy Scanner na citanie z klavensice*/ 
   private static Scanner klav=new Scanner(System.in);
   
   /**hladanie podretazca v prislusnom stlpci, ak najde vypise formatovane dany riadok cely.
    *@param int paStlpec: index stlpca v kt. ma hladat = 0-priezviska,1-mena,2- rokNarod., .... 6-mesta.
    *@param String slovo hladany retazec,ako podretazec.
    *
    */
   private static void hladaj(String slovo,int stlpec) {
    b = false;
    boolean bolo = false;
    x = 0;
    slovo=slovo.toLowerCase();
    if (!slovo.isEmpty()){
     for(int r = 0;r < Pole.nenuloveRiadkyPola(); r++){
       if(EvidenciaZamestnancov.pole[r][stlpec].toLowerCase().matches("(?i).*"+slovo+".*")) {
          x++;
          if (x==1){for(int i=0;i<Vypis.hlavicka.length;i++) {
              System.out.printf("%-"+Pole.max()+"s",Vypis.hlavicka[i]);}
                   System.out.println();}   
          Pole.vypisRiadka(r);
          System.out.println();
          b = true;
          if(x>9 && x%10==0){System.out.print("ENTER");klav.nextLine();};
        }
          
     }   
     System.out.println("Najdenych :" + x);
    }
    else System.out.println("Nezadal(a) si žiadny podreťazec");   
    
    b = false;
   }

   
   /**
    * metoda vypisuje menu a pyta si od nas podla coho chceme hladat.
    * robi sa to v cykle do while.
    * vola metodu hladaj(str.,int,boolean) vzdy si inymi realnymi parametrami.
    */
   public static void main() throws IOException
   {
    b=false;
    System.out.println(menu);
    
    do{    
      System.out.print("zadaj cislo volby ('0' pre menu hladania):");
      vstup=klav.nextLine();
      System.out.println();     
      if(vstup.isEmpty() || vstup.trim().length()!=1 || !Character.isDigit(vstup.charAt(0)) )
       {System.out.println("Nespravne si zadal(a)");}
        
      else{
        switch(vstup.codePointAt(0))
        {
         case 48: System.out.println(menu);break;      
         case 49: System.out.print("Napis meno: ");       hladaj(klav.nextLine().trim(),0);break;
         case 50: System.out.print("Napis priezvisko: "); hladaj(klav.nextLine().trim(),1); break;
         case 51: System.out.print("Napis rod.cislo: "); hladaj(klav.nextLine().trim(),2);break;
         case 52: System.out.print("Napis tel.cislo: "); hladaj(klav.nextLine().trim(),3);break;
         case 53: System.out.print("Napis ulicu: "); hladaj(klav.nextLine().trim(),4);break;
         case 54: System.out.print("Napis mesto: "); hladaj(klav.nextLine().trim(),5);break;
                          
         case 55: b=true; System.out.println("\n=>hl. menu;\n"+EvidenciaZamestnancov.menu) ;break;
         default: System.out.println("Nespravny vyber('0' pre menu)");break;         
         }                
        }
      }while(b==false);
    }
    
   
  }
