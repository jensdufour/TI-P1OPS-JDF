/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import domein.Speler;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import sun.security.x509.X500Name;



/**
 *
 * @author timgr
 */
public class NieuwGameScherm extends GridPane {
    private KiesTaalScherm kstScherm;
   private ComboBox cmbTitels;
    private DomeinController dc;

private Label lblFoutMsg,lblSpeler1,lblSpeler2,lblMessage;
private Button btnOk,btnCancel;
private ComboBox cmbSpelers,cmbSpeler1,cmbSpeler2;
    private StartScherm startScherm;

    
    public NieuwGameScherm(StartScherm startScherm, DomeinController dc)

    {
        

        
        
                this.dc = dc;
                this.startScherm=startScherm;
        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(10);
        this.setVgap(10);

        this.setPadding(new Insets(25, 25, 25, 25));
btnOk=new Button("confirm");
btnCancel=new Button("cancel");
lblSpeler1 = new Label(dc.geefTekst("player1"));
lblSpeler2 = new Label(dc.geefTekst("player2"));
this.add(btnOk, 2, 4);
this.add(btnCancel, 3, 4);
this.add(lblSpeler1, 0, 1);
this.add(lblSpeler2, 0, 2);
//this.add(speler1, 3, 3);

//van wie is de code in commentaar?
//this.add(speler1, 3, 3);
//this.add(textf2, 2, 3);
//textf1.setText("");
//textf2.setText("");

ObservableList<String> options = 
   FXCollections.observableArrayList();
 List<String> titels = dc.geefspelers();
options.addAll(titels);
cmbSpeler1 = new ComboBox(options);
cmbSpeler2 = new ComboBox(options);
this.add(cmbSpeler1, 1, 1);
this.add(cmbSpeler2, 1, 2);
        lblMessage =new Label("foute invoer");
        lblMessage.setVisible(false);
          lblFoutMsg =new Label(dc.geefTekst("ErrorMessage"));
        lblFoutMsg.setVisible(false);
        this.add(lblFoutMsg, 0, 6);

      
      btnOk.setOnAction(this::buttonOk);
       btnCancel.setOnAction(this::buttonCancel);
       
    }
    int counter=0;
 private void buttonOk(ActionEvent event) 
 {
            List<Speler> titels = dc.geefspelerss();
           int speler1= cmbSpeler1.getSelectionModel().getSelectedIndex();
           int speler2= cmbSpeler2.getSelectionModel().getSelectedIndex();
        try {
           System.out.printf("%s%n", dc.geefSpeler(speler1)) ;
            System.out.printf("%s%n", dc.geefSpeler(speler2)) ;
        } catch (SQLException ex) {
            Logger.getLogger(NieuwGameScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
           dc.maakWedstrijd(titels.get(speler1),titels.get(speler2));
         
           KoopKaartScherm koopKaartScherm = new KoopKaartScherm(this, dc,titels.get(speler1),titels.get(speler2));

           Stage stage = (Stage) (this.getScene().getWindow());
           Scene scene = new Scene(koopKaartScherm, 800, 300);

           stage.setScene(scene);
           stage.show();
           
        }
 
     private void buttonCancel(ActionEvent event)
        {
            try{
             StartScherm startscherm = new StartScherm(kstScherm, dc);

        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(startscherm, 500, 300);

        stage.setScene(scene);
        stage.show();
        } catch(Exception e)
        {
               lblMessage.setVisible(true);
        }
        }
}

