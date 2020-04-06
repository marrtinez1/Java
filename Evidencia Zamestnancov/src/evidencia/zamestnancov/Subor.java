package evidencia.zamestnancov;

import java.io.*;
import java.util.*;

/**
 *Trieda pracuje so subormi.
 * 
 * @author Martin Záhora
 * @version 3.12.2016 
 */
public class Subor {
    private static FileReader fr;
    private static Scanner in;
    /**pri urcovani poctu riadkov*/
    private static int x;
    private static int [] ciarky = new int[6];
    /**pomocny retazec pri prepis suboru polom*/
    private static String pom = "";
    /**
    * metoda najde ciarky
    */  
    public static void najdiCiarky(String riadok) {
        x = 0;
        //ciarky=new int[6];
        for (int i = 0;i < riadok.length();i++) {
            if (riadok.charAt(i) == ',') {
                ciarky[x++] = i;
            }
        } 
    
        /*ciarky[0]=riadok.indexOf(",");
         * ciarky[1]=riadok.indexOf(",",ciarky[0]+1);
         * ciarky[2]=riadok.indexOf(",",ciarky[1]+1);
         * ciarky[3]=riadok.indexOf(",",ciarky[2]+1);
         * ciarky[4]=riadok.indexOf(",",ciarky[3]+1);
         * ciarky[5]=riadok.indexOf(",",ciarky[4]+1);*/
    }
    
   /**naplni pole udajmi z evidencie ,
   *do 0.stlpca- mena; 1. priezviska; 2. rod cisla, 3. mob.cisla 4. bydliska
    */
    public static void naplnPole() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(EvidenciaZamestnancov.f));    
        String riadok;
         
        for (int k = 0; k < EvidenciaZamestnancov.pole.length; k++) {
            for (int l = 0;l < EvidenciaZamestnancov.pole[k].length; l++) {
                EvidenciaZamestnancov.pole[k][l] = null;
            }
        }
       
        for (int i = 0;i < pocetRiadkovSub(); i++) { 
            riadok = br.readLine();
            najdiCiarky(riadok.trim());
            EvidenciaZamestnancov.pole[i][0] = riadok.substring( 0, ciarky[0]); 
            EvidenciaZamestnancov.pole[i][1] = riadok.substring( ciarky[0] + 1 , ciarky[1] ); 
            EvidenciaZamestnancov.pole[i][2] = riadok.substring( ciarky[1] + 1 , ciarky[2] ); 
            EvidenciaZamestnancov.pole[i][3] = riadok.substring( ciarky[2] + 1 , ciarky[3] );
            EvidenciaZamestnancov.pole[i][4] = riadok.substring( ciarky[3] + 1 , ciarky[4] );
            EvidenciaZamestnancov.pole[i][5] = riadok.substring( ciarky[4] + 1 , ciarky[5] );
        }
        br.close();
    }
     
     /**
      *zisti pocet zaplnenych riadkov v evidencia.txt,
      *@return int r = pocet riadkov,
      */
    public static int pocetRiadkovSub() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(EvidenciaZamestnancov.f));    
        /**int r sluzi na ukladanie poctu neprazdnych riadkov v subore*/
        int r = 0;
        while (br.readLine() != null) {
            r++;
        }
        br.close();
        return r;
    }
 
 
     /**
      * vypyta si priezvisko a meno majitela pre vymazanie,
      * najde zamestnanca v a.txt a spyta sa ci ho chceme vymazat,
      * zapise do b.txt vsetkych okrem daneho uzivatela,
      * a.txt prepise obsahom z b.txt,
      * pole[][] naplni uz zmenenou evidenciou
      */
    public static void zmazRiadok() throws IOException {
        in = new Scanner(System.in);
        /**m-meno, p-priezvisko*/
        String m, p;
        System.out.println("Zadaj meno a priezvisko zamestnanca, kt. chces vymazat s evidencie");
        do {    
            System.out.print("Meno: "); 
            m = in.nextLine().trim();
            System.out.print("Priezvisko: "); 
            p = in.nextLine().trim(); 
        }
        while (TestVstupov.slovo(m , false) == false & TestVstupov.slovo(p , false) == false);
        Pole.zmazRiadokPola(m, p);
        System.out.println("zmazanych: " + Pole.getPocetZmaz());
        prepisSubPolom();
        naplnPole();
    } 
 
     /**
      * Nahradza obsah 1 suboru inym
      * @param prvy - nazov suboru
      * @param druhy - nazov suboru
      * prepise sa prvy subor druhym
      */
    public static void prepisSuborov(String prvy, String druhy) throws IOException {
        File f = new File(druhy);
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(prvy, false));
        String riadok;
        while ((riadok = br.readLine()) != null) {
            bw.write(riadok);
            bw.newLine();
        }
        br.close();
        bw.close();
        
    }
     
     /**
      * Prepisuje subor so zamestnancami polom.
      * Jednotlive policka (retazce) v riadku spajam ciarkou.
      * Po 1 riadku zapisem cele pole do suboru
      */
    public static void prepisSubPolom() throws IOException {
        BufferedWriter b = new BufferedWriter(new FileWriter("a.txt"));
        int r = Pole.nenuloveRiadkyPola();
        for (int i = 0;i < r; i++) {
            if (EvidenciaZamestnancov.pole[i][0] != null && !EvidenciaZamestnancov.pole[i][0].equals("")) {
                for (int j = 0;j < EvidenciaZamestnancov.pole[i].length;j++) { 
                    pom = pom + EvidenciaZamestnancov.pole[i][j] + ",";
                }
                b.write(pom);
                if (i != r) {
                    b.newLine();
                    pom = "";
                }
            }
        }    
        b.close();
    }
}
