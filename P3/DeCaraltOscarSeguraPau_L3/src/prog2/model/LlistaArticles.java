/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.*;

/*
 *
 * @author oscar
 */
public class LlistaArticles extends Llista<Articles> implements Serializable {

    /**
     * Aquest mètode permet afegir un article a l'ArrayList si aquest no hi estava ja
     * @param article Indica l'Article que es vol afegir
     */
    @Override
    public void afegir(Articles article) {
        llista.add(article);

    }

    /**
     * Aquest mètode comprova si un article està a l'ArrayList o no
     * @param article Indica l'Article que es vol comprovar si està o no
     * @return Retorna true si un article està a l'ArrayList o false si no hi està
     */
    public boolean contains(Articles article) {
        boolean trobat = false;
        Iterator<Articles> it = llista.iterator();
        while (it.hasNext()) {
            if (it.next().getCodi().equals(article.getCodi())) {
                trobat = true;

            }

        }

        return trobat;
    }

    /**
     * Aquest mètode permet esborrar un article de l'ArrayList si aquesta té
     * l'article
     *
     * @param article Indica l'Article que es vol esborrar
     */
    @Override
    public void esborrar(Articles article) {
        if (isEmpty()) {
            System.out.println("La llista està buida");
        } else {
            llista.remove(article);

        }
    }

}