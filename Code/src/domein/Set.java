/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * .
 * @author Senne
 */
public class Set {

    private final List<Speler> spelers;
    private Stack<Integer> setStapel;
    private Speler winnaar;

    public Set(List<Speler> spelers, Speler speler1) {
        this.spelers = spelers;
        maakSetStapel();
        bepaalVolgorde(speler1);

    }

    public Stack<Integer> getSetStapel() {
        return setStapel;
    }

    public void setSetStapel(Stack<Integer> setStapel) {
        this.setStapel = setStapel;
    }

    public Speler getWinnaar() {
        return winnaar;
    }

    public void beurt(Speler speler) {
        Integer getal = setStapel.pop();
        speler.verhoogsetScore(getal);
        speler.voegToeSpelbord(getal);
    }

    
    
    public void hoogsteScoreGUI()
            //0=20    1=50
    {
        if (spelers.get(0).getSetScore()<spelers.get(1).getSetScore()&&spelers.get(1).getSetScore()<21)
            winnaar=spelers.get(1);
                  
             
             
                
            
                    else if (spelers.get(0).getSetScore()>spelers.get(1).getSetScore()&&spelers.get(0).getSetScore()<21)
                        winnaar= spelers.get(0);
                    else 
                        winnaar=spelers.get(0);
    }
    
    
    
    
    
    public void hoogsteScore() {
        if (spelers.get(0).getSetScore() < spelers.get(1).getSetScore()) {
            winnaar = spelers.get(1);
        } else {
            if (spelers.get(0).getSetScore() == spelers.get(1).getSetScore()) {
                if (spelers.get(0).getSpelbord().size() < spelers.get(1).getSpelbord().size()) {
                    winnaar = spelers.get(1);
                } else {
                    winnaar = spelers.get(0);
                }
            }
            if (spelers.get(0).getSetScore() < spelers.get(1).getSetScore()) {
                winnaar = spelers.get(0);
            }

        }
    }

    public boolean winnaar(Speler speler) {
        if (speler.getSpelbord().size() == 9) {
            this.winnaar = speler;
            return true;

        } else {
            if (speler.getSetScore() > 20) {
                if (speler.getNaam().equals(spelers.get(0).getNaam())) {
                    this.winnaar = spelers.get(1);
                    return true;
                } else {
                    if (speler.getNaam().equals(spelers.get(1).getNaam())) {
                        this.winnaar = spelers.get(0);
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void wipeSpelbord(Speler speler) {
        speler.setSetScore(0);
        speler.wipeSpelbord();
        speler.setBevrozen(false);
    }

    //DR maak setstapel
    private void maakSetStapel() {
        setStapel = new Stack();

        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 4; j++) {
                setStapel.push(i);
            }
        }
        Collections.shuffle(setStapel);
    }

    private void bepaalVolgorde(Speler speler1) {
        if (speler1.equals(spelers.get(1))) {
            Collections.swap(spelers, 0, 1);
        }
    }

}
