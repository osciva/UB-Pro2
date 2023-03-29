/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.ExcepcioClub;

public abstract class Soci implements InSoci, Serializable {
    private static final long serialVesrionUID = 2892432329053792L;
    private String nom;
    private String DNI;

    /**
     * *
     * Ens serveix per a obtenir el nom del soci
     *
     * @return Retorna el nom del soci
     *
     */
    public String getNom() {
        return nom;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el nom del soci
     *
     * @param nom Conté el nom del soci
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * *
     * Ens serveix per a obtenir el DNI del soci
     *
     * @return Retorna el DNI del soci
     *
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el DNI del soci
     *
     * @param DNI Conté el DNI del soci
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Soci() {

    }

    /**
     * Constructor de la classe Soci al qual li entren per paràmetre el nom i el
     * DNI d'aquest/a
     *
     * @param nom indica el nom del Soci
     * @param DNI indica el DNI del Soci
     */
    public Soci(String nom, String DNI) {
        this.nom = nom;
        this.DNI = DNI;
    }

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents Socis
     *
     * @return retorna una String amb les dades dels diferents Socis
     */
    public String toString() {
        String imprimir = "Nom = " + getNom() + ", DNI = " + getDNI();
        return imprimir;
    }

    /**
     * Mètode que ens seveix per calcular la Quota mensual, i que en les
     * subclasses acabarem d'implementar (si és necessari)
     *
     * @param quotaBase Indica el preu de la Quota sense descomptes ni res
     * @return el cost de la quota
     * @throws ExcepcioClub
     */
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    /**
     * Mètode que ens seveix per calcular el preu de les excursions, i que en
     * les subclasses acabarem d'implementar (farem polimorfisme)
     *
     * @param preuExcursioBase Indica el preu de l'excursió sense descomptes ni
     * res
     * @throws ExcepcioClub
     */
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;

}
