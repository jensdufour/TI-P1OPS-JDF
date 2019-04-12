/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import domein.Speler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class KoopKaartScherm extends GridPane {
    
private DomeinController dc;
private Label lblkaartJaNee;
private Button btnNee,btnJa;
private Button btnConfirm;
private int i = 1;
private Speler speler1,speler2;
private ComboBox cmbSpelers;
private         ObservableList<String> keuzeGetal =
                FXCollections.observableArrayList("+1","+2","+3","+4","+5","+6","-1","-2","-3","-4","-5","-6"
                ,"±1","±2","±3","±4","±5","±6","T","*2","2&3","3&6","1+/-2");
private char waarde;




    public KoopKaartScherm(NieuwGameScherm nieuwGameScherm, DomeinController dc, Speler speler1, Speler speler2)
    {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.dc = dc;
                this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);

        this.setPadding(new Insets(25, 25, 25, 25));
        
        


                
        
        spelertoevoegen();


        
        
                
                
          
        
    }


private void spelertoevoegen()
{
    
            lblkaartJaNee=new Label(String.format("wenst speler %d een kaart te kopen",i));
        btnJa=new Button("ja ");
        btnNee = new Button("nee");
        
        this.add(btnJa, 0, 4);
        this.add(btnNee, 3, 4);
        this.add(lblkaartJaNee, 0, 0);
    
    
                btnJa.setOnAction(this::buttonJa);
                btnNee.setOnAction(this::buttonNee);
}

    
  private void buttonNee(ActionEvent event) 
 {
     if (i == 1){
         i ++;
         spelertoevoegen();
                 }
     
     else 
         openscherm();
 }
 
  private void buttonJa(ActionEvent event) 
 {
        
        btnJa.setVisible(false);
        btnNee.setVisible(false);
lblkaartJaNee.setText(dc.geefTekst("kiesKaart"));
btnConfirm = new Button("confirm");
        cmbSpelers = new ComboBox(keuzeGetal);
        this.add(cmbSpelers, 1, 1);
        this.add(btnConfirm, 1, 2);
         
 
  
        
        
  
cmbSpelers.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                     char type;
                     int waarde;
                     
                
                
           //int index = cmbTitels.getSelectionModel().getSelectedIndex();     

           if (cmbSpelers.getSelectionModel().getSelectedIndex()<18)
           {
               
               type = cmbSpelers.getValue().toString().charAt(0);
               waarde = cmbSpelers.getValue().toString().charAt(0);
                
                }
           
          // "±6","T","*2","2&3","3&6","1+/-2");
           
           
                if (cmbSpelers.getSelectionModel().getSelectedIndex()==18){
                    lblkaartJaNee.setText(String.format("%s%n%s%n%s%n%s",dc.geefTekst("omschrijving4"),dc.geefTekst("prijs"),"20"));
 
                type = 't';
                waarde = 0;
                
                }
                else if (cmbSpelers.getSelectionModel().getSelectedIndex()==19){
                    lblkaartJaNee.setText(String.format("%s%n%s%n%s%n%s",dc.geefTekst("omschrijving4"),dc.geefTekst("prijs"),"30"));
                    type = '*';
                    waarde = 2;   
                    
                }
                else if (cmbSpelers.getSelectionModel().getSelectedIndex()==20||cmbSpelers.getSelectionModel().getSelectedIndex()==21)
                {
                   lblkaartJaNee.setText(String.format("%s%n%s%n%s%n%s",dc.geefTekst("omschrijving4"),dc.geefTekst("prijs"),"50"));
                    type = '&';
                    waarde = cmbSpelers.getValue().toString().charAt(0);

                
                }
                else if (cmbSpelers.getSelectionModel().getSelectedIndex()==22){
                   lblkaartJaNee.setText(String.format("%s%n%s%n%s%n%s",dc.geefTekst("omschrijving4"),dc.geefTekst("prijs"),"100"));
                type = '/';
                waarde=1;

                }
            }
            
            

        });

btnConfirm.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                if (i==1){
                    speler1.getSs().voegKaartToe('-',waarde);
                    try {
                        dc.verlaagKrediet(5, speler1);
                    } catch (SQLException ex) {
                        Logger.getLogger(KoopKaartScherm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                    speler2.getSs().voegKaartToe('-',waarde);
     
                cmbSpelers.setVisible(true);
              
            }
            
            

        });





        
        }



        
         
        
  
  
  

    private void openscherm() 
    {
                
            KiesKaartScherm spelScherm = new KiesKaartScherm(this, dc,speler1,speler2);

           Stage stage = (Stage) (this.getScene().getWindow());
           Scene scene = new Scene(spelScherm, 500, 500);

           stage.setScene(scene);
           stage.show();
        }
    }

//  omschrijving1 = OMSCHRIJVING: Telt x op bij de huidige score en bevriest het spelbord.\n
//omschrijving2 = OMSCHRIJVING: Verdubbelt de waarde van de laatste kaart getrokken.\n
//omschrijving3 = OMSCHRIJVING: Wisselt in de huidige set het teken van alle kaarten met waarde x en y voor deze speler. \n
//omschrijving4 = OMSCHRIJVING: Combinatie van +x, -x, +y, -y kaart waarbij speler een van deze kiest.\n