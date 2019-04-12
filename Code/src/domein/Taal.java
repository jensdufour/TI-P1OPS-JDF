/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor....
 */
package domein;

import java.util.Locale;
import java.util.ResourceBundle;
//ble bla
/**
 *.
 * @author timgr
 */
public class Taal {
    
   private ResourceBundle resourcebundle;
   
   
   public Taal(int taalkeuze)
   {
       
         String lang;
        controleerTaalKeuze(taalkeuze);
        if (taalkeuze == 1) {
            lang = "nl";
           

        } else if (taalkeuze == 2) {
            lang = "fr";
           

        } else {
            lang = "en";
            
        }
        Locale l = new Locale(lang);
        resourcebundle = ResourceBundle.getBundle("resources.Bundle", l);
        this.resourcebundle = resourcebundle;
   }
   
   private static void controleerTaalKeuze(int taalkeuze)        
   {
       if(taalkeuze<=0||taalkeuze>3)
           throw new IllegalArgumentException("De taalkeuze moet 1,2 of 3 zijn");
   }
   
      public ResourceBundle getResourceBundle()
    {
        return resourcebundle;
    }
      
       public String geefTekst(String sleutel)
    {
        return resourcebundle.getString(sleutel);
    }
}
