/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author victor
 */
public class CardDealer {

    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
 

  private CardDealer() { 
      unusedMonsters = null;
      usedMonsters = new ArrayList();
      unusedTreasures = null;
      usedTreasures = new ArrayList();
      unusedCultists = null;
  }
 

  private void initTreasureCardDeck(){
      
      unusedTreasures = new ArrayList();
      
      unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
      unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Botas de lluvia  ́acida", 1, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Fez al ́opodo", 3, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Hacha prehistóorica", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
      
      
  }

  private void initMonsterCardDeck(){
      
        BadConsequence Bc;
        Prize P;
        unusedMonsters = new ArrayList();
        
        Bc = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, Bc, P));
        
        Bc = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList<TreasureKind>());
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, Bc, P));
        
        Bc = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList<TreasureKind>());
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, Bc, P));
        
        Bc = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        P = new Prize(4, 1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, Bc, P));
        
        Bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles.", 0, 10, 0);
        P = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, Bc, P));
        
        Bc = new SpecificBadConsequence("Pierdes la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList<TreasureKind>());
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, Bc, P));
        
        Bc = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList<TreasureKind>());
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, Bc, P));
        
        Bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        P = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, Bc, P));
        
        Bc = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, Bc, P));
        
        Bc = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.");
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, Bc, P));
        
        Bc = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, Bc, P));
        
        Bc = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList<TreasureKind>());
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, Bc, P));
        
        Bc = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, Bc, P));
        
        Bc = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto.");
        P = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, Bc, P));
        
        Bc = new DeathBadConsequence("La familia te atrapa. Est́as muerto.");
        P = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, Bc, P));
        
        Bc = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList<TreasureKind>());
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, Bc, P));
        
        Bc = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList<TreasureKind>());
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia", 5, Bc, P));
        
        Bc = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("El Lenguas", 20, Bc, P));
        
        Bc = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList<TreasureKind>());
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicefalo", 20, Bc, P));
        
        Bc = new SpecificBadConsequence("Pierdes 1 mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList<TreasureKind>());
        P = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, Bc, P, -2));
        
        Bc = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, 10, 0);
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, Bc, P, 2));
        
        Bc = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.");
        P = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, Bc, P, 4));
        
        Bc = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        P = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, Bc, P, -2));   
        
        Bc = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS)));
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, Bc, P, 5));
        
        Bc = new NumericBadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        P = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, Bc, P, -4));
        
        Bc = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        P = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, Bc, P, 3)); 
  }
  
  private void initCultistsCardDeck() {
      
      unusedCultists = new ArrayList();
      
      unusedCultists.add(new Cultist("Agaricus", 1));
      unusedCultists.add(new Cultist("Boletus", 2));
      unusedCultists.add(new Cultist("Daldinia", 1));
      unusedCultists.add(new Cultist("Bolbitius", 2));
      unusedCultists.add(new Cultist("Calvatia", 1));
      unusedCultists.add(new Cultist("Dermoloma", 1));
  }
  
  private void shuffleTreasures(){
      Collections.shuffle(unusedTreasures);
  }

  private void shuffleMonsters(){
      Collections.shuffle(unusedMonsters);
  }
  
  private void shuffleCultists () {
      Collections.shuffle(unusedCultists);
  }
  
  public static CardDealer getInstance() {
      if (instance == null)
          instance = new CardDealer();
      return instance;
  }
  
  public Treasure nextTreasure(){
      if (unusedTreasures == null){
          unusedTreasures = usedTreasures;
          shuffleTreasures();
        }  
      Treasure tesoro = unusedTreasures.remove(0);
      giveTreasureBack(tesoro);
      return tesoro;
  }

  public Monster nextMonster(){
      if (unusedMonsters == null){
          unusedMonsters = usedMonsters;
          shuffleMonsters();
        }
      Monster monstruo = unusedMonsters.remove(0);
      giveMonsterBack(monstruo);
      return monstruo;
  }
  
  public Cultist nextCultist () {
      Cultist sectario = unusedCultists.remove(0);
      return sectario;
  }

  public void giveTreasureBack(Treasure t){
      usedTreasures.add(t);
  }

  public void giveMonsterBack(Monster m){
      usedMonsters.add(m);
  }

  public void initCards(){
      initMonsterCardDeck();
      shuffleMonsters();
      initTreasureCardDeck();
      shuffleTreasures();
      initCultistsCardDeck();
      shuffleCultists ();
  }
}
