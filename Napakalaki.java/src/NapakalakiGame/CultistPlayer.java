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
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    @Override
    protected int getCombatLevel () {
        return 3 * super.getCombatLevel() / 2 + myCultistCard.getGainedLevels() * totalCultistPlayers;
    }
    
    @Override
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert() {
        return false;
    }
    
    public static int getTotalCultistPlayers () {
        return totalCultistPlayers;
    }
}
