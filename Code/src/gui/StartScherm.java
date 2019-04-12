/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author timgr
 */
public class StartScherm extends GridPane{
    
       private DomeinController dc;

    StartScherm(KiesTaalScherm taalscherm, DomeinController dc)
    {
        this.dc = dc;
        this.setPadding(new Insets(25, 25, 25, 25));
        Label lblStartBoodschap = new Label();
        lblStartBoodschap.setText("Menu       ");
        this.add(lblStartBoodschap, 0, 0);
        Button btnNewGame = new Button(dc.geefTekst("maakNieuweSpeler"));
        this.add(btnNewGame, 1, 0);
        btnNewGame.setOnAction(this::newPlayer);
        Button btnLoadGame = new Button(dc.geefTekst("LaadBestaandeSpel"));
        this.add(btnLoadGame, 1, 1);
        btnLoadGame.setOnAction(this::loadGame);
        Button btnNewPlayer = new Button(dc.geefTekst("maakNieuwSpel"));
        this.add(btnNewPlayer, 1, 2);
        btnNewPlayer.setOnAction(this::newGame);
        Button btnClose = new Button(dc.geefTekst("closeButton"));
        Button btnLanguage = new Button(dc.geefTekst("changeLanguageButton"));
        this.add(btnLanguage, 2, 6);
         btnLanguage.setOnAction(this::changeLanguage);
        btnClose.setOnAction(evt -> Platform.exit());
        this.add(btnClose, 0, 6);
    }
 private void changeLanguage(ActionEvent event)
    {
        KiesTaalScherm nieuwgamescherm = new KiesTaalScherm();

        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(nieuwgamescherm, 500, 300);

        stage.setScene(scene);
        stage.show();
    }
    private void newGame(ActionEvent event)
    {
        NieuwGameScherm nieuwgamescherm = new NieuwGameScherm(this, dc);

        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(nieuwgamescherm, 500, 300);

        stage.setScene(scene);
        stage.show();
    }

    private void loadGame(ActionEvent event)
    {
           try {
               LoadGameScherm loadGameScherm = new LoadGameScherm(this, dc);
               
               Stage stage = (Stage) (this.getScene().getWindow());
               Scene scene = new Scene(loadGameScherm, 500, 300);
               
               stage.setScene(scene);
               stage.show();
           } catch (SQLException ex) {
               Logger.getLogger(StartScherm.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    private void newPlayer(ActionEvent event)
    {
        NewPlayerScherm newPlayerScherm = new NewPlayerScherm(this,dc);

        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(newPlayerScherm, 500, 300);

        stage.setScene(scene);
        stage.show(); 
    }
}
