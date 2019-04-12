/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;
import persistentie.KaartMapper;

/**
 *
 * @author Senne.
 */
public class KaartRepository {
    private KaartMapper mapper;

    public KaartRepository() {
        this.mapper = new KaartMapper();
    }
     public void voegToe(Kaart kaart , Speler speler)
    {
        mapper.voegToe(kaart,speler);
    }
     public List<Kaart> geefkaartenSpeler(int id){
        return mapper.geefKaarten(id);
     }
    
}
