/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package domein;

import java.util.ArrayList;

/**
 *.
 * @author Senne
 */
//bladie blablablaa
public class StartStapel {
    private ArrayList<Kaart> stapel = new ArrayList();
    public StartStapel() {
      Kaart kaart1 = new Kaart('+',2);
      stapel.add(kaart1);
      Kaart kaart2 = new Kaart('+',4);
      stapel.add(kaart2);
      Kaart kaart3 = new Kaart('+',5);
      stapel.add(kaart3);
      Kaart kaart4 = new Kaart('+',6);
      stapel.add(kaart4);
      Kaart kaart5 = new Kaart('*',1);
      stapel.add(kaart5);
      Kaart kaart6 = new Kaart('*',3);
      stapel.add(kaart6);
      Kaart kaart7 = new Kaart('-',1);
      stapel.add(kaart7);
      Kaart kaart8 = new Kaart('-',2);
      stapel.add(kaart8);
      Kaart kaart9 = new Kaart('-',3);
      stapel.add(kaart9);
      Kaart kaart10 = new Kaart('-',5);
      stapel.add(kaart10);
     }

    public ArrayList<Kaart> getStapel() {
        return stapel;
    }
    public void voegKaartToe(char type, int waarde){
       Kaart kaart = new Kaart(type, waarde);
       stapel.add(kaart);
    }
    public void voegKaartToe(Kaart kaart){
        stapel.add(kaart);
    }
    
    
    public String voorstellingStapel(){
        StringBuilder sb = new StringBuilder();
        sb.append("StartStapel : ");
        sb.append("\n");
        for(Kaart kaart : stapel){
           sb.append(kaart.voorstellingKaart());
           sb.append("\n");
        }
        return sb.toString();
    }
    
    



}
