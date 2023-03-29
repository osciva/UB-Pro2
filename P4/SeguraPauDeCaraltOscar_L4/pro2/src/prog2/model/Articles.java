/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author oscar
 */
public class Articles implements Serializable {

    private String codi;
    private String prod;
    private float preu;
    private boolean urgent;
    private int mins;

    /**
     * Constructor per defecte de la classe Articles
     */
    public Articles() {

    }

    /**
     * Constructor de la classe Articles al qual li entra per paràmetre el codi,
     * el nom, el preu, si és urgent o no i el temps estimat que trigarà en
     * arribar el producte
     *
     * @param codi indica el codi de l'article
     * @param prod indica el nom del producte
     * @param preu indica el preu de l'article
     * @param urgent indica si és urgent o no
     * @param mins indica el temps que trigarà en arribar el producte
     */

    public Articles(String codi, String prod, float preu, boolean urgent, int mins) {
        this.codi = codi;
        this.prod = prod;
        this.preu = preu;
        this.urgent = urgent;
        this.mins = mins;
    }

    /**
     * *
     * Ens serveix per a obtenir el codi de l'article
     *
     * @return Retorna el codi de l'article
     *
     */
    public String getCodi() {
        return codi;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el codi de l'article
     *
     * @param codi Conté el codi de l'article
     */
    public void setCodi(String codi) {
        this.codi = codi;
    }

    /**
     * *
     * Ens serveix per a obtenir el nom de l'article
     *
     * @return Retorna el nom de l'article
     *
     */
    public String getProd() {
        return prod;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el nom de l'article
     *
     * @param prod Conté el nom de l'article
     */
    public void setProd(String prod) {
        this.prod = prod;
    }

    /**
     * *
     * Ens serveix per a obtenir el preu de l'article
     *
     * @return Retorna el preu de l'article
     *
     */
    public float getPreu() {
        return preu;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el preu de l'article
     *
     * @param preu Conté el preu de l'article
     */
    public void setPreu(float preu) {
        this.preu = preu;
    }

    /**
     * *
     * Ens serveix per a obtenir si un article és urgent o no
     *
     * @return Retorna si un article és urgent o no
     *
     */
    public boolean isUrgent() {
        return urgent;
    }

    /**
     * *
     * Ens serveix per a definir/assignar si un article és urgent o no
     *
     * @param urgent Conté si un article és urgent o no
     */
    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    /**
     * *
     * Ens serveix per a obtenir el temps que trigarà en arribar el producte
     *
     * @return Retorna el temps que trigarà en arribar el producte
     *
     */
    public int getMins() {
        return mins;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el temps que trigarà en arribar el
     * producte
     *
     * @param mins Conté el temps que trigarà en arribar el producte en minuts
     */
    public void setMins(int mins) {
        this.mins = mins;
    }

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents articles
     *
     * @return retorna una String amb les dades dels diferents articles
     */
    @Override
    public String toString() {

        String info = "Id=" + this.getCodi() + ", Nom=" + this.getProd() + ",Preu=" + this.getPreu() + ", Temps fins enviament=" + this.getMins() + ",Enviament Urgent=" + this.isUrgent();
        return info;

    }

}