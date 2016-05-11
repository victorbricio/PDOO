/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Víctor
 */
public abstract class BadConsequence {
    protected String text;
    protected int levels;
    static final int MAXTREASURES = 10;
    
    public BadConsequence(String texto, int level){
        text = texto;
        levels = level;
    }
    
    public String getText(){
        return text;
    }
    
    public int  getLevel(){
        return levels;
    }
    
    public void substractVisibleTreasure(Treasure t){
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        
    }
    
    abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    abstract boolean isEmpty();
}
