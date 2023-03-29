/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/*
 *
 * @author oscar
 */
public class LlistaComandes extends Llista<Comanda> implements Serializable {

    /*
     * Constructor de la classe LlistaComandes que ens permetrà heredar de la classe Llista
     */
    public LlistaComandes() {
        super();
    }

    /*
     * Aquest mètode permet esborrar una comanda de l'ArrayList si aquesta té
     * la comanda
     *
     * @param comanda Indica la comanda que es vol esborrar
     */
    @Override
    public void esborrar(Comanda comanda) {

        if (isEmpty()) {
            System.out.println("La llista està buida");
        } else {
            llista.remove(comanda);

        }

    }

    /*
     * Ens retorna un Booleà dient si és Urgent(true) o no(False)
     * @param comanda Indica la comanda de la qual es comprovarà la seva urgència
     * @return Retorna un Booleà dient si és Urgent(true) o no(False)
     */
    public boolean urgent(Comanda comanda) {
        if (comanda instanceof ComandaUrgent) {
            return comanda.getArticle().isUrgent();
        }

        return true;
    }

    /**
     * Aquest mètode permet afegir una comanda a l'ArrayList si aquesta no hi
     * estava ja
     *
     * @param comanda Indica la comanda que es vol afegir
     */
    @Override
    public void afegir(Comanda comanda) {
        llista.add(comanda);

    }

}
