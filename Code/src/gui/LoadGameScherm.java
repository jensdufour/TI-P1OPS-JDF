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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author timgr
 */
public class LoadGameScherm extends GridPane {
    private DomeinController dc;
    private StartScherm stScherm;
private KiesTaalScherm kstScherm;
private Label lblImplemented,lblMessage,lblChooseGame;
private ComboBox cmbGames;

//private Button btnCancel;
     LoadGameScherm(StartScherm startScherm, DomeinController dc) throws SQLException
    {
        
         this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.stScherm=startScherm;
        this.dc=dc;
        lblMessage= new Label("er is iets fout gelopen");
        this.add(lblMessage, 0, 6);
           lblMessage.setVisible(false);
//        lblImplemented = new Label("WIP");
//        this.add(lblImplemented, 0, 1);
       Button btnCancel= new Button("Cancel");
     
        this.add(btnCancel, 0, 5);
        
        
        ObservableList<String> options = 
   FXCollections.observableArrayList();
 List<String> titels = dc.geefSpellen();
options.addAll(titels);
cmbGames = new ComboBox(options);
lblChooseGame = new Label(dc.geefTekst("ChooseAgame"));
this.add(lblChooseGame, 0, 1);
this.add(cmbGames, 1, 1);
Button btnOk = new Button("OK");
this.add(btnOk, 3, 5);
        lblMessage =new Label("foute invoer");
        lblMessage.setVisible(false);
      
btnOk.setOnAction(this::buttonOk);
      btnCancel.setOnAction(this::buttonCancel);
    }
      private void buttonOk(ActionEvent event)
        {
            try{
                List<Speler> spelers= dc.geefSpel(cmbGames.getValue().toString());
            dc.maakWedstrijd(spelers.get(0),spelers.get(1));
        } catch(Exception e)
        {
               lblMessage.setVisible(true);
        }
        }
        private void buttonCancel(ActionEvent event)
        {
            try{
                lblMessage.setVisible(false);
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
