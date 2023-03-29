/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

public class Asseguranca implements Serializable {
    private static final long serialVesrionUID = 2892432329053792L;
    private String tipus;
    private float preu;

    public Asseguranca() {
    }

    /**
     * Constructor de la classe assegurança al qual li entren per paràmetre el
     * nom del tipus d'asseurança i el preu d'aquesta
     *
     * @param tipus indica el tipus d'assegurança que es contracta
     * @param preu indica el preu de l'assegurança que es contracta
     */
    public Asseguranca(String tipus, float preu) {
        this.tipus = tipus;
        this.preu = preu;
    }

    /**
     * *
     * Ens serveix per a obtenir el tipus d'assegurança
     *
     * @return Retorna el tipus d'assegurança
     *
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el tipus d'assegurança
     *
     * @param tipus Conté el tipus d'assegurança
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    /**
     * *
     * Ens serveix per a obtenir el preu de l'assegurança
     *
     * @return Retorna el preu de l'assegurança
     *
     */
    public float getPreu() {
        return preu;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el preu de l'assegurança
     *
     * @param preu Conté el preu de l'assegurança
     */
    public void setPreu(float preu) {
        this.preu = preu;
    }

    /**
     * *
     * Mètode que col·loca en una String les dades de les diferents assegurances
     *
     * @return retorna una String amb les dades de les diferents assegurances
     */
    public String toString() {

        String mostra = "Assegurança: Tipus = " + getTipus() + ", Preu = " + getPreu();
        return mostra;

    }

}
