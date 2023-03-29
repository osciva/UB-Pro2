/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import prog2.vista.MercatException;
import java.util.*;

/**
 *
 * @author oscar
 */
public class Dades implements InDades, Serializable {

    private LlistaArticles llista = new LlistaArticles();
    private LlistaClients llistaclients = new LlistaClients();
    private LlistaComandes llistacomandes = new LlistaComandes();

    /**
     * *
     * Ens serveix per a obtenir la Llista d'Articles
     *
     * @return Retorna la Llista d'Articles
     *
     */
    public LlistaArticles getLlista() {
        return llista;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la Llista d'Articles
     *
     * @param llista Conté la Llista d'Articles
     */
    public void setLlista(LlistaArticles llista) {
        this.llista = llista;
    }

    /**
     * *
     * Ens serveix per a obtenir la Llista de clients
     *
     * @return Retorna la Llista de clients
     *
     */
    public LlistaClients getLlistaclients() {
        return llistaclients;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la Llista de clients
     *
     * @param llistaclients Conté la Llista de clients
     */
    public void setLlistaclients(LlistaClients llistaclients) {
        this.llistaclients = llistaclients;
    }

    /**
     * *
     * Ens serveix per a obtenir la Llista de comandes
     *
     * @return Retorna la Llista de comandes
     *
     */
    public LlistaComandes getLlistacomandes() {
        return llistacomandes;
    }

    /**
     * *
     * Ens serveix per a definir/assignar la Llista de comandes
     *
     * @param llistacomandes Conté la Llista de comandes
     */
    public void setLlistacomandes(LlistaComandes llistacomandes) {
        this.llistacomandes = llistacomandes;
    }

    /**
     * Aquest mètode permet afegir un article a un arrayList si es pasen per
     * paràmtre les dades d'aquest
     *
     * @param id Indica l'identificador de l'article
     * @param nom Indica el nom de l'article
     * @param preu Indica el preu de l'article
     * @param temps Indica el temps per entregar l'article
     * @param admetUrgent Indica si l'article pot tenir una entrega urgent
     * @throws prog2.vista.MercatException
     */
    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        Articles a = new Articles(id, nom, preu, admetUrgent, temps);
        try {
            if (llista.contains(a)) {
                throw new MercatException();
            } else {
                llista.afegir(a);
            }
        } catch (MercatException e) {

            System.out.println("ERROR MERCATEXCEPTION: Aquest article ja és a la llista");
        }

    }

    /**
     * Aquest mètode permet recuperar els Articles
     *
     * @return Retorna una llista de Strings
     */
    @Override
    public List<String> recuperaArticles() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < llista.getSize(); i++) {

            lista.add(llista.getAt(i).toString() + "\n");

        }
        return lista;
    }

    /**
     * Aquest mètode permet afegir un client a un arrayList si es pasen per
     * paràmtre les dades d'aquest
     *
     * @param email Indica l'adreça electrònica del client
     * @param nom Indica el nom electrònica del client
     * @param adreca Indica l'adreça/direcció del client
     * @param esPremium Indica si el client és premium o no
     * @throws prog2.vista.MercatException
     */
    @Override
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {

        try {
            if (esPremium) {
                Client client = new ClientPremium(email, nom, adreca);
                //llistaclients.afegir(client);
                if (llistaclients.contains(client)) {
                    throw new MercatException();

                } else {
                    llistaclients.afegir(client);
                }

            } else {
                Client client = new ClientEstandard(email, nom, adreca);
                //llistaclients.afegir(client);
                if (llistaclients.contains(client)) {
                    throw new MercatException();
                } else {
                    llistaclients.afegir(client);
                }
            }

        } catch (MercatException e) {

            System.out.println("ERROR MERCATEXCEPTION: Aquest client ja és a la llista");
        }

    }

    /**
     * Aquest mètode permet recuperar els clients
     *
     * @return Retorna una llista de Strings
     */
    @Override
    public List<String> recuperaClients() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < llistaclients.getSize(); i++) {

            lista.add(llistaclients.getAt(i).toString());

        }
        return lista;
    }

    /**
     * Aquest mètode permet afegir una comanda a un arrayList si es pasen per
     * paràmtre les dades d'aquesta
     *
     * @param articlePos Indica la posició de l'Article
     * @param clientPos Indica la posició del client
     * @param quantitat Indica la quantitat d'articles
     * @param esUrgent Indica si la comanda és urgent o no
     * @throws prog2.vista.MercatException
     * @throws IndexOutOfBoundsException
     */
    @Override

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException, IndexOutOfBoundsException {

        try {
            if (((articlePos + 1) > llista.getSize()) || ((clientPos + 1) > llistaclients.getSize())) {
                throw new IndexOutOfBoundsException();
            } else {
                Articles a = llista.getAt(articlePos);
                Client c = llistaclients.getAt(clientPos);

                Date data = new Date();

                if (esUrgent) {
                    Comanda comanda = new ComandaUrgent(a, c, quantitat, data);
                    if (!llistacomandes.urgent(comanda)) {
                        throw new MercatException();
                    } else {
                        llistacomandes.afegir(comanda);
                    }
                } else {
                    Comanda co = new ComandaNormal(a, c, quantitat, data);
                    llistacomandes.afegir(co);

                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR INDEXOUTOFBOUNDSEXCEPTION: La posició és major que la mida de la llista");

        } catch (MercatException e) {
            System.out.println("ERROR MERCATEXCEPTION Aquest article no admet urgent i no es pot afegir a la llista de comandes urgents");

        }
    }

    /**
     * Aquest mètode permet eliminar una comanda si s'indica la posició on es
     * troba la comanda
     *
     * @param position indica la posició on es troba la comanda
     * @throws prog2.vista.MercatException
     *
     */
    @Override

    public void esborrarComanda(int position) throws MercatException {
        try {
            if (llistacomandes.isEmpty()) {
                throw new MercatException();
            } else {
                for (int i = 0; i < llistacomandes.getSize(); i++) {
                    if (i == position) {
                        llistacomandes.esborrar(llistacomandes.getAt(i));
                    }
                }
            }
        } catch (MercatException e) {
            System.out.println("ERROR MERCATEXCEPTION: La llista està buida");
        }
    }

    /**
     * Aquest mètode permet recuperar una comanda (tant normal com urgent)
     *
     * @return Retorna una llista de Strings *
     */
    @Override
    public List<String> recuperaComandes() {

        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < llistacomandes.getSize(); i++) {

            lista.add(llistacomandes.getAt(i).toString());

        }
        return lista;
    }

    /**
     * Aquest mètode permet recuperar una comanda urgent
     *
     * @return Retorna una llista de Strings *
     */
    @Override
    public List<String> recuperaComandesUrgents() {

        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < llistacomandes.getSize(); i++) {
            if (llistacomandes.getAt(i).tipusComanda().equalsIgnoreCase("Urgent")) {
                lista.add(llistacomandes.getAt(i).toString());
            }

        }
        return lista;
    }

    /**
     * Mètode que ens serveix per a guardar les dades en un fitxer .txt
     *
     * @param camiDesti Conté el nom del fitxer .txt
     * @throws FileNotFoundException
     * @throws prog2.vista.MercatException
     * @throws IOException
     * @throws java.lang.ClassNotFoundException
     */
    public void guardaDades(String camiDesti) throws MercatException, FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File(camiDesti);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fitxer = new FileOutputStream(file);
            oos = new ObjectOutputStream(fitxer);
            oos.writeObject(this);
            oos.flush();
        } catch (IOException msg) {
            throw new MercatException("Problema amb l'entrada de dades");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException msg) {
                    throw new MercatException("Problema amb la sortida de dades");
                }

            }
        }

    }

    /**
     * Mètode que ens serveix per a carregar les dades guardades prèviament en
     * el fitxer .txt
     *
     * @param camiOrigen Conté el nom del fitxer .txt
     * @return retorna la informació guardada en el fitxer
     * @throws prog2.vista.MercatException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     */
    public static Dades carregaDades(String camiOrigen) throws MercatException, IOException, ClassNotFoundException {
        File file = new File(camiOrigen);
        Dades d = null;
        FileInputStream fitxer;
        ObjectInputStream ois = null;

        try {
            fitxer = new FileInputStream(file);
            ois = new ObjectInputStream(fitxer);
            d = (Dades) ois.readObject();
        } catch (FileNotFoundException msg) {
            throw new MercatException("No existeix el fitxer");
        } catch (ClassNotFoundException msg) {
            throw new MercatException("No s'ha trobat el fitxer");
        } catch (IOException msg) {
            throw new MercatException("Problema amb l'entrada/sortida de dades");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException msg) {
                    throw new MercatException("Problema al tancar el fitxer");
                }
            }
        }
        return d;
    }
}
