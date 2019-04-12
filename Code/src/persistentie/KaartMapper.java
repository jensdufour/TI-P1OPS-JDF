/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package persistentie;

import domein.Kaart;
import domein.Speler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens Du Four
 */
public class KaartMapper {

    public void voegToe(Kaart kaart, Speler speler) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_g38.kaart (type,waarde,spelerid)"
                    + "VALUES (?, ?, ?)");

            query.setString(1, kaart.getStringType());
            query.setInt(2, kaart.getWaarde());
            query.setInt(3, speler.getId());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Kaart> geefKaarten(int ID) {
        List<Kaart> kaarten = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.kaart");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    if (rs.getInt("id") == ID) {
                        String type = rs.getString("type");
                        int waarde = rs.getInt("waarde");
                        
                        
                        kaarten.add(new Kaart(type.charAt(0), waarde));
                        
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return kaarten;
    }
    public Kaart geefkaart(int ID) throws SQLException {

        Kaart kaart = null;
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.kaart");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    if (rs.getInt("id") == ID) {
                        String type = rs.getString("type");
                        int waarde = rs.getInt("waarde");
                        int id = rs.getInt("id");
                        kaart = new Kaart(type.charAt(0), waarde);
                        kaart.setId(id);
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        return kaart;
    }
    
}
