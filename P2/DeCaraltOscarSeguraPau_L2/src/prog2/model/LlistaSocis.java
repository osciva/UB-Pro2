/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.*;
import prog2.vista.ExcepcioClub;

public class LlistaSocis implements InSociList, Serializable {
    private static final long serialVesrionUID = 2892432329053792L;
    private Soci soci;
    

    private int midaMax;
    private ArrayList<Soci> llista;

    /**
     * Constructor de la classe LlistaSocis al qual li entra per paràmetre la
     * mida màxima de l'ArrayList
     *
     * @param midaMax indica la mida màxima de l'ArrayList
     */
    public LlistaSocis(int midaMax) {
        this.llista = new ArrayList<>(midaMax);
        this.midaMax = midaMax;
    }

    /**
     * Mètode al que li entren per paràmetres l'ArrayList amb els socis i el
     * Soci. Aquest mètode serveix com a pas previ a afegir un soci a
     * l'ArrayList, ja que ens indica si podem afegir un soci perquè no hi ha
     * cap coïncidencia (true) o si no podem perquè ja hi ha un soci amb
     * aquelles característiques (DNI)(false)
     *
     *
     * @param soci soci que volem comparar amb cada element de l'ArrayList
     * @return el return ens indica si podem afegir un soci perquè no hi ha cap
     * coïncidencia (true) o si no podem perquè ja hi ha un soci amb aquelles
     * característiques (DNI)(false)
     */
    public boolean iguals(Soci soci) {

        for (int i = 0; i < getSize(); i++) {
            if (soci.getDNI().equals(llista.get(i).getDNI())) {

                return true;
            }

        }
        return false;
    }

    /**
     * Mètode al que li entren per paràmetres l'ArrayList amb els socis i el
     * Soci. Aquest mètode serveix per a saber si un soci està ja inscrit o no.
     * En aquest últim cas, permet inscriure'l.
     *
     *
     * @param soci soci al que voldrem comparar amb els socis de l'ArrayList
     */
    public void contains(Soci soci) {

        if (iguals(soci) == true) {
            System.out.println("Aquest soci ja està inscrit.");

        } else {
            llista.add(soci);
        }

    }

    /**
     * Donar el número d'elemnts que hi ha actualment emmagatzemants a la
     * llista.
     *
     * @return int amb el número d'elements de la llista.
     */
    public int getSize() {
        return llista.size();
    }

    /**
     * Afegir un nou soci
     *
     * @param soci objecte per afegir a la llista.
     * @throws prog2.vista.ExcepcioClub
     */
    public void addSoci(Soci soci) throws ExcepcioClub {

        try {
            if (isFull()) {

                throw new ExcepcioClub();
            } else {
                llista.add(soci);
            }

        } catch (ExcepcioClub plena) {
            throw new ExcepcioClub("la llista està plena");
        }

    }

    /**
     * Eliminar un objecte de la llista
     *
     * @param soci objecte per eliminar.
     * @throws prog2.vista.ExcepcioClub
     */
    public void removeSoci(Soci soci) throws ExcepcioClub {
        try {
            if (isEmpty()) {

                throw new ExcepcioClub();
            } else {
                llista.remove(soci);
            }
        } catch (ExcepcioClub buida) {

            throw new ExcepcioClub("La llista està buida");
        }

    }

    /**
     * Obtenir el soci guardat a una certa posició donada
     *
     * @param position posició a la llista de socis.
     * @return objecte soci a la posició donada o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getAt(int position) throws ExcepcioClub {
        try {
            if (isEmpty()) {

                throw new ExcepcioClub();
            } else {
                return llista.get(position);

            }

        } catch (ExcepcioClub buida) {
            throw new ExcepcioClub("La llista està buida");
        }

    }

    /**
     * Obtenir el soci donat el seu DNI
     *
     * @param dni DNI del soci al que volem accedir.
     * @return Objecte soci amb el dni donat o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getSoci(String dni) throws ExcepcioClub {
        try {
            if (isEmpty()) {

                throw new ExcepcioClub();

            } else {
                for (int i = 0; i < getSize(); i++) {
                    if (dni.equals(llista.get(i).getDNI())) {
                        return llista.get(i);

                    }

                }
            }
        } catch (ExcepcioClub buida) {
            throw new ExcepcioClub("La llista està buida");
        }
        return null;
    }

    /**
     * Eliminar tots els elements de la llista
     *
     * @throws prog2.vista.ExcepcioClub
     */
    public void clear() throws ExcepcioClub {
        try {

            if (isEmpty()) {

                throw new ExcepcioClub();

            } else {
                llista.clear();
            }

        } catch (ExcepcioClub buida) {
            throw new ExcepcioClub("La llista està buida");
        }

    }

    /**
     * Comprovar si la llista està a la seva capacitat màxima o no.
     *
     * @return True si la llista està plena (no hi ha lloc per més elements) o
     * false sinó.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isFull() throws ExcepcioClub {

        if (getSize() == midaMax) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Comprovar si la llista està buida o no.
     *
     * @return True si la llista està buida (no hi ha cap elements) o false
     * sinó.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isEmpty() throws ExcepcioClub {
        if (getSize() == 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Mètode que fa un recorregut al llarg de l'ArrayList i va implementant el
     * mètode toString per a cada soci
     *
     * @return retorna una String amb la informació de la Llista de Socis
     */
    public String llistarSocis() {
        String llistaSocis = "";
        for (int i = 0; i < getSize(); i++) {
            llistaSocis += i + 1 + ". " + llista.get(i).toString() + "\n";

        }

        return llistaSocis;

    }

}
