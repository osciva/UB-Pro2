/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.*;

public class LlistaRemuntadors {

    public Scanner sc = new Scanner(System.in);

    public ArrayList<Remuntador> llista = new ArrayList<>();

    /**
     * *
     * Aquest mètode ens permet actualitzar l'estat dels remuntadors a partir
     * d'un iterator
     */
    public void actualitzaEstat(Meteo meteo) {
        Iterator<Remuntador> it = llista.iterator();
        while (it.hasNext()) {
            it.next().actualitzaEstat(meteo);

        }
    }

    /**
     * *
     * Aquest mètode ens permet afegir remuntadors a l'arraylist de tipus
     * Remuntador
     *
     * @param rm És el remuntador que entra a l'arraylist
     */
    public void afegirRemuntador(Remuntador rm) {
        llista.add(rm);
    }

    /**
     * *
     * Aquest mètode ens permet saber si tors els remuntadors estan fora de
     * servei o no. Utilitza un for per a recòrrer l'Arraylist i comprovar-ho
     *
     * @return en el cas que tots estiguin fora de servei retorna un boolean
     * true però en el cas que almenys un d'ells estigui en servei retorna false
     */
    public boolean totsForaDeServei() {
        boolean outOfService = true;
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i).getEstat().equalsIgnoreCase("En servei")) {
                outOfService = false;
                return outOfService;
            }
        }
        return outOfService;

    }

    /**
     * *
     * Aquest mètode ens permet llistar els remuntadors. Va recorrent
     * l'Arraylist, buscant tots els remuntadors amb el mateix estat i els va
     * guardant en una String
     *
     * @param estat És el paràmetre que decidirà si guardem els Remuntadors a la
     * String o no
     * @return Retorna la String amb els remuntadors que estan en l'estat estat.
     */
    public String llistarRemuntadors(String estat) {
        String llistaRemuntadors = "";
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i).getEstat().equalsIgnoreCase(estat)) {
                llistaRemuntadors += llista.get(i).toString() + "\n";
            } else if (estat.equalsIgnoreCase("Tots")) {
                llistaRemuntadors += llista.get(i).toString() + "\n";
            }
        }
        return llistaRemuntadors;

    }

    /**
     * *
     * Aquest mètode ens afegeix en una String anomenada noms els noms dels
     * remuntadors de l'Arraylist
     *
     * @return Retorna una String amb els noms dels remuntadors de l'Arraylist
     * Remuntador llista
     */
    public String getNoms() {
        String noms = "";
        for (int i = 0; i < llista.size(); i++) {
            noms += llista.get(i).getNom() + ", ";
        }
        return noms;

    }

}
