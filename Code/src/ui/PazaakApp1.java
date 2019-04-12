    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package ui;

import domein.DomeinController;
import domein.Speler;
import domein.Wedstrijd;
import exceptions.IllegalNameException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author timgr.
 */
public class PazaakApp1 {


    private final DomeinController dc;
    //blabla
    /**
     *@param args the command line arguments
     */
    
    /**
     *
     * @param dc
     */
    public PazaakApp1(DomeinController dc)
    {   this.dc=dc;
    }
    public void  start() throws SQLException, IllegalNameException{
    boolean validatie=false;
    int taalkeuze;
    int menukeuze;
    
  
    Scanner s = new Scanner(System.in);
    
     do {
            try {
                System.out.println("Choose the language you would like to use\n(1:Nederlands,2:Français,3:English)");
                taalkeuze = s.nextInt();
                dc.maakTaal(taalkeuze);
                validatie = true;
            } catch (InputMismatchException imex) {
                System.out.println("The entered value was not a number please try again!\n");
                s.next();
            } catch (IllegalArgumentException iaex) {
                System.out.println("You have to choose between 1,2 or 3!\n");
                
            }
        }while (validatie==false);
     
      validatie = false;
     do {
            try {
                System.out.println(dc.geefTekst("keuzemenu"));
                menukeuze = s.nextInt();
                switch(menukeuze){
                    case 1: maakNieuweSpeler(this.dc);
                    break;
                    case 2: PazaakApp3 app3 =new PazaakApp3(this.dc);
                    break;
                    case 3: laadBestaandeSpel();
                    break;
                    default: throw new IllegalArgumentException();
                }
                validatie = true;
            } catch (InputMismatchException imex) {
                System.out.println(dc.geefTekst("ExceptionNoInt"));
                s.next();
                
            } catch (IllegalArgumentException iaex) {
                System.out.println(dc.geefTekst("ExceptionIntOutOfRange1-3"));
                
            }
        } while (validatie==false);
     
      validatie = false;
}
    private void maakNieuweSpeler(DomeinController dc){
        String naam="";
        int geboortejaar=0;
        boolean validatie=false;
        Scanner s = new Scanner(System.in);
        do {
            try {
                System.out.println(dc.geefTekst("Geefnaam"));
                naam = s.nextLine();
                if(dc.geldigeSpelernaam(naam))
                validatie= true;
            } catch (InputMismatchException imex) {
              //  System.out.println(dc.geefTekst("ExceptionNoInt"));
                

            } catch (IllegalArgumentException iaex) {
                //System.out.println(dc.geefTekst("ExceptionIntOutOfRange"));
                
            }
        } while (validatie==false);
        
         validatie = false;

        do {
            try {
                System.out.println(dc.geefTekst("GeefGeboorte"));
                 geboortejaar = s.nextInt();
                if(dc.geldigGeboorteJaar(geboortejaar))
                validatie= true;
            } catch (InputMismatchException imex) {
                System.out.println(dc.geefTekst("ExceptionNoInt"));
                s.next();

            } catch (IllegalArgumentException iaex) {
               // System.out.println("ExceptionIntOutOfRange");
                
            }
        } while (validatie==false);
        dc.maakNieuweSpeler(naam, geboortejaar);
        System.out.println(dc.voorstellingSpeler());
        
}
    private void laadBestaandeSpel() throws SQLException{
        Scanner scan= new Scanner(System.in);
        System.out.println(dc.geefTekst("promtGameName"));
        System.out.println(dc.geefTekst("games"));
        int count = 1;
        boolean validatie=false;
        for(String spel : dc.geefSpellen()){
             System.out.println(count+++"."+ spel);
        }
        do{
            try{
                 System.out.println(dc.geefTekst("laadBestaandeSpel"));
        String keuze = scan.next();
        List<Speler> spelers= dc.geefSpel(keuze);
        dc.maakWedstrijd(spelers.get(0), spelers.get(1));
        PazaakApp6 app6 =new PazaakApp6(this.dc);
        app6.start();
        validatie=true;
            }catch(IndexOutOfBoundsException iae)
            {
                System.out.printf(dc.geefTekst("ExceptionGameNotFound"));
            }
        }while(validatie==false);
//        System.out.println("naam: (gelieve te controleren op schrijffouten)");
//        String keuze = scan.next();
//        List<Speler> spelers= dc.geefSpel(keuze);
//        dc.maakWedstrijd(spelers.get(0), spelers.get(1));
//        PazaakApp6 app6 =new PazaakApp6(this.dc);
//        app6.start();
    }


   
}
