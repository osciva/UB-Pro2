/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.io.IOException;

public class IniciadorClubUB {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     * @throws prog2.vista.ExcepcioClub
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException, ExcepcioClub {

        /*
        Un cop creat, aquest mètode es cridarà des del mètode main de la classe 
        IniciadorClubUB:
         */
        VistaClubUB vistaClub = new VistaClubUB();
        vistaClub.gestioClub();
    }

}
