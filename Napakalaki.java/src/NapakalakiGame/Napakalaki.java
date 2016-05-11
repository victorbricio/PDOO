/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author victor
 */
public class Napakalaki {

    private static Napakalaki instance = null;
    private int currentPlayerIndex;
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;

    private Napakalaki() {
        currentPlayerIndex = -1;
        currentMonster = null;
        currentPlayer = null;
        dealer = CardDealer.getInstance();
        players = new ArrayList();
    }
 
    private void initPlayers(ArrayList<String> names){
        for (String nombre : names) {
           players.add(new Player(nombre));
        }
    }

    private Player nextPlayer(){
        if (currentPlayerIndex == -1){
            Random r = new Random();
            int i = r.nextInt(players.size());
            currentPlayerIndex = i;
            currentPlayer = players.get(i);
            return players.get(i);
        }
        else{
            if (currentPlayerIndex == players.size() - 1){
                currentPlayerIndex = 0;
                currentPlayer = players.get(currentPlayerIndex);
                return players.get(currentPlayerIndex);
            }
            else{
            currentPlayerIndex++;
            currentPlayer = players.get(currentPlayerIndex);
            return players.get(currentPlayerIndex);
            }
        }
    }
    
    private boolean nextTurnAllowed(){
        if (currentPlayer == null)
            return true;
         
        return currentPlayer.validState();
    }
  public static Napakalaki getInstance() {
       if (instance == null)
          instance = new Napakalaki();
       return instance;
  }
  
  public CombatResult developCombat(){
      CombatResult combate = currentPlayer.combat(currentMonster);
      dealer.giveMonsterBack(currentMonster);
      if (combate == CombatResult.LOSEANDCONVERT){
          CultistPlayer sectario = new CultistPlayer (currentPlayer, dealer.nextCultist());
          players.set(currentPlayerIndex, sectario);
          currentPlayer = sectario;
      }
      return combate;
  }

  public void discardVisibleTreasures(ArrayList<Treasure> treasures){
      for (Treasure tesoro : treasures){
          currentPlayer.discardVisibleTreasure(tesoro);
      }
  }

  public void discardHiddenTreasures(ArrayList<Treasure> treasures){
      for (Treasure tesoro : treasures){
          currentPlayer.discardHiddenTreasure(tesoro);
      }
  }

  public void makeTreasuresVisible(ArrayList<Treasure> treasures){
      for (Treasure tesoro : treasures){
          currentPlayer.makeTreasureVisible(tesoro);
      }
  }

  public void initGame(ArrayList<String> players){
      initPlayers(players);
      dealer.initCards();
      nextTurn();
  }

  public Player getCurrentPlayer(){
    return currentPlayer;
}

  public Monster getCurrentMonster(){
    return currentMonster;
}

  public boolean nextTurn(){
      boolean stateOK;
      if (currentPlayer != null)
          stateOK = nextTurnAllowed();
      else
          stateOK = true;
      
      if(stateOK){
        currentMonster = dealer.nextMonster();
        currentPlayer = nextPlayer();
        boolean dead = currentPlayer.isDead();
        if(dead){
            currentPlayer.initTreasures();
        }
    }
      
    return stateOK;
}

  public boolean endOfGame(CombatResult result){
      return result == CombatResult.WINGAME;
  }
}
