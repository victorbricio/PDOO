#encoding: utf-8
require_relative 'TreasureKind'
require_relative 'BadConsequence'

module NapakalakiGame

class NumericBadConsequence < BadConsequence

  def initialize (texto, level, nVisible, nHidden)
    super(texto, level)
    @nVisibleTreasures = nVisible
    @nHiddenTreasures = nHidden
  end

  def getNVisibleTreasures
    @nVisibleTreasures
  end

  def getNHiddenTreasures
    @nHiddenTreasures
  end

  def isEmpty
    @nVisibleTreasures == 0 && @nHiddenTreasures == 0
  end

  def substractVisibleTreasure(t)
     if(@nVisibleTreasures != 0)
         @nVisibleTreasures -= 1
     end
  end

  def substractHiddenTreasure(t)
     if(@nHiddenTreasures != 0)
         @nHiddenTreasures -= 1
     end
  end

  def adjustToFitTreasureLists(v ,h)
    nuevosVisibles = 0
    nuevosHidden = 0

    if @nVisibleTreasures < v.size
        nuevosVisibles = @nVisibleTreasures
    else
        nuevosVisibles = v.size
    end

    if @nHiddenTreasures < h.size
        nuevosHidden = @nHiddenTreasures
    else
        nuevosHidden = h.size
    end

    NumericBadConsequence.new(@text, @levels, nuevosVisibles, nuevosHidden)
  end

end

end
