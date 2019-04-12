/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package ui;

import domein.DomeinController;
import domein.Set;
import domein.Speler;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Senne
 */
public class PazaakApp6 {

    private final DomeinController dc;

    public PazaakApp6(DomeinController dc) {
        this.dc = dc;
    }

    public void start() throws SQLException {
        boolean validatie;
        while (dc.getSet().getSpelers().get(0).getGewonnenSet() < 3 && dc.getSet().getSpelers().get(1).getGewonnenSet() < 3) {
            validatie = false;
            dc.maakSet();
            while (validatie == false) {
                for (Speler speler : dc.getSet().getSpelers()) {
                    if (speler.isBevrozen() == false) {
                        dc.getSet().beurt(speler);
                        beurt(speler);
                        if (validatie == false) {
                            validatie = dc.getSet().winnaar(speler);
                        }
                        
                    }
                }
                if (dc.getSet().getSpelers().get(0).isBevrozen() && dc.getSet().getSpelers().get(1).isBevrozen()) {
                    validatie = true;
                    dc.getSet().hoogsteScore();

                }
            }
            dc.getSet().wipeSpelbord(dc.getSet().getSpelers().get(0));
            dc.getSet().wipeSpelbord(dc.getSet().getSpelers().get(1));
            System.out.println(dc.getWedstrijd().getWinnaar()+ " " + dc.geefTekst("gewonnen"));
            System.out.println(dc.geefTekst("tussenStand")+ "\n" + dc.geefSpelersWedstrijd().get(0).getNaam() + " " + dc.geefSpelersWedstrijd().get(0).getGewonnenSet() + "\n" + dc.geefSpelersWedstrijd().get(1).getNaam() +" "+ dc.geefSpelersWedstrijd().get(1).getGewonnenSet());
            System.out.println(dc.geefTekst("wensOpslaan"));
                        int keuze;
                        Scanner scan = new Scanner(System.in);
                        keuze = scan.nextInt();
                        if(keuze == 1){
                           spelOpslaan();
                           System.out.println(dc.geefTekst("verderSpeler"));
                           if(scan.nextInt()==1){
                               start();
                           }
                           else{
                               return;
                           }
                        }
        }
        System.out.println(dc.getWedstrijd().returnWinnaarnaam() + " " + dc.geefTekst("verhoogKrediet"));
    }

   /* private void toonKeuzeMenu() {
        System.out.println(dc.geefTekst("keuzeWedstrijd"));
    }*/
    
    private void spelOpslaan() throws SQLException{
        Scanner scan = new Scanner(System.in);
        
        
            System.out.println(dc.geefTekst("saveNaam"));
            String naam = scan.next();
            dc.slaSpelOp(dc.geefSpelersWedstrijd().get(0).getWs().getStapel(), dc.geefSpelersWedstrijd().get(0),dc.geefSpelersWedstrijd().get(1).getWs().getStapel(), dc.geefSpelersWedstrijd().get(1), naam);
    }
    private void beurt(Speler speler) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(speler.getNaam() + " " + dc.geefTekst("beurt"));
        wedstrijdSituatie(speler);

        int keuze = 0;
        while (keuze != 1) {
            System.out.println(dc.geefTekst("keuzeWedstrijd"));
            System.out.println(dc.geefTekst("uKeuze"));
            keuze = scan.nextInt();
            switch (keuze) {
                case 1:
                    System.out.println(dc.geefTekst("eindeBeurt"));
                    
                    return;
                case 2:
                    System.out.println(dc.geefTekst("gebruikWedstrijdkaart"));
                    wedstrijdkaartGebruiken(speler);
                    return;
                   
                case 3:
                    System.out.println(dc.geefTekst("bevrozenBord"));
                    speler.setBevrozen(true);
                    return;
                default:
                    System.out.println(dc.geefTekst("foutKeuze"));
                    break;

            }
        }

    }

    private void wedstrijdSituatie(Speler speler) {
        System.out.println(dc.geefTekst("spelbord"));
        System.out.println(speler.getSpelbordString());
        System.out.println(dc.geefTekst("setScore")+ " " + speler.getSetScore() + "\n");
        System.out.println(speler.toonWedstrijdStapel());

    }

    private void wedstrijdkaartGebruiken(Speler speler) {
        Scanner scan = new Scanner(System.in);

        System.out.println(speler.getNaam().toUpperCase() + dc.geefTekst("kiesUit"));
        System.out.println(speler.toonWedstrijdStapel());
        int keuze = scan.nextInt();

        boolean validatie = false;
        while (validatie != true){
         switch (speler.getWs().getStapel().get(keuze).getType()) {

            case '+':
                speler.verhoogsetScore(speler.getWs().getStapel().get(keuze).getWaarde());
                validatie = true;
                System.out.println(dc.geefTekst("verhoogd")+ speler.getWs().getStapel().get(keuze).getWaarde());
                break;
            case '*':
                System.out.println(dc.geefTekst("kiesPlusMin"));
                validatie = true;
                keuze = scan.nextInt();
                switch (keuze) {
                    case 1:
                        speler.verhoogsetScore(speler.getWs().getStapel().get(keuze).getWaarde());
                        System.out.println((dc.geefTekst("verhoogd")+ " " + speler.getWs().getStapel().get(keuze).getWaarde()));
                    case 2:
                        speler.verlaagsetScore(speler.getWs().getStapel().get(keuze).getWaarde());
                        System.out.println((dc.geefTekst("verlaagd")+ " " + speler.getWs().getStapel().get(keuze).getWaarde()));

                }
                break;
            case '-':
                validatie = true;
                speler.verlaagsetScore(speler.getWs().getStapel().get(keuze).getWaarde());
                System.out.println(dc.geefTekst("verlaagd")+ " " + speler.getWs().getStapel().get(keuze).getWaarde());

        }
        speler.voegToeSpelbord(speler.getWs().getStapel().get(keuze).getWaarde());
    }

}
}
/* private void beurt() {

        Scanner scan = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(dc.geefSpelersWedstrijd(). + " is aan de beurt:");
        Integer getal = setStapel.pop();
        speler.voegToeSpelbord(getal);
        System.out.println("u heeft een " + getal + " getrokken");
        speler.verhoogsetScore(getal);
        System.out.println("spelbord : ");
        for (Integer i : speler.getSpelbord()) {
            System.out.println(i);
        }
        System.out.println("uw set score : " + speler.getSetScore());
        System.out.println(speler.toonWedstrijdStapel());
        toonKeuzeMenu();
        int keuze = 0;
        while (keuze > 3 || keuze == 0) {
            System.out.println(" uw keuze : \n");
            keuze = scan.nextInt();
            switch (keuze) 
                case 1:
                    System.out.println("uw beurt is gedaan");
                    break;
                case 2:
                    System.out.println("wedstrijd kaart gebruiken: ");
                    Kaart kaart = wedstrijdkaartGebruiken(speler);
                    kaarttoevoegen(kaart, speler);
                    break;
                case 3:
                    System.out.println("je spelbord wordt bevrozen");
                    speler.setBevrozen(true);
                    break;
                default:
                    System.out.println("foutieve keuze");
                    break;

            }
        }
        return winnaar(speler);
    }
 */
