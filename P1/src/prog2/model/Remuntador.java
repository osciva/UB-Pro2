/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

public abstract class Remuntador {

    private String nom;
    private String sector;
    private String estat;
    private float velocitatDelVentMax;
    private boolean visibilitat;
    Meteo meteo;

    public Remuntador() {
    }

    /**
     * *
     * @param nom serveix per identificar cada remuntador.
     * @param sector serveix per identificar a quin sector de la estació està
     * @param estat serveixper identificar si està en funcionament. Depèn de la
     * velocitat del vent i la visibilitat.
     * @param velocitatDelVentMax serveix per identificar la velocitat del vent
     * màxima a la qual poden funcionar els remuntadors
     * @param visibilitat serveix per identificar si el remuntador es veu
     * afectat per la visiibiltat.
     */
    public Remuntador(String nom, String sector, String estat, float velocitatDelVentMax, boolean visibilitat) {
        this.nom = nom;
        this.sector = sector;
        this.estat = estat;
        this.velocitatDelVentMax = velocitatDelVentMax;
        this.visibilitat = visibilitat;
    }

    public abstract String tipus();

    /**
     * *
     * Ens serveix per a obtenir el nom del remuntador
     *
     * @return Retorna el nom del remuntador
     *
     */
    public String getNom() {
        return nom;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el nom del Remuntador
     *
     * @param nom Conté el nom del Remuntador
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * *
     * Ens serveix per a obtenir el sector del Remuntador (Nord o Sud)
     *
     * @return Retorna el sector del Remuntador
     *
     */
    public String getSector() {
        return sector;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el sector del Remuntador (Nord/Sud)
     *
     * @param sector Conté el sector del Remuntador
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * *
     * Ens serveix per a obtenir l'estat del Remuntador ( En Servei/Fora de
     * Servei )
     *
     * @return Retorna l'estat del Remuntador
     *
     */
    public String getEstat() {
        return estat;
    }

    /**
     * *
     * Ens serveix per a definir/assignar l'estat del Remuntador ( En
     * Servei/Fora de Servei )
     *
     * @param estat Conté l'estat del remuntador
     */
    public void setEstat(String estat) {
        this.estat = estat;
    }

    /**
     * *
     *
     * Ens serveix per obtenir la velocitat a la qual els remuntadors passen a
     * estar Fora de Servei, és a dir, la velocitat màxima del vent a la qual
     * deixen d'estar operatius
     *
     * @return la velocitat màxima del vent a la qual deixen d'estar operatius
     */
    public float getVelocitatDelVentMax() {
        return velocitatDelVentMax;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la velocitat màxima del vent que poden
     * soportar els remuntadors
     *
     * @param velocitatDelVentMax Conté la velocitat màxima del vent que poden
     * soportar els remuntadors
     */
    public void setVelocitatDelVentMax(float velocitatDelVentMax) {
        this.velocitatDelVentMax = velocitatDelVentMax;
    }

    /**
     * *
     * Ens serveix per a obtenir la visibilitat (Bona o Dolenta)
     *
     * @return Retorna si la visibilitat és bona o dolenta
     */
    public boolean getVisibilitat() {
        return visibilitat;
    }

    /**
     * *
     *
     * Ens serveix per a definir/assignar la visibilitat
     *
     * @param visibilitat Conté el valor de la visibilitat
     */
    public void setVisibilitat(boolean visibilitat) {
        this.visibilitat = visibilitat;
    }

    /**
     * *
     * Aquest mètode s'encarrega d'actualitzar els estats dels remuntadors,
     * segons les condicions meteorològiques
     *
     * @param meteo Aquest paràmetre ens permet accedir a les funcions de la
     * classe Meteo
     */
    public void actualitzaEstat(Meteo meteo) {

        if (meteo.getVelocitatDelVent() >= getVelocitatDelVentMax()) {
            setEstat("Fora de Servei");

        } else if (meteo.getVisibilitat().equalsIgnoreCase("Dolenta") && visibilitat) {
            setEstat("Fora de Servei");
        } else {
            setEstat("En Servei");

        }

    }

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents remuntadors
     *
     * @return Això retorna una String amb les dades dels diferents remuntadors
     */
    public String toString() {
        String imprimir = "Remuntador: " + getNom() + "        Tipus: " + tipus()
                + "        Sector: " + getSector() + "        Estat: " + getEstat();

        return imprimir;
    }

}
