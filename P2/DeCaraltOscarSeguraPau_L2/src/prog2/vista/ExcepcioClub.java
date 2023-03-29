/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;


public class ExcepcioClub extends Exception  {

    static final long serialVesrionUID = 2892432329053792L;

    /**
     * Constructor per defecte de la classe ExcepcioClub
     */
    public ExcepcioClub() {
        super();
    }

    /**
     *
     * Constructor amb paràmetres de la classe ExcepcioClub
     *
     * @param msg Conté el nom de l'error
     */
    public ExcepcioClub(String msg) {
        super(msg);
    }

}
