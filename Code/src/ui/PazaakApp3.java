/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package ui;

import domein.DomeinController;
import exceptions.IllegalNameException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author timgr
 */
public class PazaakApp3 {
    private DomeinController dc;

    public PazaakApp3(DomeinController dc) throws SQLException, IllegalNameException {
        this.dc=dc;
        boolean validatie = false;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                if (dc.geefspelers().size() > 1) {
                    System.out.println(dc.geefspelers());
                }
                validatie = true;
                
            } catch (IllegalArgumentException iae) {
                System.out.println(dc.geefTekst("geenSpeler"));
            }
        } while (validatie == false);

        validatie = false;
        
        System.out.println(dc.geefTekst("kiesSpeler"));

       int tel = 1;
        while (tel < 3) {
            for (String speler : dc.geefspelers()) {
                System.out.println(tel+ speler);
                tel ++;
            }
        }
        int count = 1;
        int keuze2 = 0;
        int keuze = 0;
        do {
            try {
                if(count == 1){
                keuze = scan.nextInt();
                if (keuze > tel - 1 || keuze < 1) {
                    throw new IllegalArgumentException(dc.geefTekst("ExceptionIntOutOfRange"));
                } else {
                    
                    System.out.println(dc.geefTekst("uKoos")+ keuze);
                    //System.out.println("speler"+ count);
                    System.out.println(dc.geefSpeler(keuze).toString());
                    
                    validatie = false;
                    System.out.printf(dc.geefTekst("tweedeSpeler"));
                    count++;
                    }
                }else{
                    keuze2 = scan.nextInt();
                if (keuze2 > tel - 1 || keuze2 < 1|| keuze2==keuze) {
                    throw new IllegalArgumentException(dc.geefTekst("ExceptionIntOutOfRange"));
                } else {
                    
                    System.out.println(dc.geefTekst("uKoos")+ keuze2);
                    //System.out.println("speler"+ count);
                    System.out.println(dc.geefSpeler(keuze2).toString());
                    
                    validatie = true;
                    }
                }
            } catch(InputMismatchException ime)
            {
                System.out.printf(dc.geefTekst("ExceptionNoInt"));
                scan.next();
            }
            catch (IllegalArgumentException iae) {
                System.out.printf(dc.geefTekst("foutWaarde")+ dc.geefTekst("PlayerAlreadyChosen"), tel - 1);
                //,dc.geefTekst("PlayerAlreadyChosen")
            }

        } while (validatie == false);
        //System.out.println("spelerKlaar");
        dc.maakWedstrijd(dc.geefSpeler(keuze), dc.geefSpeler(keuze2));
        dc.voegGekochteKaartenSpelerToe(dc.geefSpeler(keuze));
        dc.voegGekochteKaartenSpelerToe(dc.geefSpeler(keuze2));
        PazaakApp4 app4 =new PazaakApp4(this.dc);
        
        

    }

    
}
