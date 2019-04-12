/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package ui;

import domein.DomeinController;
import domein.Speler;
import java.sql.SQLException;
import java.util.Scanner;

public class PazaakApp7 {

    private DomeinController dc;

    PazaakApp7(DomeinController dc) {
        this.dc = dc;

    }

    public void start(Speler speler) throws SQLException {
        boolean validatie = false;
        Scanner scan = new Scanner(System.in);
        System.out.println(speler.getNaam() + " " + dc.geefTekst("hebt") + " " + speler.getKrediet() + " " + dc.geefTekst("krediet"));
        
        while(validatie != true){
            toonKaarten();
            System.out.println(dc.geefTekst("gebruikType"));
            System.out.println(dc.geefTekst("stopKopen"));
            int keuze = scan.nextInt();
            switch (keuze) {
                case 1:
                    if (speler.getKrediet() >= 5) {
                        System.out.println(dc.geefTekst("mogelijkeWaarde") + " : 1,2,3,4,5,6 " + dc.geefTekst("prijs") + ": 5\n" + dc.geefTekst("koopKaart"));
                        speler.getSs().voegKaartToe('+', scan.nextInt());
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(5, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                case 2:
                    if (speler.getKrediet() >= 5) {
                        System.out.println(dc.geefTekst("mogelijkeWaarde") + " : 1,2,3,4,5,6 " + dc.geefTekst("prijs") + ": 5\n" + dc.geefTekst("koopKaart"));
                        speler.getSs().voegKaartToe('-', scan.nextInt());
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(5, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                case 3:
                    if (speler.getKrediet() >= 10) {
                        System.out.println(dc.geefTekst("mogelijkeWaarde") + " 1,2,3,4,5,6 " + dc.geefTekst("prijs") + ": 10\n" + dc.geefTekst("koopKaart"));
                        speler.getSs().voegKaartToe('*', scan.nextInt());
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(10, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                case 4:
                    if (speler.getKrediet() >= 20) {

                        speler.getSs().voegKaartToe('T', 1);
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(20, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                case 5:
                    if (speler.getKrediet() >= 30) {

                        speler.getSs().voegKaartToe('D', 0);
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(30, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                case 6:
                    if (speler.getKrediet() >= 50) {
                        System.out.println(dc.geefTekst("mogelijkeWaarde") + " : 1: 2&4\n 2: 3&6 \n" + dc.geefTekst("prijs") + ": 5\n" + dc.geefTekst("koopKaart"));
                        if (scan.nextInt() == 1) {
                            keuze = 24;
                        } else {
                            keuze = 36;
                        }
                        speler.getSs().voegKaartToe('X', keuze);
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(50, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                case 7:
                    if (speler.getKrediet() >= 100) {

                        speler.getSs().voegKaartToe('Y', 12);
                        dc.voegKaartToe(speler.getSs().getStapel().get(speler.getSs().getStapel().size()-1), speler);
                        dc.verlaagKrediet(100, speler);
                        System.out.println(dc.geefTekst("kaartAdd"));
                        validatie = true;
                    } else {
                        System.out.println(speler + dc.geefTekst("geenKrediet"));
                    }
                    break;
                default : System.out.println(dc.geefTekst("kopenGestopt"));
                validatie = true;   
                    break;
            }
        }

    }

    private void toonKaarten() {
        System.out.println("1. type : '+' " + dc.geefTekst("mogelijkeWaarde") + " 1,2,3,4,5,6 " + dc.geefTekst("prijs") + " : 5\n");
        System.out.println("2. type : '-' " + dc.geefTekst("mogelijkeWaarde") + " 1,2,3,4,5,6 " + dc.geefTekst("prijs") + " : 5\n");
        System.out.println("3. type : '+/-' " + dc.geefTekst("mogelijkeWaarde") + " 1,2,3,4,5,6 " + dc.geefTekst("prijs") + " : 10\n");
        System.out.println("4. type : 'T' " + dc.geefTekst("mogelijkeWaarde") + " 1 " + dc.geefTekst("prijs") + " : 20 " + dc.geefTekst("omschrijving1"));
        System.out.println("5. type : 'D' " + dc.geefTekst("mogelijkeWaarde") + "  " + dc.geefTekst("prijs") + " : 30 " + dc.geefTekst("omschrijving2"));
        System.out.println("6. type : 'x&y' " + dc.geefTekst("mogelijkeWaarde") + " 2&4 ,3&6 " + dc.geefTekst("prijs") + " : 50 " + dc.geefTekst("omschrijving3"));
        System.out.println("7. type : 'x+/-y' " + dc.geefTekst("mogelijkeWaarde") + " 1+/-2 " + dc.geefTekst("prijs") + " : 100 " + dc.geefTekst("omschrijving4"));

    }

   

}
