require_relative 'BadConsequence'
require_relative 'NumericBadConsequence'
require_relative 'DeathBadConsequence'
require_relative 'SpecificBadConsequence'
require_relative 'Treasure'
require_relative 'CardDealer'
require_relative 'TreasureKind'
require_relative 'Dice'
require_relative 'CombatResult'

module NapakalakiGame

class Player

  @@MAXLEVELS = 10

  def initialize(n)
    @name = n
    @level = 1
    @dead = true
    @hiddenTreasures = []
    @visibleTreasures = []
    @pendingBadConsequence = nil
  end

  def newCultist (p)
    new(p.getName, p.getLevels, p.isDead, hp.getHiddenTreasures, p.getVisibleTreasures, p.getPendingBadConsequence)
  end

protected
  def getOponentLevel (m)
    return m.getCombatLevel
  end

  def shouldConvert
    dice = Dice.instance
    dice.nextNumber() == 6
  end

  def getCombatLevel
        bonus = 0
        for tesoro in @visibleTreasures
            bonus += tesoro.getBonus
        end

        @level + bonus
  end

private
  def bringToLife
        @dead = false
  end

  def incrementLevels(numero)
    if @level + numero > 10
      final = 10
    else
      final = @level + numero
    end
    @level = final
  end

  def decrementLevels(numero)
    if @level < numero
      final = 1
    else
      final = @level - numero
    end
      @level = final
  end

  def setPendingBadConsequence(bc)
         @pendingBadConsequence = bc
  end

  def applyPrize(m)
    nLevels = m.getLevelsGained
      incrementLevels(nLevels)
      nTreasures = m.getTreasuresGained
      if nTreasures > 0
          dealer = CardDealer.instance
          for i in 1..nTreasures
               i = dealer.nextTreasure
               @hiddenTreasures << i
          end
      end
  end

  def applyBadConsequence(m)
      badConsequence = m.getBadConsequence
      nLevels = badConsequence.getLevels
      decrementLevels(nLevels)
      pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
      setPendingBadConsequence(pendingBad)
  end

  def canMakeTreasureVisible(t)
      if t.getType != TreasureKind::ONEHAND
              for tesoro in @visibleTreasures
                  if t.getType == tesoro.getType
                      return false
                  end
              end
      else
          tipos = Array.new
          for tesoro in @visibleTreasures
              tipos << tesoro.getType
          end
          ocurrencias = tipos.count(TreasureKind::ONEHAND)
          if ocurrencias == 2
            return false

          else
              for tipo in tipos
                if tipo == TreasureKind::BOTHHANDS
                    return false
                end
              end
          end
      end
      if t.getType == TreasureKind::BOTHHANDS
          for tesoro in @visibleTreasures
              if tesoro.getType == TreasureKind::ONEHAND
                  return false
              end
          end
      end
          return true
  end

  def howManyVisibleTreasures(tKind)
        total = 0
        for tesoro in @visibleTreasures
            if tesoro.getType == tKind
                total += 1
            end
        end
        total
  end

  def dieIfNoTreasures
        if (@hiddenTreasures.empty? && @visibleTreasures.empty?)
            @dead = true
        end
  end

public
  def getName
    @name
  end

  def isDead
    @dead
  end

  def self.MAXLEVELS
    @@MAXLEVELS
  end

  def getHiddenTreasures
      @hiddenTreasures
  end

  def getVisibleTreasures
      @visibleTreasures
  end

  def combat(m)
    myLevel = getCombatLevel
    monsterLevel = getOponentLevel(m)
      if myLevel > monsterLevel
          applyPrize(m)
          if @level = @@MAXLEVELS
            return CombatResult::WINGAME
          else
              return CombatResult::WIN
          end
      else
          applyBadConsequence(m)
          if shouldConvert
                return CombatResult::LOSEANDCONVERT
          end
          return CombatResult::LOSE
      end
  end

  def makeTreasureVisible(t)
    canI = canMakeTreasureVisible(t)
      if canI
          @visibleTreasures << t
          @hiddenTreasures.delete_at(@hiddenTreasures.find_index(t))
      end
  end

  def discardVisibleTreasure(t)
    @visibleTreasures.delete_at(@visibleTreasures.find_index(t))
    CardDealer.instance.giveTreasureBack(t)
    if (@pendingBadConsequence != nil)
      if (!@pendingBadConsequence.isEmpty)
          @pendingBadConsequence.substractVisibleTreasure(t)
      dieIfNoTreasures()
      end
    end
  end

  def discardHiddenTreasure(t)
    @hiddenTreasures.delete_at(@hiddenTreasures.find_index(t))
    CardDealer.instance.giveTreasureBack(t)
    if (@pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty)
        @pendingBadConsequence.substractHiddenTreasure(t)
    dieIfNoTreasures()
    end

  end

  def validState
    if @pendingBadConsequence == nil
      return @hiddenTreasures.size <= 4
    elsif @pendingBadConsequence.isEmpty
      return @hiddenTreasures.size <= 4
    else
      return false
    end
  end

  def initTreasures
    dealer = CardDealer.instance
    dice = Dice.instance
    bringToLife
    treasure = dealer.nextTreasure
    @hiddenTreasures << treasure
    number = dice.nextNumber
    if number > 1
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
    end
    if number == 6
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
    end
  end

  def getLevels
    @level
  end

  def discardAllTreasures
    visible = Array.new(@visibleTreasures)
    hidden = Array.new(@hiddenTreasures)

    for tesoro in visible
      discardVisibleTreasure(tesoro)
    end

    for tesoro in hidden
      discardHiddenTreasure(tesoro)
    end
  end

  def to_s
    "#{@name}" + "\n" + " level = #{@level}" + "\n" + " combatLevel = #{getCombatLevel}"
  end
end

end
