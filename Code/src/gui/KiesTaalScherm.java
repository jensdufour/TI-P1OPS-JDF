/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setHalignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author timgr
 */
public class KiesTaalScherm extends GridPane {
    
    public Label lblVraagTaal,lblMessage;
    public DomeinController dc;

    public KiesTaalScherm()
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);

        this.setPadding(new Insets(25, 25, 25, 25));

        Label lblTitle = new Label("Welcome");
        lblTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(lblTitle, 0, 0, 2, 1);

        Label lblTalenKeuze = new Label("These are the laguages u can choose from:");
        this.add(lblTalenKeuze, 0, 1);
        Button btnEnglish = new Button("English");
        Button btnNederlands = new Button("Nederlands");
        Button btnFrançais = new Button("Français");
        Button btnCancel = new Button("Cancel");
        this.add(btnEnglish, 1, 2);
        this.add(btnNederlands, 1, 3);
        this.add(btnFrançais, 1, 4);
        btnCancel.setOnAction(evt -> Platform.exit());
        setHalignment(btnCancel, HPos.RIGHT);
        this.add(btnCancel, 2, 6);
        Button btnNext = new Button("Confirm");
        this.add(btnNext, 1, 6);
          lblMessage = new Label("Kies een taal");
        this.add(lblMessage, 0, 6);
        lblMessage.setVisible(false);
        this.dc = new DomeinController();
        btnEnglish.setOnAction(this::buttonEnglish);
        btnNederlands.setOnAction(this::buttonNederlands);
        btnFrançais.setOnAction(this::buttonFrancais);
        btnNext.setOnAction(this::buttonPushed);
    }

    private void buttonNederlands(ActionEvent event)
    {
        dc.maakTaal(1);
    }

    private void buttonEnglish(ActionEvent event)
    {
        dc.maakTaal(3);
    }

    private void buttonFrancais(ActionEvent event)
    {
        dc.maakTaal(2);
    }

    private void buttonPushed(ActionEvent event)
    {
        try{
             StartScherm startscherm = new StartScherm(this, dc);

        Stage stage = (Stage) (this.getScene().getWindow());
        Scene scene = new Scene(startscherm, 500, 300);

        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
        {
               lblMessage.setVisible(true);
        }

    }
}
