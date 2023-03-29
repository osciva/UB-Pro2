/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

/*
 *
 * @author oscar
 */
public class ClientEstandard extends Client {

    private String client = "Estandard";
    private float mes = 0.0f;
    private float descompte = 0.0f;

    /*
     * Constructor de la classe ClientEstandard al qual li entra per paràmetre
     * el correu, el nom i la direcció del client
     *
     * @param correu indica l'adreça electrònica del client
     * @param nom indica el nom del client
     * @param direc indica la direcció del client
     */
    public ClientEstandard(String correu, String nom, String direc) {
        super(correu, nom, direc);
    }

    /*
     * Mètode que retorna una String amb el tipus de client amb el que tractem
     *
     * @return Retorna una String amb el tipus de client amb el que tractem
     */
    @Override
    public String tipusClient() {
        return client;

    }

    /* *
     * Mètode que retorna un float amb el càlcul del preu mensual d'un client
     * (en aquest cas, com el client és estàndard no pagarà res)
     *
     * @return Retornarà un float amb el càlcul del preu mensual d'un client
     */
    @Override
    public float calcMensual() {
        return mes;
    }

    /**
     * *
     * Mètode que retorna un float amb el descompte per enviament d'un client
     * (en aquest cas, com el client és estàndard no tindrà cap descompte)
     *
     * @return Retornarà un float amb el descompte per enviament d'un client
     */
    @Override
    public float descompteEnv() {
        return descompte;
    }

}