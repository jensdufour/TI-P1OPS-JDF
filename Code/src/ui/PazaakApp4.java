/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package ui;

import domein.DomeinController;
import domein.Kaart;
import domein.Speler;
import exceptions.IllegalNameException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Senne
 */
public class PazaakApp4 {
    private final DomeinController dc;
    

    public PazaakApp4(DomeinController dc) throws SQLException, IllegalNameException {
        this.dc=dc;
        int count=0;
        int tel = 0;
         boolean validatie=false;
        Scanner scan = new Scanner(System.in);
        //loop door 2spelers
       
                 for(Speler speler : dc.geefSpelersWedstrijd()){
                      do{
            try{
                      validatie=false;
            int keuze;
            System.out.println(speler.getNaam() +" " + dc.geefTekst("wilKopen"));
            keuze = scan.nextInt();
            if(keuze == 1){
                PazaakApp7 app7 =new PazaakApp7(this.dc);
                app7.start(speler);
            }
            else if(keuze<1||keuze>2){
                throw new IllegalArgumentException();
            }validatie=true;
        } 
            
            catch(InputMismatchException ime)
            {
                System.out.printf(dc.geefTekst("ExceptionNoInt"));
                scan.next();
            }
                catch(IllegalArgumentException iae)
            {
                System.out.printf(dc.geefTekst("ExceptionIntOutOfRange1-2"));
            }
        }while(validatie==false);
                 }
//        for(Speler speler : dc.geefSpelersWedstrijd()){
//            int keuze;
//            System.out.println(speler.getNaam() +" " + dc.geefTekst("wilKopen"));
//            keuze = scan.nextInt();
//            if(keuze == 1){
//                PazaakApp7 app7 =new PazaakApp7(this.dc);
//                app7.start(speler);
//            }
//        }

        for(Speler speler : dc.geefSpelersWedstrijd()){
        int counter = 0;
        System.out.println(dc.geefTekst("kiesKaart")+speler.getNaam());
        // loop door wedstrijd stapel
        for(Kaart kaart : speler.getSs().getStapel()){
            System.out.println(tel+ speler.getSs().getStapel().get(tel).voorstellingKaart());   
            tel++;
        }
       
        // kaarten keizen
        
        tel=0;
        do{
            try{
                 validatie=false;
                  while(counter < 6){
        //System.out.println(dc.geefTekst("kiesKaart") + speler.getNaam());
        System.out.println(dc.geefTekst("kiesNog")+ speler.getNaam());
        
        int keuze = scan.nextInt();
        if(keuze<0||keuze>9)
            throw new IllegalArgumentException();
        for(Kaart kaart : speler.getWs().getStapel()){
            if(speler.getSs().getStapel().get(keuze).equals(kaart)){
                throw new IllegalNameException();
            }
        }
        dc.voegKaartToeWedstrijdStapel(speler.getSs().getStapel().get(keuze), speler);
        counter ++;
        
        }
                  validatie=true;
            }catch(IllegalNameException ine){
                System.out.println(dc.geefTekst("alGekozen"));
                
            }
            
            catch(InputMismatchException ime)
            {
                System.out.printf(dc.geefTekst("ExceptionNoInt"));
                scan.next();
            }
            catch(IllegalArgumentException iae){
                 System.out.printf(dc.geefTekst("ExceptionIntOutOfRange"));
            }
        }while(validatie==false);
//        while(counter < 6){
//        //System.out.println(dc.geefTekst("kiesKaart") + speler.getNaam());
//        System.out.println(dc.geefTekst("kiesNog")+ speler.getNaam());
//        
//        int keuze = scan.nextInt();
//        dc.voegKaartToeWedstrijdStapel(speler.getSs().getStapel().get(keuze), speler);
//        counter ++;
//        
//        }
        count++;
        System.out.println(speler.getNaam()+" "+ dc.geefTekst("wedstrijdStapel") +dc.geefStapelSpeler(speler) +"\n");
        }
        PazaakApp6 app6 =new PazaakApp6(this.dc);
        app6.start();
        
    }
    
}
