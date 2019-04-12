/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package domein;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author timgr
 */
//bladieblabla

public class Speler {
    private int id;
    private int geboortejaar;
    private String naam;
    private int krediet;
    private StartStapel ss;
    private WedstrijdStapel ws;
    private int setScore;
    private List<Integer> spelbord;
    private int gewonnenSet;
    private boolean bevrozen = false;

    public Speler(String naam, int geboorteJaar)  {
        controleerNaam(naam);
        controleerGeboorteJaar(geboorteJaar);
        this.geboortejaar = geboorteJaar;
        this.naam = naam;
        this.krediet = 0;
        this.ss = new StartStapel();
        this.ws = new WedstrijdStapel(this);
        this.spelbord = new ArrayList();
        this.gewonnenSet = 0;
        

    }

    public Speler(int id, String naam, int krediet, WedstrijdStapel ws, int gewonnenSet) {
        this.id = id;
        this.naam = naam;
        this.krediet = krediet;
        this.ws = ws;
        this.gewonnenSet = gewonnenSet;
        this.spelbord = new ArrayList();
    }
    

    public void controleerNaam(String naam)  {
     
       if(naam.matches("[A-Za-z][A-Za-z0-9]+")==false){
               throw new InputMismatchException();

    }
        if (naam.contains(" ") || naam.length() < 3) {
       throw new IllegalArgumentException();
      }
//        Pattern p = Pattern.compile("[^A-Za-z0-9]");
//        Matcher m = p.matcher(naam);
//        boolean b = m.find();
//        if (b == true) {
//            throw new IllegalArgumentException("De naam mag geen speciale tekens bevatten");
//        }
    }

    public void voegKaartToeWedstrijdStapel(Kaart kaart) {
        ws.voegKaartToe(kaart);
    }
    

    public String geefWedstrijdStapel() {
        return ws.MaakWedstrijdStapel();
    }

    public String toonWedstrijdStapel() {
        return ws.voorstellingStapel();
    }

    public void controleerGeboorteJaar(int geboorteJaar) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(geboorteJaar, 1, 1);
        Period p = Period.between(birthday, today);
        
        if (p.getYears() < 6 || p.getYears() > 99) {
            throw new IllegalArgumentException();
        }

    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboorteJaar(int geboorteJaar) {
        controleerGeboorteJaar(geboorteJaar);
        this.geboortejaar = geboorteJaar;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        controleerNaam(naam);
        this.naam = naam;
    }

    public int getKrediet() {
        return krediet;
    }

    public void setKrediet(int krediet) {
        this.krediet = krediet;
    }

    public StartStapel getSs() {
        return ss;
    }

    public void verhoogKrediet(int krediet) {
        setKrediet(getKrediet() + krediet);
    }
    
    public void verlaagKrediet(int krediet) {
        setKrediet(getKrediet() - krediet);
        
    }

   public void verhoogsetScore(int setscore) {
        this.setScore += setscore;
    }

    public void verlaagsetScore(int setscore) {
        this.setScore -= setscore;
    }

    public int getSetScore() {
        return setScore;
    }

    public void voegToeSpelbord(Integer i) {
        this.spelbord.add(i);
    }

    public List<Integer> getSpelbord() {
        return spelbord;
    }

    public String getSpelbordString() {
        String output = "";
        for (int i : spelbord) {
            output += i + " \n";
        }
        return output;
    }

    public void setSetScore(int setScore) {
        this.setScore = setScore;
    }

    public void wipeSpelbord() {
        this.spelbord.clear();
    }

    public int getGewonnenSet() {
        return gewonnenSet;
    }

    public WedstrijdStapel getWs() {
        return ws;
    }

    public void verhoogGewonnenSet() {
        this.gewonnenSet++;
    }

    public boolean isBevrozen() {
        return bevrozen;
    }

    public void setBevrozen(boolean bevrozen) {
        this.bevrozen = bevrozen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNaam() + " heeft krediet : ");
        sb.append(getKrediet() + "\n");
        sb.append(ss.voorstellingStapel());
        return sb.toString();
    }

}
