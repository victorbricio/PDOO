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
public class DeathBadConsequence extends NumericBadConsequence {
    
    public DeathBadConsequence(String texto){
        super (texto, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
    }
}
