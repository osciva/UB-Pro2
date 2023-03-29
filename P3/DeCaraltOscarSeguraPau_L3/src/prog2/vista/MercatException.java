/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;


public class MercatException extends Exception  {

    static final long serialVesrionUID = 2892432329053792L;

    /**
     * Constructor per defecte de la classe MercatException
     */
    public MercatException() {
        super();
    }

    /**
     *
     * Constructor amb paràmetres de la classe MercatException
     *
     * @param msg Conté el nom de l'error
     */
    public MercatException(String msg) {
        super(msg);
    }

}