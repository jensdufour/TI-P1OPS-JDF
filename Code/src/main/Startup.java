/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package main;

import domein.DomeinController;
import exceptions.IllegalNameException;
import java.sql.SQLException;
import ui.PazaakApp1;

/**
 *
 * @author timgrijp
 */
public class Startup {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws exceptions.IllegalNameException
     */
    // blab
    public static void main(String[] args) throws SQLException, IllegalNameException {
        DomeinController dc = new DomeinController();
        
             new PazaakApp1(dc).start();
        
       
        
    
        }
        
    }
    

