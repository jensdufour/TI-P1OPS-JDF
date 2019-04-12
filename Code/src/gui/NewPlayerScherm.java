/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package gui;

import domein.DomeinController;
import java.util.InputMismatchException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setHalignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author timgr
 */
public class NewPlayerScherm extends GridPane{
     private String naam;
         private      int geboorte;
private DomeinController dc;
private KiesTaalScherm kstScherm;
private Label lblMessageIMEXN,lblMessageIEXN,lblMessageENI,lblMessageEXIO,lblMessage,lblPlayermade;
private StartScherm startScherm;
private TextField txfNaam,txfGeboorte;
    public NewPlayerScherm(StartScherm startScherm,DomeinController dc) {
        this.dc = dc;
        this.startScherm=startScherm;
        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(10);
        this.setVgap(10);

        this.setPadding(new Insets(25, 25, 25, 25));
         Label lblUitleg = new Label(dc.geefTekst("maakSpeler"));
this.add(lblUitleg,0,0);
lblUitleg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label lblTitle = new Label(dc.geefTekst("Geefnaam"));
         txfNaam = new TextField();
        lblTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        this.add(lblTitle,0, 1);
        this.add(txfNaam, 1, 1);
         Label lblTitle2 = new Label(dc.geefTekst("GeefGeboorte"));
        txfGeboorte = new TextField();
        lblTitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        this.add(lblTitle2,0, 2);
        this.add(txfGeboorte, 1, 2);
       
        Button btnNext= new Button("confirm");
        this.add(btnNext, 0, 3);
          Button btnCancel= new Button("cancel");
        this.add(btnCancel, 1, 3);
         lblMessageIMEXN = new Label(dc.geefTekst("InputMismatchExceptionNaam"));
         lblMessageIEXN = new Label(dc.geefTekst("IllegalArgumentExceptionNaam"));
         lblMessageENI = new Label(dc.geefTekst("ExceptionNoInt"));
         lblMessageEXIO = new Label(dc.geefTekst("ExceptionIntOutOfRange"));
         lblMessage = new Label(dc.geefTekst("ErrorMessage"));
         lblPlayermade = new Label(dc.geefTekst("playerMade"));
         this.add(lblPlayermade, 0, 6);
        this.add(lblMessage, 0, 7);
        this.add(lblMessageIMEXN, 0, 6);
        this.add(lblMessageIEXN, 0, 6);
        this.add(lblMessageENI, 0, 7);
        this.add(lblMessageEXIO, 0, 7);
        lblPlayermade.setVisible(false);
        lblMessageIMEXN.setVisible(false);
         lblMessageIEXN.setVisible(false);
          lblMessageENI.setVisible(false);
           lblMessageEXIO.setVisible(false);
            lblMessage.setVisible(false);
        
            btnNext.setOnAction(new EventHandler<ActionEvent>()
                    
        {
            @Override
            public void handle(ActionEvent evt)
            {
             
                   lblMessageIMEXN.setVisible(false);
         lblMessageIEXN.setVisible(false);
          lblMessageENI.setVisible(false);
           lblMessageEXIO.setVisible(false);
            lblMessage.setVisible(false);
            lblPlayermade.setVisible(false);
//                try
//                {
//                     
//                     if(dc.geldigeSpelernaam(txfNaam.getText()))
//                         naam = txfNaam.getText();
//                     
//            
//                }
//               catch (InputMismatchException imex) {
//                lblMessageIMEXN.setVisible(true);
//                //System.out.println(dc.geefTekst("InputMismatchExceptionNaam"));
//                
//
//            } catch (IllegalArgumentException iaex) {
//                lblMessageIEXN.setVisible(true);
//               // System.out.println(dc.geefTekst("IllegalArgumentExceptionNaam"));
//                
//            }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//                    lblMessageIMEXN.setVisible(false);
//         lblMessageIEXN.setVisible(false);
//          lblMessageENI.setVisible(false);
//           lblMessageEXIO.setVisible(false);
//            lblMessage.setVisible(false);
                    try
                {
                    
                   String naam = txfNaam.getText();
                    int geboorte = Integer.parseInt(txfGeboorte.getText());
                    dc.maakNieuweSpeler(naam,geboorte);
                    lblPlayermade.setVisible(true);
                    System.out.printf("player gemaakt");
                }
                        catch (InputMismatchException imex) {
                           
                              //  lblMessageIMEXN.setVisible(true);
                            
                
                             lblMessage.setVisible(true);
                //System.out.println(dc.geefTekst("InputMismatchExceptionNaam"));
                

            } catch (IllegalArgumentException iaex) {
               
                   // lblMessageIEXN.setVisible(true);
                
                
                 lblMessage.setVisible(true);
              //  System.out.println(dc.geefTekst("IllegalArgumentExceptionNaam"));
                
            }
           
                catch (Exception e)
                {
                    e.printStackTrace();
                }
             
                
             }
        });
        btnCancel.setOnAction(this::buttonCancel);
       
      


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

