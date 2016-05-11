/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class NumericBadConsequence extends BadConsequence{
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence (String texto, int level, int nVisible, int nHidden) {
        super (texto, level);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return nVisibleTreasures == 0 && nHiddenTreasures == 0;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures != 0)
            nVisibleTreasures--;  
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures != 0)
            nHiddenTreasures--;
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
        int nuevosVisibles;
        int nuevosHidden;
        
        if (nVisibleTreasures < v.size())
            nuevosVisibles = nVisibleTreasures;
        else 
            nuevosVisibles = v.size();
    
        if (nHiddenTreasures < h.size())
            nuevosHidden = nHiddenTreasures;
        else 
            nuevosHidden = h.size();
            
        NumericBadConsequence nueva = new NumericBadConsequence(text, levels, nuevosVisibles, nuevosHidden);
            
        return nueva;
    }
    
        @Override
    public String toString(){
        
        return "\n\tText = " + text + "\n\tLevels = " + Integer.toString(levels) 
                + "\n\tVisibleTreasures = " + Integer.toString(nVisibleTreasures) 
                + "\n\tHiddenTreasures = " + Integer.toString(nHiddenTreasures);
    }
}
