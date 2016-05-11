#encoding: utf-8

module NapakalakiGame

class Prize

  def initialize(tesoro, nivel)
    @treasures = tesoro
    @level = nivel
  end

  def getTreasures
    @treasures
  end

  def getLevels
    @level
  end

  def to_s
    "   Tesoros ganados: #{@treasures} \n   Niveles ganados: #{@level}"
  end

end

end
