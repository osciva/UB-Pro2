/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.Iterator;

public class Pista {

    private String nom;
    private String sector;
    private String color;
    private float longitud;
    private String estatDeLaNeu;
    private String estat;
    private LlistaRemuntadors dependencies = new LlistaRemuntadors();

    public Pista() {
    }

    /**
     * *
     * conté un constructor per construir l’objecte pista. Conté els atributs:
     * nom, sector, color, longitud, estatDeLaNeu, estat i dependències.      *
     * Sector: on de la estació està colocada. Color: nivell de dificultat de
     * cada pista:Verda, Blava, Vermella o Negra. Longitud: longitud de cada
     * pista. estatDeLaNeu: estat de la neu que pot variar entre Pols, Dura o
     * Primavera. estat: atribut que dirà si la pista està oberta o tancada. És
     * un atribut molt important. Dependencies: aquí es dirà de quin remuntador
     * depèn cada pista. Si un remuntador està fora de servei, la pista del qual
     * depèn també ho estarà.
     *
     * @param nom serveix per identificar cada pista
     * @param sector serveix per identificar si està al Nord o al Sud
     * @param color serveix per a identificar el nivell de dificultat de cada
     * pista: Verda, Blava, Vermella o Negra
     * @param longitud serveix per a identificar la longitud de la pista
     * @param estatDeLaNeu serveix per identificar l'estat de la neu que pot
     * variar entre Pols, Dura o Primavera
     * @param estat serveix per a identificar si la pista està oberta o tancada
     */
    public Pista(String nom, String sector, String color, float longitud, String estatDeLaNeu, String estat) {
        this.nom = nom;
        this.sector = sector;
        this.color = color;
        this.longitud = longitud;
        this.estatDeLaNeu = estatDeLaNeu;
        this.estat = estat;

    }

    /**
     * *
     * Ens serveix per a obtenir el nom de la pista
     *
     * @return Retorna el nom de l'estació
     *
     */
    public String getNom() {
        return nom;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el nom de la Pista
     *
     * @param nom Conté el nom de la Pista
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * *
     * Ens serveix per a obtenir el sector de la pista (Nord o Sud)
     *
     * @return Retorna el sector de la Pista
     *
     */
    public String getSector() {
        return sector;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el sector de la Pista (Nord/Sud)
     *
     * @param sector Conté el sector de la Pista
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * *
     * Ens serveix per a obtenir el color de la pista (Verda, Vermella, Blava,
     * Negra)
     *
     * @return Retorna el color de la Pista
     *
     */
    public String getColor() {
        return color;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el color de la Pista (Verda, Vermella,
     * Blava, Negra)
     *
     * @param color Conté el coloor de la Pista
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * *
     * Ens serveix per a obtenir la longitud de la pista (en km)
     *
     * @return Retorna la longitud de la Pista
     *
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la longitud de la Pista (en km)
     *
     * @param longitud Conté la longitud de la Pista
     */
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    /**
     * *
     * Ens serveix per a obtenir l'estat de la neu ( Dura/Pols/Primavera )
     *
     * @return Retorna l'estat de la neu
     *
     */
    public String getEstatDeLaNeu() {
        return estatDeLaNeu;
    }

    /**
     * *
     * Ens serveix per a definir/assignar l'estat de la neu (
     * Dura/Pols/Primavera )
     *
     * @param estatDeLaNeu Conté l'estat de la neu
     */
    public void setEstatDeLaNeu(String estatDeLaNeu) {
        this.estatDeLaNeu = estatDeLaNeu;
    }

    /**
     * *
     * Ens serveix per a obtenir l'estat de la Pista ( Oberta/Tancada )
     *
     * @return Retorna l'estat de la pista
     *
     */
    public String getEstat() {
        return estat;
    }

    /**
     * *
     * Ens serveix per a definir/assignar l'estat de la Pista ( Oberta/Tancada )
     *
     * @param estat Conté l'estat de la pista
     */
    public void setEstat(String estat) {
        this.estat = estat;
    }

    /**
     * *
     * Mètode que actualitza els estats de les pistes a través d'un iterador
     */
    public void actualitzaEstat() {
        Iterator<Remuntador> it = dependencies.llista.iterator();
        while (it.hasNext()) {
            if (it.next().getEstat().equals("Fora de Servei")) {
                estat = "Tancada";
            } else {
                estat = "Oberta";
            }
        }

    }

    /**
     * *
     * Mètode per afegir les dependències de les pistes amb els remuntadors
     *
     * @param rm És el remuntador del qual dependrà una pista
     *
     */
    public void afegirDependencia(Remuntador rm) {
        dependencies.llista.add(rm);
    }

    /**
     * *
     * Ens serveix per a obtenir les dependències
     *
     * @return Retorna les dependències
     *
     */
    public LlistaRemuntadors getDependencies() {
        return dependencies;
    }

    /**
     * *
     *
     * Ens serveix per a definir/assignar les dependències
     *
     * @param dependencies Conté les dependències
     */
    public void setDependencies(LlistaRemuntadors dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * *
     * Mètode que col·loca en una String les dades de les diferents pistes
     *
     * @return Això retorna una String amb les dades de les diferents pistes.
     */
    public String toString() {
        String frase = "Pista: " + nom + "        Sector: " + sector + "        Color: "
                + color + "        Longitud: " + longitud + "        Estat de la neu: "
                + estatDeLaNeu + "        Estat de la pista: " + estat
                + "        Dependències: " + getDependencies().getNoms();
        return frase;
    }
}
