#encoding: utf-8
require_relative 'NumericBadConsequence'
require_relative 'Player'

module NapakalakiGame

class DeathBadConsequence < NumericBadConsequence

  def initialize (texto)
    super(texto, Player.MAXLEVELS, BadConsequence.MAXTREASURES, BadConsequence.MAXTREASURES)
  end

end

end
