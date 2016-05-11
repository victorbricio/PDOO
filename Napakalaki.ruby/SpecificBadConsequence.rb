#encoding: utf-8
require_relative 'TreasureKind'
require_relative 'BadConsequence'

module NapakalakiGame

class SpecificBadConsequence < BadConsequence

  def initialize (texto, level, sVisible, sHidden)
    super(texto, level)
    @specificVisibleTreasures = sVisible
    @specificHiddenTreasures = sHidden
  end

  def getSpecificVisibleTreasures
    @specificVisibleTreasures
  end

  def getSpecificHiddenTreasures
    @specificHiddenTreasures
  end

  def isEmpty
    @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?
  end

  def substractVisibleTreasure(t)
     for tipoTesoro in @specificVisibleTreasures
         if tipoTesoro == t.getType
             @specificVisibleTreasures.delete_at(@specificVisibleTreasures.find_index(tipoTesoro))
         end
     end
  end

  def substractHiddenTreasure(t)
     for tipoTesoro in @specificHiddenTreasures
         if tipoTesoro == t.getType
             @specificHiddenTreasures.delete_at(@specificHiddenTreasures.find_index(tipoTesoro))
         end
     end
  end

  def adjustToFitTreasureLists(v ,h)
      visibleTreasures = []
      hiddenTreasures = []

      if @specificVisibleTreasures != 0
        tiposVisible = []
        for tesoro in v
            tiposVisible << tesoro.getType
        end

        for tipo in @specificVisibleTreasures
          if tiposVisible.count(tipo) > visibleTreasures.count(tipo)
            visibleTreasures << tipo
          end
        end
      end

      if @specificHiddenTreasures != 0
        tiposHidden = []
        for tesoro in h
            tiposHidden << tesoro.getType
        end

        for tipo in @specificHiddenTreasures
          if tiposHidden.count(tipo) > hiddenTreasures.count(tipo)
            hiddenTreasures << tipo
          end
        end
      end

      SpecificBadConsequence.new(@text, @levels, visibleTreasures, hiddenTreasures)
  end
end

end
