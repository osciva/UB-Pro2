/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.List;
import ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException;

public interface InDades {

    /**
     * Aquest mètode permet afegir un article a un arrayList si es pasen per
     * paràmtre les dades d'aquest
     *
     * @param id Indica l'identificador de l'article
     * @param nom Indica el nom de l'article
     * @param preu Indica el preu de l'article
     * @param temps Indica el temps per entregar l'article
     * @param admetUrgent Indica si l'article pot tenir una entrega urgent
     * @throws ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException
     */
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException;

    /**
     * Aquest mètode permet recuperar els Articles
     *
     * @return Retorna una llista de Strings
     */
    public List<String> recuperaArticles();

    /**
     * Aquest mètode permet afegir un client a un arrayList si es pasen per
     * paràmtre les dades d'aquest
     *
     * @param email Indica l'adreça electrònica del client
     * @param nom Indica el nom electrònica del client
     * @param adreca Indica l'adreça/direcció del client
     * @param esPremium Indica si el client és premium o no
     * @throws ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException
     */
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException;

    /**
     * Aquest mètode permet recuperar els clients
     *
     * @return Retorna una llista de Strings
     */
    public List<String> recuperaClients();

    /**
     * Aquest mètode permet afegir una comanda a un arrayList si es pasen per
     * paràmtre les dades d'aquesta
     *
     * @param articlePos Indica la posició de l'Article
     * @param clientPos Indica la posició del client
     * @param quantitat Indica la quantitat d'articles
     * @param esUrgent Indica si la comanda és urgent o no
     * @throws ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException
     */
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException;

    /**
     * Aquest mètode permet eliminar una comanda si s'indica la posició on es
     * troba la comanda
     *
     * @param position indica la posició on es troba la comanda
     * @throws ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException
     *
     */
    public void esborrarComanda(int position) throws MercatException;

    /**
     * Aquest mètode permet recuperar una comanda (tant normal com urgent)
     *
     * @return Retorna una llista de Strings *
     */
    public List<String> recuperaComandes();

    /**
     * Aquest mètode permet recuperar una comanda urgent
     *
     * @return Retorna una llista de Strings *
     */
    public List<String> recuperaComandesUrgents();
}
