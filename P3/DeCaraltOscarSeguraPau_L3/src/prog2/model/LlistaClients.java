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
public class LlistaClients extends Llista<Client> implements Serializable {

    /*
     * Aquest mètode permet afegir un client a l'ArrayList si aquest no hi
     * estava ja
     *
     * @param client Indica el client que es vol afegir
     */
    @Override
    public void afegir(Client client) {

            llista.add(client);


    }

    /*
     * Aquest mètode comprova si el client està a l'ArrayList o no
     *
     * @param client Indica el client que es vol comprovar si està o no
     * @return Retorna true si el client està a l'ArrayList o false si no hi està
     */
    public boolean contains(Client client) {
        boolean trobat = false;
        Iterator<Client> it = llista.iterator();
        while (it.hasNext()) {
            if (it.next().getCorreu().equals(client.getCorreu())) {
                trobat = true;

            }

        }

        return trobat;

    }

    /**
     * Aquest mètode permet esborrar un client de l'ArrayList si aquesta té
     * el client
     *
     * @param client Indica el client que es vol esborrar
     */

    @Override
    public void esborrar(Client client){
        if(isEmpty()){
            System.out.println("La llista està buida");


        }else{
            llista.remove(client);
        }
    }

}