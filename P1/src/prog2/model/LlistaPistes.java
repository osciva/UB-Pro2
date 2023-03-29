/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaPistes {

    public ArrayList<Pista> llista = new ArrayList<>();
    //LlistaPistes llistaDePistes = new LlistaPistes();
    Pista pista = new Pista();

    /**
     * *
     * Aquest mètode ens permet actualitzar l'estat de les pistes a partir d'un
     * iterator
     */
    public void actualitzaEstat() {

        Iterator<Pista> it = llista.iterator();
        while (it.hasNext()) {
            it.next().actualitzaEstat();

        }

    }

    /**
     * *
     * Aquest mètode ens permet afegir pistes a l'arraylist de tipus Pista
     *
     * @param p És la pista que entra a l'arraylist
     */
    public void afegirPista(Pista p) {
        llista.add(p);
    }

    /**
     * *
     * Aquest mètode ens permet buscar la pista que volem trobar
     *
     * @param nom És el nom de la Pista
     * @return Retorna la Pista
     */
    public Pista getPista(String nom) {
        boolean esAquesta = false;
        Pista eleccio = new Pista();

        while (!esAquesta) {

            for (int i = 0; i < llista.size(); i++) {

                if (llista.get(i).getNom().equals(nom)) {

                    eleccio = llista.get(i);
                    esAquesta = true;

                }
            }

        }
        return eleccio;
    }

    /**
     * *
     * Aquest mètode serveix per llistar les pistes segons l'entrada
     *
     * @param estat En el cas que sigui "Tots" et retorna una String amb totes
     * les pistes, en el cas que sigui "Oberta" només amb les pistes que estan
     * obertes i en el cas de "Tancada" només amb les pistes que estan tancades
     * @return És una String que conté totes les pistes amb el mateix estat
     */
    public String llistarPistes(String estat) {
        String llistatPistes = "";
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i).getEstat().equalsIgnoreCase(estat)) {
                llistatPistes += llista.get(i).toString() + "\n";
            } else if (estat.equalsIgnoreCase("Tots")) {
                llistatPistes += llista.get(i).toString() + "\n";
            }
        }
        return llistatPistes;
    }

    /**
     * *
     * Aquest mètode s'encarrega de calcular la longitud en Km de les Pistes amb
     * el mateix estat
     *
     * @param estat En el cas que sigui "Tots" et calcula els Km de totes les
     * pistes, en el cas que sigui "Oberta" només els Km de les pistes que estan
     * obertes i en el cas de "Tancada" només els Km de les pistes que estan
     * tancades
     * @return És el valor en Km de les pistes amb un mateix estat
     */
    public float calculaKmsPistes(String estat) {
        float distancia = 0;
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i).getEstat().equals(estat)) {
                distancia += llista.get(i).getLongitud();

            } else if (estat.equalsIgnoreCase("Tots")) {
                distancia += llista.get(i).getLongitud();
            }
        }

        return distancia;

    }

}
