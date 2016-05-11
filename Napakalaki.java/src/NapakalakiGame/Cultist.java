/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author victor
 */
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String nombre, int levels) {
        name = nombre;
        gainedLevels = levels;
    }
    
    public int getGainedLevels () {
        return gainedLevels;
    }
}
