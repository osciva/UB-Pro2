/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

/**
 *
 * @author oscar
 */
;

import java.io.Serializable;
import java.util.ArrayList;



public class Llista<T> implements Serializable  {

    protected ArrayList<T> llista;

    /*
    Constructor per defecte de la classe Llista on s'inicialitza una ArrayList
     */
    public Llista() {
        llista = new ArrayList<>();
    }

    /**
     * *
     * Ens serveix per a obtenir el tamany de l'arrayList
     *
     * @return Retorna el tamany de l'arrayList
     *
     */
    public int getSize() {
        return llista.size();
    }

    /**
     * Aquest mètode permet afegir un element a l'ArrayList
     *
     * @param t Indica l'element que es vol afegir a l'ArrayList
     */
    public void afegir(T t){

        llista.add(t);
    }

    /**
     * Aquest mètode permet eliminar un element de l'ArrayList
     *
     * @param t Indica l'element que es vol eliminar de l'ArrayList
     */
    public void esborrar(T t) {
        llista.remove(t);
    }

    /**
     * Aquest mètode permet obtenir d'una arrayList el que es trobi a la posició
     * indicada
     *
     * @param position Indica la posició de l'ArrayList
     * @return Retorna el valor contingut en la posició indicada
     */
    public T getAt(int position) {
        return llista.get(position);
    }

    /**
     * Aquest mètode permet eliminar tots els elements d'una ArrayList
     */
    public void clear() {
        llista.clear();
    }

    /**
     * Aquest mètode retorna si l'ArrayList està buida o no
     *
     * @return Retorna si l'ArrayList està buida o no
     */
    public boolean isEmpty() {
        boolean buida = false;
        if (getSize() == 0) {
            buida = true;

        }

        return buida;
    }

    /**
     * Aquest mètode permet obtenir una ArrayList
     *
     * @return Retorna una ArrayList
     */
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(llista);
        return arrlist;
    }
}
