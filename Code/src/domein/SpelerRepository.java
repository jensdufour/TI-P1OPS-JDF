/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistentie.SpelerMapper;

/**
 *.
 * @author timgr
 */
public class SpelerRepository {
    private SpelerMapper mapper;
    
    
    public SpelerRepository()
    {
        mapper=new SpelerMapper();
    }
    
    
    public void voegToe(Speler speler)
    {
        mapper.voegToe(speler);
    }
    
    public List<Speler> toonSpelers()
    {
        return mapper.geefSpelers();
    }
    public void verlaagKrediet(Speler speler) throws SQLException{
        mapper.verlaagkrediet(speler);
    }

    public List<String> geefNamenSpelers() {
        List<String> spelers = new ArrayList();
        for(Speler speler : mapper.geefSpelers()){
            spelers.add(speler.getNaam());
        }
        return spelers;
    }
    public Speler geefSpeler(int ID) throws SQLException{
       return mapper.geefSpeler(ID);
    }

    List<Speler> geefNamenSpelersA() 
    {
                List<Speler> spelers = new ArrayList();
        for(Speler speler : mapper.geefSpelers()){
            spelers.add(speler);
        }
        return spelers;
    }
}
