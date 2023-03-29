/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.Date;

/**
 *
 * @author oscar
 */
public class ComandaUrgent extends Comanda {
    private Client client;
    private Articles article;
 /**
     * Constructor de la classe ComandaUrgent a la qual li entra per paràmetre
     * l'article, el client, la quantitat d'articles encarregats i la data
     * actual
     *
     * @param article Indica el tipus d'article demanat a la comanda
     * @param client Indica el tipus de client que demana la comanda
     * @param quantitatArticles Indica la quantitat d'articles demanats a la
     * comanda
     * @param data Indica la data actual.
     */
    public ComandaUrgent(Articles article, Client client, int quantitatArticles, Date data) {
        super(article, client, quantitatArticles, data);
    }
/**
     * Mètode que retorna una String amb el tipus de comanda amb la que tractem
     *
     * @return Retorna una String amb el tipus de comanda amb la que tractem
     */
    @Override
    public String tipusComanda() {
        return "Urgent";
    }
 /**
     * Mètode que retorna un boolean segons si la comanda s'ha enviat o no
     *
     * @return Retorna un boolean segons si la comanda s'ha enviat o no
     */
    @Override
   public boolean comandaEnviada() {
        Date dataActual = new Date();
        Date dataEnviament = new Date(getData().getTime() + (getArticle().getMins())*(24*60*60*1000)/2);

        return dataEnviament.before(dataActual);

    }
 /**
     * Mètode que retorna un boolean segons si la comanda s'ha rebut o no
     *
     * @return Retorna un boolean segons si la comanda s'ha rebut o no
     */
    @Override
    public boolean comandaRebuda() {
        Date dataActual = new Date();
        Date dataRebuda = new Date(getData().getTime() + (getArticle().getMins()*(24*60*60*1000)/2) + 1*24*60*60*1000);

        return dataRebuda.before(dataActual);

    }
/**
     * *
     * Mètode que retorna un float amb el preu per enviament amb el descompte inclós
     *
     * @return Retornarà un float amb el preu per enviament amb el descompte inclós
     */
    @Override
    public float preuEnviament() {
        //20% de descompte a un preu de 4€
        return 3.2f;
    }

}