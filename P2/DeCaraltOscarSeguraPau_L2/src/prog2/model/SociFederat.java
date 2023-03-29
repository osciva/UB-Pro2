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
public class SociFederat extends Soci {

    Federacio federacio = new Federacio();
    ClubUB club;

    /**
     *
     * Constructor per defecte de la classe SociFederat
     *
     */
    public SociFederat() {

    }

    /**
     * Constructor de la classe soci federat al qual li entren per paràmetre el
     * nom i el DNI de part de la classe mare Soci, el tipus de fedració i el
     * preu d'aquesta, i els descomptes en les excursions i en la quota mensual
     *
     * @param nom indica el nom del soci
     * @param DNI indica el DNI del soci
     * @param nomFederacio indica el tipus de federació contractada
     *
     * @param preu indica el preu de la federació contractada
     */
    public SociFederat(String nom, String DNI, float preu, String nomFederacio) {

        super(nom, DNI);
        this.federacio.setPreu(preu);
        this.federacio.setNom(nomFederacio);

    }

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents Socis Federats
     *
     * @return retorna una String amb les dades dels diferents Socis Federats
     */
    @Override
    public String toString() {

        String imprimir = "Nom = " + getNom() + ", DNI = " + getDNI() + ". " + federacio.toString();
        return imprimir;

    }

    /**
     * Mètode que ens seveix per calcular la Quota mensual dels socis Federats
     *
     * @param preuQuotaBase Indica el preu de la Quota sense descomptes ni res
     * @return el cost de la quota mensual per als socis Federats
     * @throws ExcepcioClub
     */
    public float calculaQuota(float preuQuotaBase) throws ExcepcioClub {

        return preuQuotaBase - (preuQuotaBase * 0.3f) + federacio.getPreu();

    }

    /**
     * Mètode on s'acaba de calcular el preu de les excursions per als socis
     * federats
     *
     * @param preuExcursioBase Indica el preu de l'excursió sense descomptes ni
     * res
     * @return Conté el valor a pagar pel soci Federat
     *
     * @throws ExcepcioClub
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {

        return preuExcursioBase - (preuExcursioBase * 0.2f);

    }

}
