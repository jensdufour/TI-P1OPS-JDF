/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;

/**
 *.
 * @author timgr
 */
public final class Wedstrijd {

    private List<Speler> spelers;
    private Set set;
   
    

    public Wedstrijd(Speler speler1, Speler speler2) {
        this.spelers = new ArrayList();
        this.spelers.add(speler1);
        this.spelers.add(speler2);
        System.out.println("Wedstrijd aangemaakt!");
        maakSet();
    }
  
    
    

    public Set getSet() {
        return set;
    }

    public void maakSet() {
        this.set = new Set(spelers, bepaalBeurt());
    }
    public String getWinnaar(){
        set.getWinnaar().verhoogGewonnenSet();
        return set.getWinnaar().getNaam();
    }
    public void voegKaartToe(Kaart kaart, Speler speler) {
        for (Speler spieler : spelers) {
            if (spieler.getNaam().equalsIgnoreCase(speler.getNaam())) {
                spieler.voegKaartToeWedstrijdStapel(kaart);
            }
        }
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public String geefStapelSpeler(Speler speler) {
        for (Speler spieler : spelers) {
            if (spieler.getNaam().equalsIgnoreCase(speler.getNaam())) {
                return spieler.geefWedstrijdStapel();
            }
        }
        return "Fout bij ophalen stapel.";
    }
    
    public String returnWinnaarnaam() {
        if (spelers.get(0).getGewonnenSet() == 3) {
            spelers.get(0).verhoogKrediet(5);
            return spelers.get(0).getNaam();
        } else {
            spelers.get(1).verhoogKrediet(5);
            return spelers.get(1).getNaam();
        }

    }

    public Speler bepaalEerstebeurt() {
        if (spelers.get(0).getGeboortejaar() < spelers.get(1).getGeboortejaar()) {
            return spelers.get(0);
        } else if (spelers.get(0).getGeboortejaar() > spelers.get(1).getGeboortejaar()) {
            return spelers.get(1);
        } else if (spelers.get(0).getNaam().compareTo(spelers.get(1).getNaam()) > 0) {
            return spelers.get(0);
        } else {
            return spelers.get(1);
        }
    }

    public Speler bepaalBeurt() {
        if (spelers.get(0).getGewonnenSet() + spelers.get(1).getGewonnenSet() % 2 == 0) {
            return bepaalEerstebeurt();
        } else if (bepaalEerstebeurt().equals(spelers.get(0))) {
            return spelers.get(1);
        } else {
            return spelers.get(0);
        }
    }

    
}
 