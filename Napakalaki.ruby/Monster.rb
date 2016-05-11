#encoding: utf-8
require_relative 'Prize'
require_relative 'BadConsequence'

module NapakalakiGame

class Monster

  def initialize(nombre, nivel, premio, bc, l)
    @name = nombre
    @combatlevel = nivel
    @prize = premio
    @badconsequence = bc
    @levelChangeAgaistCultistPlayer = l
  end

  def getName
    @name
  end

  def getCombatLevel
    @combatlevel
  end

  def getLevelsGained
    @prize.getLevels
  end

  def getTreasuresGained
    @prize.getTreasures
  end

  def getBadConsequence
    @badconsequence
  end

  def getCombatLevelAgainstCultistPlayer
      @combatLevel + levelChangeAgainstCultistPlayer
  end

  def to_s
    "Nombre: #{@name} \nNivel de combate: #{@combatlevel} \nPremio: \n#{@prize.to_s}
Mal rollo: \n#{@badconsequence.to_s}\n\n"
  end

end

end
