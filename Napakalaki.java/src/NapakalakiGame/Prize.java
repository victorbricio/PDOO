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
public class Prize {
    private int treasures;
    private int level;
    
    public Prize(){
        treasures = 0;
        level = 0;
    }
    
    public Prize(int trsures, int lvl){
        treasures = trsures;
        level = lvl;
    }
    
    public int getTresures(){
        return treasures;
    }
    
    public int getLevel(){
        return level;
    }
    
    @Override
    public String toString(){
        return "\n\tTreasures = " + Integer.toString(treasures) + "\n\tLevels = " + Integer.toString(level);
        }
}
