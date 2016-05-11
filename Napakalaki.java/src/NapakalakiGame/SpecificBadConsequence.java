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
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    
    public SpecificBadConsequence(String texto, int level, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super (texto, level);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    } 
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        ArrayList<TreasureKind> nuevos = new ArrayList(specificVisibleTreasures);
        for (TreasureKind tipoTesoro : nuevos){
            if (tipoTesoro == t.getType())
                specificVisibleTreasures.remove(tipoTesoro);
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        ArrayList<TreasureKind> nuevos = new ArrayList(specificHiddenTreasures);
        for (TreasureKind tipoTesoro : nuevos){
            if (tipoTesoro == t.getType())
                specificHiddenTreasures.remove(tipoTesoro);
        }
    }
    
    @Override
     public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> tiposVisible = new ArrayList();
        for (Treasure tesoro : v)
            tiposVisible.add(tesoro.getType());
            
        ArrayList<TreasureKind> tiposHidden = new ArrayList();
            for (Treasure tesoro : h)
                tiposHidden.add(tesoro.getType());
                
        ArrayList<TreasureKind> visibleTreasures = new ArrayList();
        ArrayList<TreasureKind> hiddenTreasures = new ArrayList();
            
        for (TreasureKind tipo : specificVisibleTreasures){
                if (tiposVisible.contains(tipo)){
                    tiposVisible.remove(tipo);
                    visibleTreasures.add(tipo);
                }
            
            }
        
        for (TreasureKind tipo : specificHiddenTreasures){
                if (tiposHidden.contains(tipo)){
                    tiposHidden.remove(tipo);
                    hiddenTreasures.add(tipo);
                }
            
            }
            
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            return null;
        
        SpecificBadConsequence nueva = new SpecificBadConsequence(text, levels, visibleTreasures, hiddenTreasures);
            
        return nueva;
    }
     
     @Override
    public String toString(){
        ArrayList<TreasureKind> nulo = new ArrayList();
        if (specificVisibleTreasures == null)
            specificVisibleTreasures = nulo;
        if (specificHiddenTreasures == null)
            specificHiddenTreasures = nulo;
        
        return "\n\tText = " + text + "\n\tLevels = " + Integer.toString(levels) 
                + "\n\tspecificVisibleTreasures = " + specificVisibleTreasures.toString() 
                + "\n\tspecificHiddenTreasures = " + specificHiddenTreasures.toString();
    }
}
