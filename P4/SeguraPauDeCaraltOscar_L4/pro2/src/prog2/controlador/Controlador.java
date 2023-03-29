/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.controlador;

import prog2.model.Dades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import prog2.model.LlistaClients;
import ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException;

/**
 *
 * @author oscar
 */
public class Controlador implements Serializable {

    Dades dades = new Dades();

    public Controlador() {

    }

    /**
     * Mètode per a preguntar a l'usuari les dades de l'Article que vol afegir a
     * l'ArrayList
     *
     * @param codi Indica el codi de l'article que es vol afegir
     * @param nom Indica el nom de l'article que es vol afegir
     * @param preu Indica el preu de l'article que es vol afegir
     * @param urgent Indica si admet urgent l'article que es vol afegir
     * @param mins Indica el temps en min de l'article que es vol afegir
     * @throws MercatException
     */
    public void afegirArticle(String codi, String nom, float preu, boolean urgent, int mins) throws MercatException {
        
        dades.afegirArticle(codi, nom, preu, mins, urgent);

    }

    /**
     * Mètode per a mostrar per pantalla els Articles
     */
    public void mostraArticles() {
        for (int i = 0; i < dades.getLlista().getSize(); i++) {
            System.out.println(dades.getLlista().getAt(i).toString());

        }

    }

    /**
     * Mètode per a preguntar a l'usuari les dades del client que vol afegir a
     * l'ArrayList
     *
     * @param correu Indica el correu del client que es vol afegir
     * @param nom Indica el nom de l'article que es vol afegir
     * @param direc Indica la direcció del client que es vol afegir
     * @param prem Indica si es premium l'article que es vol afegir
     * @throws MercatException
     */
    public void afegirClient(String correu, String nom, String direc, boolean prem) throws MercatException {
        
        dades.afegirClient(correu, nom, direc, prem);

    }

    /**
     * Mètode per a mostrar per pantalla els Clients
     */
    public void mostraClients() {
        for (int i = 0; i < dades.getLlistaclients().getSize(); i++) {
            System.out.println(dades.getLlistaclients().getAt(i).toString());

        }
    }

    /**
     * Mètode per a preguntar a l'usuari les dades de la comanda que vol afegir
     * a l'ArrayList
     *
     * @param posArt Indica la posició de l'Article a l'ArrayList 
     * @param posClient Indica la posició del Client a l'ArrayList 
     * @param quant Indica la quantitat d'Articles que es volen demanar
     * @param urg Indica si la Comanda és urgent o no
     * @throws MercatException
     */
    public void afegirComanda(int posArt, int posClient, int quant, boolean urg) throws MercatException { //posart,posclient,quant,esUrgent
        
       
        
        dades.afegirComanda(posArt, posClient,quant, urg);

    }

    /**
     * Mètode per a esborrar una comanda de l'ArrayList si s'indica la posició
     * d'aquesta
     *
     * @param pos Indica la posició de la Comanda que es vol esborrar
     * @throws ub.info.prog2.DeCaraltOscarSeguraPau.vista.MercatException
     */
    public void esborrarComandes(int pos) throws MercatException {
        
        dades.esborrarComanda(pos);

    }

    /**
     * Mètode per a mostrar per pantalla les Comandes
     */
    public void mostraComandes() {
        for (int i = 0; i < dades.recuperaComandes().size(); i++) {
            System.out.println(dades.recuperaComandes().get(i));

        }

    }

    /**
     * Mètode per a mostrar per pantalla les Comandes Urgents
     */
    public void mostraUrgents() {
        for (int i = 0; i < dades.recuperaComandesUrgents().size(); i++) {
            System.out.println(dades.recuperaComandesUrgents().get(i));

        }
    }
    /**
     * Mètode que retorna una ArrayList d'Strings amb els clients
     * @return retorna una ArrayLlist amb els clients
     */
    public List<String> recuperaClients(){
        return dades.recuperaClients();
    }
    /**
     * Mètode que retorna una ArrayList d'Strings amb els articles
     * @return retorna una ArrayLlist amb els articles
     */
    public List<String> recuperaArticles(){
        return dades.recuperaArticles();
    }
    /**
     * Mètode que retorna una ArrayList d'Strings amb les comandes
     * @return retorna una ArrayLlist amb les comandes
     */
    public List<String> recuperaComandes(){
        return dades.recuperaComandes();
    }

    /**
     * Mètode per a guardar les dades a un fitxer .dat
     *
     * @param fitxer Indica el nom del fitxer on es guardaran les dades
     * @throws MercatException
     * 
     */
    public void guarda(String fitxer) throws MercatException {
        dades.guardaDades(fitxer);

    }

    /**
     * Mètode per a recuperar les dades guardades anteriorment en el fitxer .dat
     * @param fitxer Indica el nom del fitxer d'on es recuperaran les dades
     * @throws MercatException
     * 
     */
    public void carregaDades(String fitxer) throws MercatException {

        dades = Dades.carregaDades(fitxer);

    }
    
}
