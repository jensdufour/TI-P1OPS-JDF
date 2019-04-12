/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package persistentie;

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

public class SpelerMapper {

    public void voegToe(Speler speler) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO ID222177_g38.speler (naam,geboortedatum,krediet)"
                    + "VALUES (?, ?, ?)");

            query.setString(1, speler.getNaam());
            query.setInt(2, speler.getGeboortejaar());
            query.setInt(3, speler.getKrediet());

            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Speler> geefSpelers() {
        List<Speler> spelers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.speler");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {

                    String naam = rs.getString("naam");
                    int geboortedatum = rs.getInt("geboortedatum");

                    spelers.add(new Speler(naam, geboortedatum));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spelers;
    }

    public void verlaagkrediet(Speler speler) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.speler");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    if (rs.getInt("id") == speler.getId()) {
                        int id = rs.getInt("id");
                        String query2 = "UPDATE `ID222177_g38`.`speler` SET `krediet`=? WHERE `id`=?;";
                        PreparedStatement preparedStmt = conn.prepareStatement(query2);
                        preparedStmt.setInt(1, speler.getKrediet());
                        preparedStmt.setInt(2, id);
                        preparedStmt.executeUpdate();
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    public Speler geefSpeler(int ID) throws SQLException {

        Speler speler = null;
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g38.speler");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    if (rs.getInt("id") == ID) {
                        String name = rs.getString("naam");
                        int geboortedatum = rs.getInt("geboortedatum");
                        int krediet = rs.getInt("krediet");
                        int id = rs.getInt("id");
                        speler = new Speler(name, geboortedatum);
                        speler.setKrediet(krediet);
                        speler.setId(id);
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        return speler;
    }
}
