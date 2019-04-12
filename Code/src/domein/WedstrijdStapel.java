/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *.
 * @author Senne
 */
public class WedstrijdStapel {
    private Speler speler;
    private List<Kaart> stapel;

    public WedstrijdStapel(Speler speler) {
        this.speler = speler;
        this.stapel = new ArrayList();
    }
    public WedstrijdStapel(Speler speler, List<Kaart> kaarten){
        this.speler= speler;
        this.stapel = kaarten;
    }
    public void voegKaartToe(Kaart kaart){
        this.stapel.add(kaart);
        //System.out.println("Kaart toegevoegd in de stapel van " +speler.getNaam());
    }
    public String MaakWedstrijdStapel(){
            Random rand= new Random();
            stapel.remove(rand.nextInt(5));
            stapel.remove(rand.nextInt(4));
            return  voorstellingStapel();
    }
    public Speler getSpeler() {
        return speler;
    }
    public void setSpeler(Speler speler) {
        this.speler = speler;
    }
    public List<Kaart> getStapel() {
        return stapel;
    }
    public void setStapel(List<Kaart> stapel) {
        this.stapel = stapel;
    }
    public String voorstellingStapel(){
        StringBuilder sb = new StringBuilder();
        //sb.append("wedstrijdStapel : ");
        sb.append("\n");
        int count =0;
        for(Kaart kaart : stapel){
           
           sb.append(count++);
           sb.append(".  ");
           sb.append(kaart.voorstellingKaart());
           sb.append("\n");
        }
        return sb.toString();
    }


}
