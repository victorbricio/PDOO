
require_relative 'Player'
require_relative 'Cultist'

module NapakalakiGame

class CultistPlayer < Player

  @@totalCultistPlayers = 0

  def initialize (p, c)
    super(p)
    @myCultistCard = c
    @@totalCultistPlayers += 1
  end

protected
  def getCombatLevel
      (3 * super() / 2 + @myCultistCard.getGainedLevels() * @@totalCultistPlayers).to_i
  end

  def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer
  end

  def shouldConvert
    false
  end

public
  def getTotalCultistPlayers
      @@totalCultistPlayers
  end

end

end
