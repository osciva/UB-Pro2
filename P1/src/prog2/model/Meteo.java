/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;


public class Meteo {
    
    
    
    /***
     * Constructor de Meteo amb els atributs velocitatdelVent i visibilitat
     * @param velocitatDelVent atribut que contindrà la velocitat del vent ( en km/h )
     * @param visibilitat atribut que contindrà la situació de la visibilitat ( Bona o Dolenta ) 
     */

    public Meteo(int velocitatDelVent, String visibilitat) {
        this.velocitatDelVent = velocitatDelVent;
        this.visibilitat = visibilitat;
    }

    private int velocitatDelVent;
    private String visibilitat;

    /***
 * Ens serveix per a obtenir el valor de la velocitat del vent
 * @return Retorna el valor de la velocitat del vent
 */
    public float getVelocitatDelVent() {
        return velocitatDelVent;
    }
/***
 * Ens serveix per a definir/assignar el valor de la velocitat del vent
 * @param velocitatDelVent Conté el valor de la velocitat del vent
 * 
 */
    public void setVelocitatDelVent(int velocitatDelVent) {
        this.velocitatDelVent = velocitatDelVent;
    }
/***
 * Ens serveix per a obtenir la velocitat (Bona o Dolenta)
 * @return Retorna si la visibilitat és bona o dolenta
 */
    public String getVisibilitat() {
        return visibilitat;
    }
/***
 * 
 * Ens serveix per a definir/assignar la visibilitat

 * @param visibilitat Conté el valor de la visibilitat
 */
    public void setVisibilitat(String visibilitat) {
        this.visibilitat = visibilitat;
    }

/***
 * Mètode que col·loca en una String les condicions meteorològiques actuals
 * @return Això retorna una String amb les condicions meteorològiques actuals
 */
    public String toString() {
        String condicions = "Hi ha un vent de " + velocitatDelVent + " km/h i una"
                + " visibilitat " + visibilitat;
        return condicions;
    }

}
