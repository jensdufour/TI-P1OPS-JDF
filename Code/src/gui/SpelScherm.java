/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import domein.Set;
import domein.Speler;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;





public class SpelScherm extends GridPane {
    
    
    
    private Speler speler1,spelerInGebruik,speler2;
    private DomeinController dc;
    private Label lblUitleg,lblScoreSp1,lblScoreSp2,lblSpelerInGebruik;
    private Button btnKaart1,btnKaart2,btnKaart3,btnKaart4
                           ,btnBevries,btnSpeelKaart,btnEindeBeurt,btnverder,
            btnPlus,btnMin,btnQuit; 
    private boolean krt1Sp1=true,krt2Sp1=true,krt3Sp1=true,krt4Sp1=true,
                    krt1Sp2=true,krt2Sp2=true,krt3Sp2=true,krt4Sp2=true;
    String getal;
    String[] sss;
    boolean bevrozensp1=false,bevrozensp2= false; 
    Set sets;
    private boolean IetsBevroren=false ,isWinnaar = false;
    

SpelScherm(KiesKaartScherm aThis, DomeinController dc, Speler speler1, Speler speler2) 
    {
        this.dc = dc;
        this.speler1 = speler1;
        this.speler2 = speler2;
         spelerInGebruik = dc.bepaalbeurt();
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        dc.geefStapelSpeler(speler1);
        dc.geefStapelSpeler(speler2);
        dc.maakSet();
        List spelers = new ArrayList();
        spelers.add(speler1);
        spelers.add(speler2);
        
        
        btnverder = new Button();
        //speelbeurt
        btnBevries = new Button();
        btnSpeelKaart = new Button();
        btnEindeBeurt= new Button();
        
        btnQuit=new Button();
        
        lblSpelerInGebruik = new Label();
        lblScoreSp1 = new Label();
        
        //random uitleg
        lblUitleg = new Label();
        
        //* kaarten
        btnMin=new Button();
        btnPlus = new Button();
        
        //maak keuze
        btnKaart1= new Button();
        btnKaart2= new Button();
        btnKaart3= new Button();
        btnKaart4= new Button();
        btnPlus.setVisible(false);
        btnMin.setVisible(false);
        this.add(btnMin, 8, 8);
        this.add(btnPlus, 8, 9);
        this.add(btnQuit, 5, 6);
        this.add(btnverder,5,5);
        this.add(lblUitleg, 0, 1);
        this.add(lblSpelerInGebruik, 1, 1);
        this.add(lblScoreSp1, 1, 0);
        this.add(btnBevries, 2, 1);
        this.add(btnSpeelKaart, 3, 1);
        this.add(btnEindeBeurt, 4, 1);
        
        this.add(btnKaart1, 2, 1);
        this.add(btnKaart2, 3, 1);
        this.add(btnKaart3, 4, 1);
        this.add(btnKaart4, 5, 1);
        
        
        
        lblUitleg.setVisible(true);
        lblSpelerInGebruik.setVisible(true);
        lblScoreSp1.setVisible(true);
        btnBevries.setVisible(false);
        btnSpeelKaart.setVisible(false);
        btnEindeBeurt.setVisible(false);
        
        btnverder.setVisible(false);
        btnKaart1.setVisible(false);
        btnKaart2.setVisible(false);
        btnKaart3.setVisible(false);
        btnKaart4.setVisible(false);
        
        btnQuit.setVisible(false);
        

    
     
speelSet();
        
    }

    private void speelSet() 
    {
        if (isWinnaar==true){
            if(speler1.getGewonnenSet()>2||speler2.getGewonnenSet()>2)
                lblUitleg.setText(dc.geefWinnaar());
            isWinnaar=false;
            
            
            if (speler1.getGewonnenSet()>2)
            {
             speler1.verhoogKrediet(5);
             
             
             eindeSpel();
             
            }
            else if (speler1.getGewonnenSet()>2){
                speler2.verhoogKrediet(5);
           
            
            eindeSpel();
            }
            else{
                bevrozensp1=false;
            bevrozensp2= false;
                isWinnaar=false;
            dc.maakSet();
            reset();
            dc.bepaalbeurt();
            maakkeuze();}
            
            
                }
        else{
            isWinnaar=false;
        dc.maakSet();
        dc.bepaalbeurt();
        maakkeuze();
    }}


   private void maakkeuze() 
    {
        if(btnKaart1.isVisible()==true)
        {
            btnKaart1.setVisible(false);
        btnKaart2.setVisible(false);
        btnKaart3.setVisible(false);
        btnKaart4.setVisible(false);
        }
        
        System.out.println(speler1.getGewonnenSet());
        System.out.println(speler2.getGewonnenSet());
        dc.getSet().beurt(spelerInGebruik);
        
        btnBevries.setVisible(true);
        btnSpeelKaart.setVisible(true);
        btnEindeBeurt.setVisible(true);
        System.out.println(bevrozensp2);
        System.out.println(bevrozensp1);
        
        
        lblSpelerInGebruik.setText("");
        lblScoreSp1.setText("");
        lblSpelerInGebruik.setText(dc.geefTekst("tussenStand")+": "+speler1.getSetScore()+speler1.getNaam());
        
        lblScoreSp1.setText(dc.geefTekst("tussenStand")+": "+speler2.getSetScore()+speler2.getNaam());
        
        
        lblUitleg.setText("");
        lblUitleg.setText(dc.geefTekst("keuzeWedstrijdGui")+" "+spelerInGebruik.getNaam());
        btnBevries.setText(dc.geefTekst("keuzeBevries"));
        btnSpeelKaart.setText(dc.geefTekst("keuzeWedstrspeel"));
        btnEindeBeurt.setText(dc.geefTekst("keuzeBeindig"));
        
        

        
        
        btnBevries.setOnAction(this::btnonbevries);
        btnEindeBeurt.setOnAction(this::btnOnEindeBeurt);
        btnSpeelKaart.setOnAction(this::btnOnSpeelKrt);
        


    }
   


        private void btnonbevries(ActionEvent event)
    {
        bevries();
    }
        
        
            private void bevries() {
                IetsBevroren=true;
                if (spelerInGebruik==speler1)
                    bevrozensp1 = true;
                else
                    bevrozensp2 = true;
        veranderBeurt();
        
    }
        
        
        
                private void btnOnSpeelKrt(ActionEvent event)
    {
        speelKaart();
    }
                
                
                

    private void speelKaart() 
    {
        if(btnPlus.isVisible())
        {
            btnMin.setVisible(false);
            btnMin.setVisible(false);
        }
        if (spelerInGebruik==speler1){
        btnKaart1.setVisible(krt1Sp1);
        btnKaart2.setVisible(krt2Sp1);
        btnKaart3.setVisible(krt3Sp1);
        btnKaart4.setVisible(krt4Sp1);}
        
        if (spelerInGebruik==speler2){
        btnKaart1.setVisible(krt1Sp2);
        btnKaart2.setVisible(krt2Sp2);
        btnKaart3.setVisible(krt3Sp2);
        btnKaart4.setVisible(krt4Sp2);}
 
        
        btnBevries.setVisible(false);
        btnEindeBeurt.setVisible(false);
        btnSpeelKaart.setVisible(false);
        
        sss = spelerInGebruik.toonWedstrijdStapel().split("  ");
        sss[1]=sss[1].substring(0, 2);
        sss[2]=sss[2].substring(0, 2);
        sss[3]=sss[3].substring(0, 2);
        sss[4]=sss[4].substring(0, 2);
        
        btnKaart1.setText(sss[1]+("   "));
        btnKaart2.setText(sss[2]+"   ");
        btnKaart3.setText(sss[3]+"   ");
        btnKaart4.setText(sss[4]+"   ");
        
        
//        this.add(btnKaart1, 2, 1);
//        this.add(btnKaart2, 3, 4);
//        this.add(btnKaart3, 4, 1);
//        this.add(btnKaart4, 5, 1);

        btnKaart1.setOnAction(this::btnKaart1On);
        btnKaart2.setOnAction(this::btnKaart2On);
        btnKaart3.setOnAction(this::btnKaart3On);
        btnKaart4.setOnAction(this::btnKaart4On);
        
        

    }
    
    
    
    
    
    
            private void btnKaart1On(ActionEvent event)
    {
        if (spelerInGebruik==speler1)
        krt1Sp1=false;
        else
            krt1Sp2=false;
        
        bereken(btnKaart1.getText());
        
        
        
    }
            private void btnKaart2On(ActionEvent event)
    {
                if (spelerInGebruik==speler1)
        krt2Sp1=false;
        else
            krt2Sp2=false;
          bereken(btnKaart2.getText());
        
    }
            private void btnKaart3On(ActionEvent event)
    {
                if (spelerInGebruik==speler1)
        krt3Sp1=false;
        else
            krt3Sp2=false;
        bereken(btnKaart3.getText());
    }
            private void btnKaart4On(ActionEvent event)
    {
                if (spelerInGebruik==speler1)
        krt4Sp1=false;
        else
            krt4Sp2=false;
        bereken(btnKaart4.getText());
    }
                    private void bereken(String text) 
    {
        switch(text.charAt(0)){
            case '-' :{
                
                spelerInGebruik.verlaagsetScore(text.charAt(1)-'0');
            veranderBeurt();
            
            
            }            
            case '+' :{ spelerInGebruik.verhoogsetScore(text.charAt(1)-'0');
            veranderBeurt();
            
            }
            
            case '*' : {
                btnPlus.setVisible(true);
                btnMin.setVisible(true);
                btnPlus.setText("+");
                btnMin.setText("-");
                btnMin.setVisible(true);
                btnMin.setVisible(true);
                btnMin.setOnAction(this::btnOnMin);
                btnPlus.setOnAction(this::btnOnPlus);
                getal = String.format("%c",text.charAt(1));
            }
            
            
        }
    }
                
                  private void btnOnMin(ActionEvent event)
    {

        getal= String.format("-"+getal);
        bereken(getal);
    }
        
        
                private void btnOnPlus(ActionEvent event)
    {

        getal= String.format("+"+getal);
        bereken(getal);
        
    }      
                
                
                
                
                private void btnOnEindeBeurt(ActionEvent event)
    {
        EindeBeurt();
    }
                    private void EindeBeurt() 
    {
        
        veranderBeurt();
        
    }

                



    private void veranderBeurt() 
    {
        System.out.println("bevries");
        if (bevrozensp1==true&&bevrozensp2==true)
            geefwinaar();
       else if (IetsBevroren=true)
        
            if ( bevrozensp1 == true){
                spelerInGebruik = speler2;
            maakkeuze();}
            else if (bevrozensp2 == true) {
                spelerInGebruik = speler1;
            maakkeuze();}
        
        else  if (spelerInGebruik==speler1){
            spelerInGebruik=speler2;
            maakkeuze();
        }
        else{
            spelerInGebruik=speler1;
            maakkeuze();}
    }

    private void geefwinaar() 
    {
        
        dc.getSet().hoogsteScoreGUI();
        lblUitleg.setText(dc.getSet().getWinnaar().getNaam());
        dc.getSet().getWinnaar().verhoogGewonnenSet();
        isWinnaar = true;
        btnverder.setText("verder");
        btnverder.setVisible(true);
        btnverder.setOnAction(this::btnverderOn);
        
        
    }
    
                      private void btnverderOn(ActionEvent event)
    {
        btnverder.setVisible(false);
        System.out.println("sdf");
        speelSet();
    }

    private void reset() 
    {
        speler1.setSetScore(0);
        speler2.setSetScore(0);
    }

    private void eindeSpel() 
    {
        lblScoreSp1.setVisible(false);
       
        lblSpelerInGebruik.setVisible(false);
        lblUitleg.setVisible(false);
        btnBevries.setVisible(false);
        btnEindeBeurt.setVisible(false);
        btnKaart1.setVisible(false);
        btnKaart2.setVisible(false);
        btnKaart3.setVisible(false);
        btnKaart4.setVisible(false);
        btnMin.setVisible(false);
        btnPlus.setVisible(false);
        btnSpeelKaart.setVisible(false);
        btnverder.setVisible(false);
        
        btnQuit.setText("quit");
        btnQuit.setVisible(true);
        
         btnQuit.setOnAction(this::btnQuitOn);
        

        
        
    }
    
    
    private void btnQuitOn(ActionEvent event)
    {
        KiesTaalScherm KiesTaalScherm = new KiesTaalScherm();
        dc.maakTaal(1);
        StartScherm startscherm = new StartScherm(KiesTaalScherm, dc);

        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(startscherm, 500, 300);

        stage.setScene(scene);
        stage.show();
    }
}