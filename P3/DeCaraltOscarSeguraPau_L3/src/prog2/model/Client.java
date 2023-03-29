/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author oscar
 */
public abstract class Client implements Serializable{

    private String correu;
    private String nom;
    private String direc;
    
    
    /**
     * Constructor per defecte de la classe Client
     */
    public Client(){
        
    }
    /**
     * Constructor de la classe Client al qual li entra per paràmetre el correu
     * , el nom i la direcció del client
     *
     * @param correu indica l'adreça electrònica del client
     * @param nom indica el nom del client
     * @param direc indica la direcció del client
     */

    public Client(String correu, String nom, String direc) {
        this.correu = correu;
        this.nom = nom;
        this.direc = direc;
    }

    /**
     * *
     * Ens serveix per a obtenir el correu del client
     *
     * @return Retorna el correu del client
     *
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el correu del client
     *
     * @param correu Conté el correu del client
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }

    /**
     * *
     * Ens serveix per a obtenir el nom del client
     *
     * @return Retorna el nom del client
     *
     */
    public String getNom() {
        return nom;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el nom del client
     *
     * @param nom Conté el nom del client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * *
     * Ens serveix per a obtenir la direcció/adreça del client
     *
     * @return Retorna la direcció/adreça del client
     *
     */
    public String getDirec() {
        return direc;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la direcció/adreça del client
     *
     * @param direc Conté la direcció/adreça del client
     */
    public void setDirec(String direc) {
        this.direc = direc;
    }

    /**
     * *
     * Mètode abstracte que acabarem d'implementar a les classes filles
     *
     * @return Retornarà una String amb el tipus de Client amb el que tractem
     */
    public abstract String tipusClient();

    /**
     * *
     * Mètode abstracte que acabarem d'implementar a les classes filles
     *
     * @return Retornarà un float amb el càlcul del preu mensual d'un client
     */
    public abstract float calcMensual();

    /**
     * *
     * Mètode abstracte que acabarem d'implementar a les classes filles
     *
     * @return un float amb el descompte d'enviament d'un article segons el
     * tipus de client
     */
    public abstract float descompteEnv();

    /**
     * *
     * Mètode que col·loca en una String les dades dels diferents clients
     *
     * @return retorna una String amb les dades dels diferents clients
     */
    @Override
    public String toString() {
        String info = "Tipus=" + this.tipusClient() + ",Email=" + this.getCorreu() + ",Nom=" + this.getNom() + ",Adreça=" + this.getDirec()
                + ",Descompte Enviament=" + this.descompteEnv() + ".Mensualitat=" + this.calcMensual();
        return info;
    }

}