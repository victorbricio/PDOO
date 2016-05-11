#encoding: utf-8
require_relative 'TreasureKind'

module NapakalakiGame

class Treasure

  def initialize(n, b, t)
    @name = n
    @bonus = b
    @type = t
  end

   def getName
     @name
   end

   def getBonus
     @bonus
   end

   def getType
     @type
   end

   def to_s
     "#{@name}" + "\n" + "+#{@bonus}" + "\n" + "#{@type}" + "\n"
   end
end

end
