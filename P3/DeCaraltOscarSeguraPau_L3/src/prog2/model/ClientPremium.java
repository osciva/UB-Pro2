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
public class ClientPremium extends Client {

    private String client = "Premium";
    private float mes = 4.0f;
    private float descompte = 20.0f;

    /*
     * Constructor de la classe ClientPremium al qual li entra per paràmetre el
     * correu, el nom i la direcció del client
     *
     * @param correu indica l'adreça electrònica del client
     * @param nom indica el nom del client
     * @param direc indica la direcció del client
     */
    public ClientPremium(String correu, String nom, String direc) {
        super(correu, nom, direc);

        /*
         * Mètode que retorna una String amb el tipus de client amb el que
         * tractem
         *
         * @return Retorna una String amb el tipus de client amb el que tractem
         */
    }

    @Override
    public String tipusClient() {
        return client;
    }

    /*
     * *
     * Mètode que retorna un float amb el càlcul del preu mensual d'un client
     * (en aquest cas, com el client és premium pagarà 4€/mes)
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
     * (en aquest cas, com el client és premium tindrà un 20% de descompte en
     * qualsevol tipus d'enviament)
     *
     * @return Retornarà un float amb el descompte per enviament d'un client
     */
    @Override
    public float descompteEnv() {
        return descompte;
    }

}