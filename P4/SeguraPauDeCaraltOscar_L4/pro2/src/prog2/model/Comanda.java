/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author oscar
 */
public abstract class Comanda implements Serializable {

    private Articles article;
    private Client client;
    int quantitatArticles;
    private Date data;

    /**
     * Constructor de la classe Comanda a la qual li entra per paràmetre
     * l'article, el client, la quantitat d'articles encarregats i la data
     * actual
     *
     * @param article Indica el tipus d'article demanat a la comanda
     * @param client Indica el tipus de client que demana la comanda
     * @param quantitatArticles Indica la quantitat d'articles demanats a la
     * comanda
     * @param data Indica la data actual.
     */
    public Comanda(Articles article, Client client, int quantitatArticles, Date data) {
        this.article = article;
        this.client = client;
        this.quantitatArticles = quantitatArticles;
        this.data = data;
    }

    /**
     * *
     * Ens serveix per a obtenir l'Article
     *
     * @return Retorna l'Article
     *
     */
    public Articles getArticle() {
        return article;
    }

    /**
     * *
     * Ens serveix per a definir/assignar l'Article
     *
     * @param article Conté l'Article
     */
    public void setArticle(Articles article) {
        this.article = article;
    }

    /**
     * *
     * Ens serveix per a obtenir la data actual
     *
     * @return Retorna la data actual
     *
     */
    public Date getData() {
        return data;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la data actual
     *
     * @param data Conté la data actual
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * *
     * Ens serveix per a obtenir la quantitat d'articles que s'han demanat a la
     * comanda
     *
     * @return Retorna la quantitat d'articles que s'han demanat a la comanda
     *
     */
    public int getQuantitatArticles() {
        return quantitatArticles;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la quantitat d'articles que s'han
     * demanat a la comanda
     *
     * @param quantitatArticles Conté la quantitat d'articles que s'han demanat
     * a la comanda
     */
    public void setQuantitatArticles(int quantitatArticles) {
        this.quantitatArticles = quantitatArticles;
    }

    /**
     * Mètode que retorna una String amb el tipus de comanda encarregada
     *
     * @return Retorna una String amb el tipus de comanda encarregada
     */
    public abstract String tipusComanda();

    /**
     * Mètode abstracte que retorna un boolean segons si la comanda s'ha enviat
     * o no
     *
     * @return Retorna un boolean segons si la comanda s'ha enviat o no
     */
    public abstract boolean comandaEnviada();

    /**
     * Mètode abstracte que retorna un boolean segons si la comanda s'ha rebut o
     * no
     *
     * @return Retorna un boolean segons si la comanda s'ha rebut o no
     */
    public abstract boolean comandaRebuda();

    /**
     * *
     * Mètode abstracte que s'implementarà a les classes filles i que retorna un
     * float amb el preu per enviament segons el tipus de comanda
     *
     * @return Retornarà un float amb el preu per enviament segons el tipus de
     * comanda
     */
    public abstract float preuEnviament();

    /**
     * *
     * Mètode que retorna un float amb el càlcul del preu d'una comanda tenint
     * en compte el preu de l'article, la quantitat d'aquests i el tipus
     * d'enviament
     *
     * @return Retornarà un float amb el càlcul del preu d'una comanda
     */
    public float calcPreu() {
        //preuBase == preu sense comptar el tipus d'enviament
        float preuBase = (article.getPreu() * getQuantitatArticles()) + preuEnviament();
        return preuBase;
    }

    /**
     * *
     * Mètode que col·loca en una String les dades de les diferents comandes
     *
     * @return retorna una String amb les dades de les diferents comandes
     */
    public String toString() {
        String info = "Tipus = " + tipusComanda() + " Article = " + article.getProd()
                + " Client = " + client.getNom() + " Quantitat = " + getQuantitatArticles() + " Data de creació = "
                + getData() + " Enviat = " + comandaEnviada() + " Rebuda = "
                + comandaRebuda() + " Preu Articles = " + calcPreu() + " Preu Enviament = " + preuEnviament();

        return info;
    }
}