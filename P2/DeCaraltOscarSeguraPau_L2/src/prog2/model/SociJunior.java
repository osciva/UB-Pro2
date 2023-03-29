/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;
/**
 *
 * @author Pau Segura
 */
public class SociJunior extends Soci   {

    /**
     *
     * Constructor per defecte de la classe SociFederat
     *
     */
    public SociJunior() {
    }

    /**
     * Constructor de la classe soci junior al qual li entren per paràmetre el
     * nom i el DNI de part de la classe mare Soci
     *
     * @param nom indica el nom del soci
     * @param DNI indica el DNI del soci
     */
    public SociJunior(String nom, String DNI) {
        super(nom, DNI);
    }

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents Socis Juniors
     *
     * @return retorna una String amb les dades dels diferents Socis Juniors
     */
    public String toString() {

        String imprimir = "Nom = " + getNom() + ", DNI = " + getDNI() + ". ";
        return imprimir;

    }

    /**
     * Mètode on s'acaba de calcular el preu de les excursions per als socis
     * juniors
     *
     * @param preuExcursioBase Indica el preu de l'excursió sense descomptes ni
     * res
     * @return Conté el valor a pagar pel soci Junior (0€ per les excursions)
     * @throws ExcepcioClub
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {

        return 0;

    }

    /**
     * Mètode que ens seveix per calcular la Quota mensual dels socis Juniors
     *
     * @param preuQuotaBase Indica el preu de la Quota sense descomptes ni res
     * @return el cost de la quota mensual per als socis Juniors
     * @throws ExcepcioClub
     */
    public float calculaQuota(float preuQuotaBase)throws ExcepcioClub {

        return preuQuotaBase;

    }

}
