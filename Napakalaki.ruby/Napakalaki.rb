#encoding: utf-8
require_relative 'Monster'
require_relative 'Player'
require_relative 'Cultist'
require_relative 'CombatResult'
require_relative 'CultistPlayer'
require 'singleton'

module NapakalakiGame

class Napakalaki
  include Singleton

private

  def initialize
    @currentPlayerIndex = -1
    @dealer = CardDealer.instance
    @players = []
    @currentPlayer = nil
    @currentMonster = nil
  end


  def initPlayers(names)
    for nombre in names
         @players << Player.new(nombre)
    end
  end

  def nextPlayer
    if @currentPlayerIndex == -1
          i = rand(@players.size)
          @currentPlayerIndex = i
          @currentPlayer = @players.at(i)
          return @players.at(i)

    else
        if @currentPlayerIndex == @players.size - 1
            @currentPlayerIndex = 0
            @currentPlayer = @players.at(@currentPlayerIndex)
            return @players.at(@currentPlayerIndex)

        else
        @currentPlayerIndex += 1
        @currentPlayer = @players.at(@currentPlayerIndex)
        return @players.at(@currentPlayerIndex)
        end
    end
  end

  def nextTurnAllowed
    if @currentPlayer == nil
        return true
    end

    return @currentPlayer.validState
  end

public

  def GetInstance
    Napakalaki.instance
  end

  def developCombat
    combate = @currentPlayer.combat(@currentMonster)
    @dealer.giveMonsterBack(@currentMonster)
    if combate == CombatResult::LOSEANDCONVERT
          sectario = CultistPlayer.new(@currentPlayer, @dealer.nextCultist)
          @players[@currentPlayerIndex] = sectario
          @currentPlayer = sectario
    end
    combate
  end

  def discardVisibleTreasures(treasures)
    for tesoro in treasures
        @currentPlayer.discardVisibleTreasure(tesoro)
    end
  end

  def discardHiddenTreasures(treasures)
    for tesoro in treasures
      @currentPlayer.discardHiddenTreasure(tesoro)
    end
  end

  def makeTreasuresVisible(treasures)
    for  tesoro in treasures
      @currentPlayer.makeTreasureVisible(tesoro)
    end
  end

  def initGame(pl)
    initPlayers(pl)
    @dealer.initCards()
    nextTurn()
  end

  def getCurrentPlayer
    @currentPlayer
  end

  def getCurrentMonster
    @currentMonster
  end

  def nextTurn
      stateOK = true
      if @currentPlayer != nil
          stateOK = nextTurnAllowed
      end

      if stateOK
        @currentMonster = @dealer.nextMonster
        @currentPlayer = nextPlayer
        dead = @currentPlayer.isDead
        if dead
          @currentPlayer.initTreasures
        end
      end
      stateOK
  end

  def endOfGame(result)
    result == CombatResult::WINGAME
  end
end

end
