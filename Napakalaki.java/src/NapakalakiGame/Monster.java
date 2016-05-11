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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String nombre, int level, BadConsequence bc, Prize price){
        name = nombre;
        combatLevel = level;
        prize = price;
        badConsequence = bc;
        levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String nombre, int level, BadConsequence bc, Prize price, int ic){
        name = nombre;
        combatLevel = level;
        prize = price;
        badConsequence = bc;
        levelChangeAgainstCultistPlayer = ic;
    }
    
    public String getName(){
        return name;
    }

    public int getCombatLevel(){
        return combatLevel;
    }
    
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTresures();
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
  
// EXAMEN
    public int getCombatLevelAgainstCultistPlayer () {
        return combatLevel + levelChangeAgainstCultistPlayer;
    }
// FIN EXAMEN
    
    @Override
    public String toString(){
        return "Name = " + name + "\nCombatLevel = " + Integer.toString(combatLevel)
                + "\nMonsterPrize:" + prize.toString() 
                + "\nMonsterBadConsequence:" + badConsequence.toString();
    }
    
}