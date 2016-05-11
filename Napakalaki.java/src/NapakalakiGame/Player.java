/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author victor
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name; 
    private int level;
    private boolean dead;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player (String nombre){
        name = nombre;
        level = 1;
        dead = true;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        pendingBadConsequence = null;
    }
    
    public Player (Player p){
        name = p.getName();
        level = p.getLevels();
        dead = p.isDead();
        hiddenTreasures = p.getHiddenTreasures();
        visibleTreasures = p.getVisibleTreasures();
        pendingBadConsequence = p.getPendingBadConsequence();
    }
    
    protected int getOponentLevel (Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        return dice.nextNumber() == 6;
    }
    
    public String getName(){
        return name;
    }
    
    public BadConsequence getPendingBadConsequence () {
        return pendingBadConsequence;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){
        int bonus = 0;
        for (Treasure tesoro : visibleTreasures){
            bonus += tesoro.getBonus();
        }
            
        return level + bonus;
    }
    
    private void incrementLevels(int numero){
        if (level + numero >= 10){
            level = 10;
        }
        else
            level += numero;
    }
    
    private void decrementLevels(int numero){
        if (level - numero <= 1){
            level = 1;
        }
        else
            level -= numero;
    }
    
    private void setPendingBadConsequence(BadConsequence bc){
         pendingBadConsequence = bc;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if (nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            for (int i = 1; i <= nTreasures; i++){
                 Treasure treasure = dealer.nextTreasure();
                 hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevel();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
            if (t.getType() != TreasureKind.ONEHAND){
                for (Treasure tesoro : visibleTreasures){
                    if (t.getType() == tesoro.getType())
                        return false;
                }
            }
            else{
                ArrayList<TreasureKind> tipos = new ArrayList();
                for (Treasure tesoro : visibleTreasures)
                    tipos.add(tesoro.getType());
                int ocurrencias = Collections.frequency(tipos, TreasureKind.ONEHAND);
                if (ocurrencias == 2)
                    return false;
                else{
                    for (TreasureKind tipo: tipos)
                        if (TreasureKind.BOTHHANDS == tipo)
                            return false;
                }
            }
            if (t.getType() == TreasureKind.BOTHHANDS){
                for (Treasure tesoro : visibleTreasures){
                    if (tesoro.getType() == TreasureKind.ONEHAND)
                        return false;
                }
            }
            return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int total = 0;
        for (Treasure tesoro : visibleTreasures)
            if (tesoro.getType() == tKind)
                total++;
        return total;
    }

    private void dieIfNoTreasures(){
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }

    public CombatResult combat(Monster m){
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        if (myLevel > monsterLevel){
            applyPrize(m);
            if (level >= MAXLEVEL)
                return CombatResult.WINGAME;
            else
                return CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
            
            if (shouldConvert()){
                return CombatResult.LOSEANDCONVERT;
            }
            return CombatResult.LOSE;
        }
    }

    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if (canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
      //      setPendingBadConsequence(pendingBadConsequence.adjustToFitTreasureLists(hiddenTreasures, hiddenTreasures)); 
        }
        dieIfNoTreasures();
    }

    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
   //         setPendingBadConsequence(pendingBadConsequence.adjustToFitTreasureLists(hiddenTreasures, hiddenTreasures));
        }
        dieIfNoTreasures();
    }

    public boolean validState(){
        return (pendingBadConsequence == null || pendingBadConsequence.isEmpty())
                && hiddenTreasures.size() <= 4;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }  
    }

    public int getLevels(){
        return level;
    }

    public void discardAllTreasures(){
        ArrayList<Treasure> visible = new ArrayList(visibleTreasures);
        ArrayList<Treasure> hidden = new ArrayList(hiddenTreasures);

    for (Treasure tesoro : visible)
        discardVisibleTreasure(tesoro);

    for (Treasure tesoro : hidden)
        discardHiddenTreasure(tesoro);
    }
    
    @Override
    public String toString(){
        
        return name + "\n level = " + level + "\n combatLevel = " + getCombatLevel();
    }
    
}
