#encoding: utf-8
require 'singleton'

module NapakalakiGame

class Dice
  include Singleton

  def GetInstance
    Dice.instance
  end

  def nextNumber
      1 + rand(6)
  end
end

end
