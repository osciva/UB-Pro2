/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

public class Federacio implements Serializable {
    private static final long serialVesrionUID = 2892432329053792L;

    private String nom;
    private float preu;

    public Federacio() {
    }

    /**
     * Constructor de la classe Federació al qual li entren per paràmetre el nom
     * del tipus de Federació i el preu d'aquesta
     *
     * @param nom indica el tipus de Federació que es contracta
     * @param preu indica el preu de Federació que es contracta
     */
    public Federacio(String nom, float preu) {
        this.nom = nom;
        this.preu = preu;
    }

    /**
     * *
     * Ens serveix per a obtenir el tipus de Federació
     *
     * @return Retorna el tipus de Federació
     *
     */
    public String getNom() {
        return nom;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el tipus de Federació
     *
     * @param nom Conté el tipus de Federació
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * *
     * Ens serveix per a obtenir el preu de la Federació
     *
     * @return Retorna el preu de la Federació
     *
     */
    public float getPreu() {
        return preu;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el preu de la Federació
     *
     * @param preu Conté el preu de la Federació
     */
    public void setPreu(float preu) {
        this.preu = preu;
    }

    /**
     * *
     * Mètode que col·loca en una String les dades de les diferents Federacions
     *
     * @return retorna una String amb les dades de les diferents Federacions
     */
    public String toString() {

        String mostra = "Federació: Nom=" + getNom() + ", Preu = " + getPreu();
        return mostra;

    }
}
