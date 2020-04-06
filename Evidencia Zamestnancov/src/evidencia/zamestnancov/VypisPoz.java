package evidencia.zamestnancov;

public class VypisPoz {
    
    public void main(String[] args) {
        Osoba prva = new Osoba("Peter", "Havadej", Pozicia.RIADITEĽ);
        Osoba druha = new Osoba("Slávka", "Kovárová", Pozicia.SEKRETÁRKA);
        Osoba tretia = new Osoba("Jozef", "Hrach", Pozicia.MAJSTER);
        Osoba stvrta = new Osoba("Mária", "Harčová", Pozicia.UPRATOVAČKA);
        Osoba piata = new Osoba("Jaroslav", "Karľa", Pozicia.THP);
        Osoba siesta = new Osoba("Vladimír", "Kupec", Pozicia.THP);
        Osoba siedma = new Osoba("Edita", "Lipková", Pozicia.BRIGÁDNIK);
        Osoba osma = new Osoba("Onderj", "Lukáček", Pozicia.BRIGÁDNIK);
        Osoba deviata = new Osoba("Štefan", "Majerčík", Pozicia.THP);
        Osoba desiata = new Osoba("Renáta", "Majirská", Pozicia.THP);
        
        Osoba jedenasta = new Osoba("Viktor", "Medved", Pozicia.THP);
        Osoba dvanasta = new Osoba("Ľuboslava", "Opielová", Pozicia.BRIGÁDNIK);
        Osoba trinasta = new Osoba("Juraj", "Philippi", Pozicia.BRIGÁDNIK);
        Osoba strnasta = new Osoba("Dana", "Pitellová", Pozicia.THP);
        Osoba patnasta = new Osoba("Marek", "Ponižny", Pozicia.THP);
        Osoba sestnasta = new Osoba("Ingrid", "Potočáková", Pozicia.THP);
        Osoba sedemnasta = new Osoba("Milan", "Puchala", Pozicia.THP);
        Osoba osemnasta = new Osoba("Martin", "Pukančík", Pozicia.THP);
        Osoba devatnasta = new Osoba("Mária", "Svätojánska", Pozicia.EKONÓMKA);
        Osoba dvadsiata = new Osoba("Lubomír", "Valkucak", Pozicia.THP);
        Osoba dvadsiataprva = new Osoba("Pavel", "Verešpej", Pozicia.THP);
        Osoba dvadsiatadruha = new Osoba("Mariana", "Šafranková", Pozicia.THP);
                
        System.out.println("\f" + prva);
        System.out.println(druha);              //java sama zavola toString ale musi existovat v druhej triede
        System.out.println(tretia);
        System.out.println(stvrta);
        System.out.println(piata);
        System.out.println(siesta);
        System.out.println(siedma);
        System.out.println(osma);
        System.out.println(deviata);
        System.out.println(desiata);
        System.out.println(jedenasta);
        System.out.println(dvanasta);
        System.out.println(trinasta);
        System.out.println(strnasta);
        System.out.println(patnasta);
        System.out.println(sestnasta);
        System.out.println(sedemnasta);
        System.out.println(osemnasta);
        System.out.println(devatnasta);
        System.out.println(dvadsiata);
        System.out.println(dvadsiataprva);
        System.out.println(dvadsiatadruha);
        
    }
}

