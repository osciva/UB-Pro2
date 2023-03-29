/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.controlador;

import prog2.model.Dades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import prog2.vista.MercatException;

/**
 *
 * @author oscar
 */
public class Controlador implements Serializable {

    Dades dades = new Dades();

    public Controlador() {

    }

    /**
     * Mètode per a preguntar a l'usuari les dades de l'Article que vol afegir a
     * l'ArrayList
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws MercatException
     */
    public void afegirArticle(Scanner sc) throws MercatException {
        System.out.println("Quin codi té l'article?");
        String codi = sc.next();
        System.out.println("Com es diu l'article?");
        String nom = sc.next();
        System.out.println("Quin és el seu preu?");
        float preu = sc.nextFloat();
        System.out.println("Admet urgent(true or false)?");
        boolean urgent = sc.nextBoolean();
        System.out.println("Quant trigarà en arribar l'article?");
        int mins = sc.nextInt();
        dades.afegirArticle(codi, nom, preu, mins, urgent);

    }

    /**
     * Mètode per a mostrar per pantalla els Articles
     */
    public void mostraArticles() {
        for (int i = 0; i < dades.getLlista().getSize(); i++) {
            System.out.println(dades.getLlista().getAt(i).toString());

        }

    }

    /**
     * Mètode per a preguntar a l'usuari les dades del client que vol afegir a
     * l'ArrayList
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws MercatException
     */
    public void afegirClient(Scanner sc) throws MercatException {
        System.out.println("Quin nom té el client?");
        String nom = sc.nextLine();
        System.out.println("Quina adreça electrònica te el client?");
        String correu = sc.nextLine();
        System.out.println("On viu aquest client?");
        String direc = sc.nextLine();
        System.out.println("Aquest client és premium(true or false)?");
        boolean prem = sc.nextBoolean();
        dades.afegirClient(correu, nom, direc, prem);

    }

    /**
     * Mètode per a mostrar per pantalla els Clients
     */
    public void mostraClients() {
        for (int i = 0; i < dades.getLlistaclients().getSize(); i++) {
            System.out.println(dades.getLlistaclients().getAt(i).toString());

        }
    }

    /**
     * Mètode per a preguntar a l'usuari les dades de la comanda que vol afegir
     * a l'ArrayList
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws MercatException
     */
    public void afegirComanda(Scanner sc) throws MercatException { //posart,posclient,quant,esUrgent
        System.out.println("Quina posició a la llista té l'article?");
        int posArt = sc.nextInt();
        posArt -= 1;
        System.out.println("Quina posició a la llista te el client?");
        int posClient = sc.nextInt();
        posClient -= 1;
        System.out.println("Quants articles demanes?");
        int quant = sc.nextInt();
        System.out.println("La comanda és urgent(true or false)?");
        boolean urg = sc.nextBoolean();
        dades.afegirComanda(posArt, posClient, quant, urg);

    }

    /**
     * Mètode per a esborrar una comanda de l'ArrayList si s'indica la posició
     * d'aquesta
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws prog2.vista.MercatException
     */
    public void esborrarComandes(Scanner sc) throws MercatException {
        System.out.println("Quina posició te a la llista la comanda que vols esborrar?");
        int pos = sc.nextInt();
        pos -= 1;
        dades.esborrarComanda(pos);

    }

    /**
     * Mètode per a mostrar per pantalla les Comandes
     */
    public void mostraComandes() {
        for (int i = 0; i < dades.recuperaComandes().size(); i++) {
            System.out.println(dades.recuperaComandes().get(i));

        }

    }

    /**
     * Mètode per a mostrar per pantalla les Comandes Urgents
     */
    public void mostraUrgents() {
        for (int i = 0; i < dades.recuperaComandesUrgents().size(); i++) {
            System.out.println(dades.recuperaComandesUrgents().get(i));

        }
    }

    /**
     * Mètode per a guardar les dades a un fitxer Controlador.dat
     *
     * @throws MercatException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void guarda() throws MercatException, FileNotFoundException, IOException, ClassNotFoundException {
        dades.guardaDades("./Controlador.dat");

    }

    /**
     * Mètode per a carregar les dades guardades anteriorment en el fitxer
     * Controlador.dat
     *
     * @throws MercatException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void carregaDades() throws MercatException, IOException, ClassNotFoundException {

        dades = Dades.carregaDades("./Controlador.dat");

    }
}
