/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import domein.Kaart;
import domein.Speler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author igor
 */
public class KiesKaartScherm extends GridPane{
    private DomeinController dc;
    private ComboBox kaarten;
    private Label uitleg;
    private Button confirm;
    private Speler speler1,speler2,spelerInGebruik;
    private int teller=1;
    private ObservableList<String> options = 
   FXCollections.observableArrayList();

    KiesKaartScherm(KoopKaartScherm aThis, DomeinController dc, Speler speler1, Speler speler2)
    {
        this.speler1 = speler1;
        this.speler2 = speler2;
         spelerInGebruik = speler1;
                this.dc = dc;
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        
        

       
       
 int tel = 0;
        for(Kaart kaart : speler1.getSs().getStapel()){
            options.add(tel,spelerInGebruik.getSs().getStapel().get(tel).voorstellingKaart());   
            tel++;
        }
        
        
        uitleg = new Label(spelerInGebruik.getNaam()+" "+dc.geefTekst("kiesKaart"));
        kaarten = new ComboBox(options);
        confirm = new Button("confirm");
        this.add(kaarten, 1, 1);
        this.add(uitleg,0,1);
        this.add(confirm,2,2);
        
        
                        confirm.setOnAction(this::conf);
                


    

        
        
        
        
        }
          private void conf(ActionEvent event) 
 {
     
     if (kaarten.getValue()!=null){
    dc.voegKaartToeWedstrijdStapel(spelerInGebruik.getSs().getStapel().get(kaarten.getSelectionModel().getSelectedIndex()), spelerInGebruik);
    kaarten.getItems().remove(kaarten.getSelectionModel().getSelectedIndex());
    if (teller <6) { 
    teller++;}
    else if(spelerInGebruik==speler1){
        teller=1;
        spelerInGebruik=speler2;
         int tel = 0;
         options.clear();
        for(Kaart kaart : speler1.getSs().getStapel()){
            options.add(tel,spelerInGebruik.getSs().getStapel().get(tel).voorstellingKaart());   
            tel++;
            uitleg.setText(spelerInGebruik.getNaam()+" "+dc.geefTekst("kiesKaart"));
        }
    }
    else{
                  SpelScherm spelScherm = new SpelScherm(this, dc,speler1,speler2);

           Stage stage = (Stage) (this.getScene().getWindow());
           Scene scene = new Scene(spelScherm, 800, 300);

           stage.setScene(scene);
           stage.show();}
    
     }
     
         
//     dc.voegKaartToeWedstrijdStapel(speler1.getSs().getStapel().get(keuze), speler);
 }
        
        
    }


    

