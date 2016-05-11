#encoding: utf-8
require_relative 'TreasureKind'

module NapakalakiGame

class BadConsequence

  @@MAXTREASURES = 10

  def initialize(texto, niveles)
    @text = texto
    @levels = niveles
  end

  def getText
    @text
  end

  def getLevels
    @levels
  end

  def self.MAXTREASURES
    @@MAXTREASURES
  end

  def to_s
    "   Texto: #{@text} \n   Niveles perdidos: #{@levels} \n   Tesoros visibles perdidos: #{@nVisibleTreasures}
   Tesoros escondidos perdidos: #{@nHiddenTreasures} \n   Tesoros visibles especificos perdidos: #{@specificVisibleTreasures}
   Tesoros ocultos especificos perdidos: #{@specificHiddenTreasures}"
  end
end

end
