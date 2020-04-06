package evidencia.zamestnancov;

/**
 * trieda pre kontroly vstupov
 * 
 * @author Martin Záhora
 * @version (a version number or a date)
 */
public class TestVstupov {
  /** skontoluje retazec ci predstavuje 10ciferne cislo 
   *@param String cisla (retazec cisel)
   *@return true = ak ano
   * false = ak nie 
   */ 
    public static boolean cislo(String cisla, boolean jeTel) {
        if (!jeTel) { 
            if (cisla.length() == 10) {
                if (!isLong(cisla)) return false;
                return true;   
            
            }   else {
                return false;
            }
        
        }   else {
            if (isLong(cisla)) {
                return true;           
            }   else {
                return false;
            }
        }
    } 
  
    public static boolean isLong(String input) {
  
        try {
            Long.parseLong(input);
            return true;
        
        } catch (Exception e) {
            return false;
        }  
    }
  
   /** skontoluje retazec ci pozostava z pismen alebo nie
   *@param String retatzec
   *@param boolean jeZnacka- true-ak chceme skontrolovat adresu(mozu byt aj cisla,medzery, a ine )
   *-false ak chceme kontrolu obyč. slova
   *@return true = ak nie je slovo
   * false = ak je slovo 
   */ 
    public static boolean  slovo(String slovo, boolean jeAdresa) {
        slovo = slovo.toLowerCase(); 
        char x;
        if (slovo.length() > 0) {
            for (int i = 0; i < slovo.length();i++) { 
                x = slovo.charAt(i);
                if (jeAdresa) {
                    if (!Character.isLetterOrDigit(x) && x != ' ' && x != '/') {
                        return false;
                    }
                
                }   else if (!Character.isLetter(x) && x != ' ') {
                    return false;
                }
            }
            return true;
        
        } else {
            return false;
        }
    }  
}
