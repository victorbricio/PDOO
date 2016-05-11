#encoding: utf-8
require_relative 'Monster'
require_relative 'Treasure'
require_relative 'Cultist'
require_relative 'BadConsequence'
require_relative 'NumericBadConsequence'
require_relative 'SpecificBadConsequence'
require_relative 'DeathBadConsequence'
require 'singleton'

module NapakalakiGame

class CardDealer
  include Singleton

  def initialize
    @unusedTreasures = []
    @usedTreasures = []
    @unusedMonsters = []
    @usedMonsters = []
    @unusedCultists = []
  end

private
  def initTreasureCardDeck

      @unusedTreasures = []

      @unusedTreasures << Treasure.new("¡Sí mi amo!", 4, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOES)
      @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Botas de lluvia  ́acida", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Fez al ́opodo", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Hacha prehistóorica", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necro-comicón", 1, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necro-gnomicón", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necro-playboycón", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)

  end

  def initMonsterCardDeck

    @unusedMonsters = []

    badC = SpecificBadConsequence.new('Pierdes tu armadura visible y otra oculta.', 0,
    [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new('3 Byakhees de bonanza', 8, premio, badC, 0)

    badC = SpecificBadConsequence.new('Embobados con el lindo primigenio te descartas de tu casco visible.', 0,
    [TreasureKind::HELMET], 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('Chibithulhu', 2, premio, badC, 0)

    badC = SpecificBadConsequence.new('El primordial bostezo contagioso. Pierdes el calzado visible.', 0,
    [TreasureKind::SHOES], 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('El sopor de Dunwich', 2, premio, badC, 0)

    badC = SpecificBadConsequence.new('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.',
     0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    premio = Prize.new(4, 1)
    @unusedMonsters << Monster.new('Angeles de la noche ibicenca', 14, premio, badC, 0)

    badC = NumericBadConsequence.new('Pierdes todos tus tesoros visibles.', 0, 10, 0)
    premio = Prize.new(3, 1)
    @unusedMonsters << Monster.new('El gorron en el umbral', 10, premio, badC, 0)

    badC = SpecificBadConsequence.new('Pierdes la armadura visible.', 0,  [TreasureKind::ARMOR], 0)
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new('H.P. Munchcraft', 6, premio, badC, 0)

    badC = SpecificBadConsequence.new('Sientes bichos bajo la ropa. Descarta la armadura visible.', 0,
    [TreasureKind::ARMOR], 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('Bichgooth', 2, premio, badC, 0)

    badC = NumericBadConsequence.new('Pierdes 5 niveles y 3 tesoros visibles.', 5, 3, 0)
    premio = Prize.new(4, 2)
    @unusedMonsters << Monster.new('El rey de rosa', 13, premio, badC, 0)

    badC = NumericBadConsequence.new('Toses los pulmones y pierdes 2 niveles.', 2, 0, 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('La que redacta en las tinieblas', 2, premio, badC, 0)

    badC = DeathBadConsequence.new('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.')
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new('Los hondos', 8, premio, badC, 0)

    badC = NumericBadConsequence.new('Pierdes 2 niveles y 2 tesoros ocultos.', 2, 0, 2)
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new('Semillas Cthulhu', 4, premio, badC, 0)

    badC = SpecificBadConsequence.new('Te intentas escaquear. Pierdes una mano visible.', 0,  [TreasureKind::ONEHAND], 0)
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new('Dameargo', 1, premio, badC, 0)

    badC = NumericBadConsequence.new('Da mucho asquito. Pierdes 3 niveles.', 3, 0, 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('Pollipolipo volante', 3, premio, badC, 0)

    badC = DeathBadConsequence.new('No le hace gracia que pronuncien mal su nombre. Estas muerto.')
    premio = Prize.new(3, 1)
    @unusedMonsters << Monster.new('Yskhtihyssg-Goth', 12, premio, badC, 0)

    badC = DeathBadConsequence.new('La familia te atrapa. Est́as muerto.')
    premio = Prize.new(4, 1)
    @unusedMonsters << Monster.new('Familia feliz', 1, premio, badC, 0)

    badC = SpecificBadConsequence.new('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.',
    2, [TreasureKind::BOTHHANDS], 0)
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new('Roboggoth', 8, premio, badC, 0)

    badC = SpecificBadConsequence.new('Te asusta en la noche. Pierdes un casco visible.', 0,
    [TreasureKind::HELMET], 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('El espia', 5, premio, badC, 0)

    badC = NumericBadConsequence.new('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5, 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('El Lenguas', 20, premio, badC, 0)

    badC = SpecificBadConsequence.new('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.',
    3, [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new('Bicefalo', 20, premio, badC, 0)



    badC = SpecificBadConsequence.new("Pierdes 1 mano visible.", 0, [TreasureKind::ONEHAND], 0)
    premio = Prize.new(3, 1)
    @unusedMonsters << Monster.new("El mal indecible impronunciable", 10, badC, premio, -2)

    badC = NumericBadConsequence.new("Pierdes tus tesoros visibles. Jajaja.", 0, 10, 0)
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Testigos Oculares", 6, badC, premio, 2)

    badC = DeathBadConsequence.new("Hoy no es tu día de suerte. Mueres.")
    premio = Prize.new(2, 5)
    @unusedMonsters << Monster.new("El gran cthulhu", 20, badC, premio, 4)

    badC = NumericBadConsequence.new("Tu gobierno te recorta 2 niveles.", 2, 0, 0)
    premio = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Serpiente Político", 8, badC, premio, -2)

    badC = SpecificBadConsequence.new("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, [TreasureKind::HELMET, TreasureKind::ARMOR], [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS, TreasureKind::BOTHHANDS, TreasureKind::BOTHHANDS, TreasureKind::BOTHHANDS])
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Felpuggoth", 2, badC, premio, 5)

    badC = NumericBadConsequence.new("Pierdes 2 niveles.", 2, 0, 0)
    premio = Prize.new(4, 2)
    @unusedMonsters << Monster.new("Shoggoth", 16, badC, premio, -4)

    badC = NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0)
    premio = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Lolitagooth", 2, badC, premio, 3)

  end

  def initCultistsCardDeck
    @nusedCultists = []

    @unusedCultists << Cultist.new("Agaricus", 1)
    @unusedCultists << Cultist.new("Boletus", 2)
    @unusedCultists << Cultist.new("Daldinia", 1)
    @unusedCultists << Cultist.new("Bolbitius", 2)
    @unusedCultists << Cultist.new("Calvatia", 1)
    @unusedCultists << Cultist.new("Dermoloma", 1)
  end

  def shuffleTreasures
      @unusedTreasures.shuffle!
  end

  def shuffleMonsters
      @unusedMonsters.shuffle!
  end

  def shuffleCultists
      @unusedCultists.shuffle!
  end

public

  def GetInstance
    CardDealer.instance
  end

  def nextTreasure
    if @unusedTreasures.empty?
          @unusedTreasures = @usedTreasures
          shuffleTreasures
    end
    tesoro = @unusedTreasures.at(0)
    @unusedTreasures.delete_at(0)
    giveTreasureBack(tesoro)
    tesoro
  end

  def nextMonster
    if @unusedMonsters.empty?
        @unusedMonsters = @usedMonsters
        shuffleTreasures
    end
    monstruo = @unusedMonsters.at(0)
    @unusedMonsters.delete_at(0)
    giveTreasureBack(monstruo)
    monstruo
  end

  def nextCultist
      @unusedCultists.delete_at(0)
  end

  def giveTreasureBack(t)
      @usedTreasures << t
  end

  def giveMonsterBack(m)
      @usedMonsters << m
  end

  def initCards
    initMonsterCardDeck
    shuffleMonsters
    initTreasureCardDeck
    shuffleTreasures
    initCultistsCardDeck
    shuffleCultists
  end
end

end
