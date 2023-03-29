/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

public class Telecabina extends Remuntador {

    public Telecabina() {
    }

    /**
     * *
     * el constructor de la classe Telecabina és el mateix que el constructor de
     * la classe remuntador (és a dir, utilitza els mateixos atributs també)
     * això ho expressem al compilador amb la paraula reservada super
     *
     * @param nom serveix per identificar cada remuntador.
     * @param sector serveix per identificar a quin sector de la estació està
     * @param estat serveixper identificar si està en funcionament. Depèn de la
     * velocitat del vent i la visibilitat.
     * @param velocitatDelVentMax serveix per identificar la velocitat del vent
     * màxima a la qual poden funcionar els remuntadors
     * @param visibilitat serveix per identificar si el remuntador es veu
     * afectat per la visiibiltat.
     */
    public Telecabina(String nom, String sector, String estat, float velocitatDelVentMax, boolean visibilitat) {
        super(nom, sector, estat, velocitatDelVentMax, visibilitat);
    }

    /**
     * *
     * Aquest mètode ens indica el tipus de remuntador amb el qual estem
     * tractant
     *
     * @return retorna una String amb el tipus de Remuntador amb el qual estem
     * tractant
     */
    public String tipus() {
        return "Telecabina";
    }
}
