/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author victor
 */
public class Dice {
private static Dice instance = null;
 
   // El constructor privado asegura que no se puede instanciar 
  // desde otras clases
  private Dice () { }
 
  public static Dice getInstance() {
       if (instance == null)
          instance = new Dice();
       return instance;
  }
  
  public int nextNumber(){
      Random r = new Random();
      int numero = r.nextInt(6) + 1;
      return numero;
  }
}
