/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.Scanner;

/**
 *
 * @author Tim.
 */
public class Kaart {
    private int id;
    private char type;
    private int waarde;
    private String saveName;

    public Kaart(char type, int waarde) {
        this.type = type;
        this.waarde = waarde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public String getStringType() {
        String stringType = "" + type;
        return stringType;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public String voorstellingKaart() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(getWaarde());

        return sb.toString();
    }

    public String saveName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Savename:");
        saveName = s.nextLine();
        return saveName;
    }

}
