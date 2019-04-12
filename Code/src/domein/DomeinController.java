/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.l
 */
package domein;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;


/**
 *
 * @author Senne..
 */
public class DomeinController {
 private Speler speler;
 private Taal taal;
 private final SpelerRepository spelerRepository = new SpelerRepository();
 private final KaartRepository kaartRepository = new KaartRepository();
 private final SpelRepository spelrepository = new SpelRepository();
 private Wedstrijd wedstrijd;
  
    public void maakNieuweSpeler(String naam , int geboorteJaar){
        speler = new Speler(naam,geboorteJaar);
        spelerRepository.voegToe(speler);
    }
    public boolean geldigeSpelernaam(String naam){
        try{
        new Speler(naam, 2000);
        
        return true;
        }catch (InputMismatchException imex) {
                System.out.println(geefTekst("InputMismatchExceptionNaam"));
            return false;

        } catch (IllegalArgumentException iaex) {
                System.out.println(geefTekst("IllegalArgumentExceptionNaam"));
                return false;
        }
        
    }
    public boolean geldigGeboorteJaar(int geboorteJaar){
        try{
            new Speler("jan",geboorteJaar);
            return true;
        }
//        catch (InputMismatchException imex) {
//                System.out.println(geefTekst("ExceptionNoInt"));
//                return false;
//                
//
//            }
        catch (IllegalArgumentException iaex) {
                System.out.println(geefTekst("ExceptionIntOutOfRange"));
                return false;
                
           }
    }
    public String voorstellingSpeler(){
      return speler.toString();
    }
    // Taalmethodes
    public void maakTaal(int taalkeuze)
    {
        taal = new Taal(taalkeuze);
    }
    public String geefTekst(String sleutel)
    {
        return taal.geefTekst(sleutel);
    }
    //einde taal methodes
    
   //begin spelerRepository methodes
    public void verlaagKrediet(int krediet, Speler speler) throws SQLException{
        speler.verlaagKrediet(krediet);
        spelerRepository.verlaagKrediet(speler);
    }
    public List<String> geefspelers()
   {
        return spelerRepository.geefNamenSpelers();
   }
            public List<Speler> geefspelerss()
   {
        return spelerRepository.geefNamenSpelersA();
   }
   public void slaSpelOp(List<Kaart> kaarten ,Speler speler, List<Kaart> kaarten2, Speler speler2 , String naam){
        spelrepository.slaSpelOp(kaarten, speler, kaarten2 , speler2, naam);
    }
    
    
    
    public Speler geefSpeler(int ID) throws SQLException{
        return spelerRepository.geefSpeler(ID);
    }
    public void maakWedstrijd(Speler speler1, Speler speler2){
        wedstrijd = new Wedstrijd(speler1, speler2);
    }
    public List<Speler> geefSpelersWedstrijd(){
       return wedstrijd.getSpelers();
    }
    public void voegKaartToeWedstrijdStapel(Kaart kaart, Speler speler){
        wedstrijd.voegKaartToe(kaart, speler);
    }
    public String geefStapelSpeler(Speler speler){
        return wedstrijd.geefStapelSpeler(speler);
    }
    public String geefWinnaar(){
        return wedstrijd.returnWinnaarnaam();
    }

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }
    public Speler bepaalbeurt(){
        return wedstrijd.bepaalBeurt();
    }    
    public Set getSet(){
       return wedstrijd.getSet();
    }
    public void maakSet(){
        
        wedstrijd.maakSet();
    }
    public void voegKaartToe(Kaart kaart , Speler speler){
       this.kaartRepository.voegToe(kaart, speler);
    }
    public void voegGekochteKaartenSpelerToe(Speler speler){
      List<Kaart> kaarten = this.kaartRepository.geefkaartenSpeler(speler.getId());
      for(Kaart kaart: kaarten){
          speler.getSs().voegKaartToe(kaart);
      }
    }
    
    public List<String> geefSpellen() throws SQLException{
        return this.spelrepository.geefSpellen();
    }
    public List<Speler>  geefSpel(String idspel) throws SQLException{
        return this.spelrepository.getSpel(idspel);
    }
    
}
