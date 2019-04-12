/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package main;

import domein.DomeinController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import gui.KiesTaalScherm;
import javafx.application.Platform;
import javafx.scene.Parent;

/**
 *
 * @author tim
 */
public class StartUpGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
    
     		     	         
         KiesTaalScherm kiesTaalScherm = new KiesTaalScherm();
         Scene scene = new Scene(kiesTaalScherm, 500, 300);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Pazaak");
         primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
         {
 
             @Override
             public void handle(WindowEvent event)
             {
                 
                 Platform.exit();
             
             }
         });
         primaryStage.show();
         DomeinController dc = new DomeinController();
     }
 
  


    public static void main(String[] args)
    {
        launch(args);
    }
    
    
}


