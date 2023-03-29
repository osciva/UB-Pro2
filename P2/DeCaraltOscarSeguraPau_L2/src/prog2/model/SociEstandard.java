/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;


public class SociEstandard extends Soci  {

    Asseguranca asseguranca = new Asseguranca();

    /**
     *
     * Constructor per defecte de la classe SociEstandard
     *
     */
    public SociEstandard() {

    }

    /**
     * *
     * Ens serveix per a definir/assignar l'assegurança del soci estandard
     *
     * @param asseguranca el tipus d'assegurança del soci estandard
     */
    public void setAsseguranca(Asseguranca asseguranca) {
        this.asseguranca = asseguranca;

    }

    /**
     * *
     * Ens serveix per a obtenir el tipus d'assegurança del soci
     *
     * @return Retorna el tipus d'assegurança del soci
     *
     */
    public Asseguranca getAsseguranca() {
        return asseguranca;

    }

    /**
     * Constructor de la classe soci estandard al qual li entren per paràmetre
     * el nom i el DNI de part de la classe mare Soci, el tipus d'assegurança i
     * el preu d'aquesta.
     *
     * @param nom indica el nom del soci
     * @param DNI indica el DNI del soci
     * @param tipus indica el tipus d'assegurança contractada
     * @param preuAss indica el preu de l'assegurança contractada
     */
    public SociEstandard(String nom, String DNI, String tipus, float preuAss) {
        super(nom, DNI);
        this.asseguranca.setTipus(tipus);
        this.asseguranca.setPreu(preuAss);

    }

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents Socis
     * Estandard
     *
     * @return retorna una String amb les dades dels diferents Socis Estandard
     */
    @Override
    public String toString() {

        String imprimir = "Nom = " + getNom() + ", DNI = " + getDNI() + ". " + asseguranca.toString();
        return imprimir;

    }

    /**
     * Mètode on s'acaba de calcular el preu de les excursions per als socis
     * estandard
     *
     * @param preuExcursioBase Indica el preu de l'excursió sense descomptes ni
     * res
     * @return Conté el valor a pagar pel soci estàndard
     * @throws ExcepcioClub
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{

        return preuExcursioBase  + asseguranca.getPreu();

    }

    /**
     * Mètode que ens seveix per calcular la Quota mensual dels socis Estandard
     *
     * @param preuQuotaBase Indica el preu de la Quota sense descomptes ni res
     * @return el cost de la quota mensual
     * 
     */
    public float calculaQuota(float preuQuotaBase) {

        return preuQuotaBase;

    }

}
