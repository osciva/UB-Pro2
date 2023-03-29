/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.io.IOException;

/*
 *
 * @author oscar
 */
public class IniciadorMercatUB {

/*
 * Mètode Main del nostre projecte MercatUB
 * @param args
 * @throws ClassNotFoundException
 * @throws MercatException
 * @throws IOException 
 */
    public static void main(String[] args) throws ClassNotFoundException, MercatException, IOException {

        /**
        Un cop creat, aquest mètode es cridarà des del mètode main de la classe 
        IniciadorMercatUB:
         */
        MercatUB mercatUB = new MercatUB();
        mercatUB.gestioMercat();
    }

}