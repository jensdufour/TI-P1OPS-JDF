/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Kaart;
import domein.Speler;
import domein.Wedstrijd;
import domein.WedstrijdStapel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jens Du Four
 */
public class SpelMapper {

    private final KaartMapper km = new KaartMapper();
    private final SpelerMapper sm = new SpelerMapper();
    

    public void slaOp(List<Kaart> kaarten, Speler speler, List<Kaart> kaarten2, Speler speler2, String naam) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_g38.spel (idspel,kaartA1,kaartA2,kaartA3,kaartA4,kaartB1,kaartB2,kaartB3,kaartB4,spelerid1,spelerid2,gewonnenset1, gewonnenset2)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement query2 = conn.prepareStatement("SELECT * FROM ID222177_g38.kaart");

            query.setString(1, naam);
            int count = 2;
            for (Kaart kaart : kaarten) {
                km.voegToe(kaart, speler);
                ResultSet rs = query2.executeQuery();
                    while (rs.next() && count < 6) {
                    if(rs.getInt("spelerid") == speler.getId()){
                    int id = rs.getInt("id");
                    query.setInt(count, id);
                    count++;
                }
                    }
            }
            count = 6;
            for (Kaart kaart : kaarten2) {
                km.voegToe(kaart, speler2);
                ResultSet rs = query2.executeQuery();
                while (rs.next() && count < 10 ) {
                    if(rs.getInt("spelerid") == speler2.getId()){
                    int id = rs.getInt("id");
                    query.setInt(count, id);
                    count++;
                }}
            }
            query.setInt(10, speler.getId());
            query.setInt(11, speler2.getId());
            query.setInt(12, speler.getGewonnenSet());
            query.setInt(13, speler2.getGewonnenSet());
            
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex); 
        }
    }
    public List<Speler> getSpel(String idspel) throws SQLException{
        List<Speler> spelers = new ArrayList();
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.spel");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    if (rs.getString("idspel").equalsIgnoreCase(idspel)) {
                        //speler1
                        Speler speler1 = sm.geefSpeler(rs.getInt("spelerid1"));
                        List<Kaart> wsSpeler1 = new ArrayList();
                        wsSpeler1.add(km.geefkaart(rs.getInt("KaartA1")));
                        wsSpeler1.add(km.geefkaart(rs.getInt("KaartA2")));
                        wsSpeler1.add(km.geefkaart(rs.getInt("KaartA3")));
                        wsSpeler1.add(km.geefkaart(rs.getInt("KaartA4")));
                        WedstrijdStapel ws = new WedstrijdStapel(speler1, wsSpeler1);
                        Speler eersteSpeler = new Speler(speler1.getId(), speler1.getNaam(), speler1.getKrediet(), ws , rs.getInt("gewonnenset1"));
                        spelers.add(eersteSpeler);
                        //speler2
                        Speler speler2 = sm.geefSpeler(rs.getInt("spelerid2"));
                        List<Kaart>wsSpeler2= new ArrayList();
                        wsSpeler2.add(km.geefkaart(rs.getInt("KaartB1")));
                        wsSpeler2.add(km.geefkaart(rs.getInt("KaartB2")));
                        wsSpeler2.add(km.geefkaart(rs.getInt("KaartB3")));
                        wsSpeler2.add(km.geefkaart(rs.getInt("KaartB4")));
                        WedstrijdStapel ws2 = new WedstrijdStapel(speler2,wsSpeler2);
                        Speler tweedeSpeler = new Speler(speler2.getId(), speler2.getNaam(), speler2.getKrediet(), ws2 , rs.getInt("gewonnenset2"));
                        spelers.add(tweedeSpeler);
                    }
                }
            }
    }
   return spelers;
}
    public List<String> geefspellen() throws SQLException{
        List<String> spellen = new ArrayList();
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.spel");
        try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {

                    String naam = rs.getString("idspel");
                    spellen.add(naam);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return spellen;
    }
}
