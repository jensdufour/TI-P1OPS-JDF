/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.sql.SQLException;
import java.util.List;
import persistentie.SpelMapper;

/**
 *
 * @author Senne
 */
public class SpelRepository {
     private SpelMapper mapper;
    
    
    public SpelRepository()
    {
        mapper=new SpelMapper();
    }
    public void slaSpelOp(List<Kaart> kaarten, Speler speler,List<Kaart> kaarten2, Speler speler2, String naam){
        mapper.slaOp(kaarten, speler , kaarten2, speler2 , naam);
    }
    public List<String> geefSpellen() throws SQLException{
         return mapper.geefspellen();
    }
    public List<Speler> getSpel(String idspel) throws SQLException{
        return mapper.getSpel(idspel);
    }
}
