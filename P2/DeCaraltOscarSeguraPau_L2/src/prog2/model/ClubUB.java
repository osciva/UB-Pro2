/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.*;

import java.io.*;
import prog2.vista.ExcepcioClub;

public class ClubUB implements Serializable {

    private LlistaSocis llistasc = new LlistaSocis(100);
    private final float quotaBase = 25f;
    private final float preuExcursioBase = 20f;
    private float descompteExcursio = 0.2f;
    private float descompteQuota = 0.3f;
    Asseguranca asseguranca;
    SociEstandard sociEstandard;

    /**
     * Constructor per defecte de la classe ClubUB
     *
     *
     */
    public ClubUB() {

    }

    /**
     *
     * Mètode que permet afegir Socis Juniors si es dóna el nom i el DNI
     * d'aquest. Sempre i quan aquest no hagi estat registrat anteriorment.
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void afegirSociJunior(Scanner sc) throws ExcepcioClub {
        try {

            if (llistasc.isFull()) {
                throw new ExcepcioClub();
            } else {
                System.out.println("Com es diu? ");
                String nomSoci = sc.next();
                System.out.println("Quin és el seu DNI? ");
                String dniSoci = sc.next();

                Soci sociJunior = new SociJunior(nomSoci, dniSoci);

                if (llistasc.iguals(sociJunior)) {
                    System.out.println("Soci ja existent, Introdueix un nou soci...");
                } else {

                    llistasc.addSoci(sociJunior);
                }
            }
        } catch (ExcepcioClub plena) {
            throw new ExcepcioClub("la llista està plena");
        }

    }

    /**
     * *
     * Mètode que permet afegir Socis Federats si es dóna el nom, el DNI, el nom
     * de la federació, el preu de la federació, els descomptes en la quota
     * mensual i el descompte en les excursions. Sempre i quan aquest no hagi
     * estat registrat anteriorment
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void afegirSociFederat(Scanner sc) throws ExcepcioClub {
        try {

            if (llistasc.isFull()) {
                throw new ExcepcioClub("La llista està plena");
            } else {
                System.out.println("Com es diu? ");
                String nomSoci = sc.next();
                System.out.println("Quin és el seu DNI? ");
                String dniSoci = sc.next();
                System.out.println("Com es dirà la federacio? ");
                String nomFederacio = sc.next();
                System.out.println("Quin serà el preu de la federacio? ");
                float preuFede = sc.nextFloat();
                if (preuFede < 100) {
                    throw new ExcepcioClub("El preu és menor de 100");
                } else {

                    Soci sociFede = new SociFederat(nomSoci, dniSoci, preuFede, nomFederacio);

                    if (llistasc.iguals(sociFede)) {
                        System.out.println("Soci ja existent, Introdueix un nou soci...");

                    } else {
                        llistasc.addSoci(sociFede);
                    }
                }
            }
        } catch (ExcepcioClub plena) {
            throw new ExcepcioClub("No s'ha pogut afegir el soci");
        }

    }

    /**
     * *
     * Mètode que permet afegir Socis Estandard si es dóna el nom, el DNI, el
     * tipus d'assegurança i el preu de l'assegurança. Sempre i quan aquest no
     * hagi estat registrat anteriorment
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void afegirSociEstandard(Scanner sc) throws ExcepcioClub {
        try {
            if (llistasc.isFull()) {
                throw new ExcepcioClub("La llista està plena");
            } else {
                System.out.println("Com es diu? ");
                String nomSoci = sc.next();
                System.out.println("Quin és el seu DNI? ");
                String dniSoci = sc.next();
                System.out.println("Quin tipus d'assegurança tindrà? ");
                String tipusAssegurança = sc.next();
                if (!tipusAssegurança.equalsIgnoreCase("Basica") && !tipusAssegurança.equalsIgnoreCase("Completa")) {
                    throw new ExcepcioClub("La assegurança no és del tipus correcte");
                } else {
                    System.out.println("Quin serà el preu de l'assegurança? ");
                    float preuAsse = sc.nextFloat();

                    Soci sociEst = new SociEstandard(nomSoci, dniSoci, tipusAssegurança, preuAsse);

                    if (llistasc.iguals(sociEst)) {
                        System.out.println("Soci ja existent, Introdueix un nou soci...");

                    } else {
                        llistasc.addSoci(sociEst);
                    }
                }
            }
        } catch (ExcepcioClub plena) {
            throw new ExcepcioClub("No s'ha pogut afegir el soci");
        }

    }

    /**
     * Mètode per a imprimir l'ArrayList amb els socis
     */
    public void mostraSocis() {
        System.out.println(llistasc.llistarSocis());

    }

    /**
     * *
     * Mètode que permet eliminar Socis si es dóna el DNI del soci que es vol
     * eliminar. Sempre i quan hagi estat registrat anteriorment
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void eliminaSoci(Scanner sc) throws ExcepcioClub {
        try {
            boolean esta = false;
            if (llistasc.isEmpty()) {

                throw new ExcepcioClub("La llista està buida");
            } else {
                System.out.println("Digue's el DNI del soci que vols eliminar");
                String dniSoci = sc.next();
                for (int i = 0; i < llistasc.getSize(); i++) {

                    if (dniSoci.equals(llistasc.getAt(i).getDNI())) {
                        llistasc.removeSoci(llistasc.getAt(i));
                        esta = true;

                    }
                }
                if (esta == false) {
                    throw new ExcepcioClub("Aquest soci no és a la llista");
                }
            }
        } catch (ExcepcioClub buida) {

            throw new ExcepcioClub("No s'ha pogut eliminar el soci");
        }

    }

    /**
     * *
     * Mètode que permet modificar el nom dels Socis si es dóna el DNI del soci
     * al qual volem aplicar la modificació. Sempre i quan hagi estat registrat
     * anteriorment
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void modificaSoci(Scanner sc) throws ExcepcioClub {
        try {
            boolean esta = false;
            if (llistasc.isEmpty()) {

                throw new ExcepcioClub("La llista està buida");
            } else {
                System.out.println("Digue's el DNI del soci al que vols modificar el nom");
                String dniSoci = sc.next();
                for (int i = 0; i < llistasc.getSize(); i++) {
                    if (dniSoci.equals(llistasc.getAt(i).getDNI())) {
                        System.out.println("Com es diu ara el soci?");
                        String newNom = sc.next();
                        llistasc.getAt(i).setNom(newNom);
                        esta = true;
                    }

                }
                if (esta == false) {
                    throw new ExcepcioClub("Aquest soci no és a la llista");
                }
            }
        } catch (ExcepcioClub buida) {

            throw new ExcepcioClub("No s'ha pogut modificar el nom del soci");
        }

    }

    /**
     * *
     * Mètode que permet modificar l'assegurança dels Socis si es dóna el DNI
     * del soci al qual volem aplicar la modificació. Sempre i quan hagi estat
     * registrat anteriorment
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void modificaAsseguranca(Scanner sc) throws ExcepcioClub {

        try {
            boolean esta = false;
            if (llistasc.isEmpty()) {

                throw new ExcepcioClub("La llista està buida");
            } else {
                System.out.println("Digue's el DNI del soci al que vols canviar l'assegurança");
                String dniSoci = sc.next();
                for (int i = 0; i < llistasc.getSize(); i++) {
                    if (dniSoci.equals(llistasc.getAt(i).getDNI())) {
                        esta = true;
                        if (llistasc.getAt(i) instanceof SociEstandard) {
                            SociEstandard sociEst = (SociEstandard) llistasc.getAt(i);

                            System.out.println("Quina assegurança vols adquirir(Completa o Basica)?");
                            String tipus = sc.next();
                            if (!tipus.equalsIgnoreCase("Basica") && !tipus.equalsIgnoreCase("Completa")) {
                                throw new ExcepcioClub(" Assegurança no valida. Ha de ser Basica o Completa");
                            }
                            sociEst.asseguranca.setTipus(tipus);

                        }

                    }

                }
                if (esta == false) {
                    throw new ExcepcioClub("Aquest soci no hi és a la llista");

                }
            }
        } catch (ExcepcioClub buida) {

            throw new ExcepcioClub("No s'ha pogut canviar l'assegurança");

        }
    }

    /**
     * Mètode que ens permet calcular el que un soci ha de pagar a final de mes,
     * depenent del tipus de soci que sigui i de les excursions que hagi
     * realitzat.
     *
     * @param dni Conté el DNI del soci al qual es vol calcular la factura
     * @param numExcursions Conté la quantitat d'excursions realitzades pel soci
     * al llarg del mes
     * @return retorna un float amb la quantitat a diners que el soci ha de
     * pagar
     * @throws prog2.vista.ExcepcioClub
     */
    public float mostraFactura(String dni, int numExcursions) throws ExcepcioClub {

        try {
            boolean esta = false;
            if (llistasc.isEmpty()) {

                throw new ExcepcioClub("La llista està buida");
            } else {

                float factura = 0;
                for (int i = 0; i < llistasc.getSize(); i++) {
                    if (dni.equals(llistasc.getAt(i).getDNI())) {
                        factura = llistasc.getAt(i).calculaPreuExcursio(preuExcursioBase) * numExcursions + llistasc.getAt(i).calculaQuota(quotaBase);
                        System.out.println("El soci amb DNI " + llistasc.getAt(i).getDNI() + " ha de pagar " + factura + " euros.");
                        esta = true;
                    }
                }
                if (esta == false) {
                    throw new ExcepcioClub("Aquest soci no hi és a la llista");
                }
                return factura;
            }

        } catch (ExcepcioClub buida) {

            throw new ExcepcioClub("No s'ha pogut mostrar la factura");

        }

    }

    /**
     * Mètode que ens serveix per a guardar les dades(ClubUB) en un fitxer .txt
     *
     * @param nomFitxer Conté el nom del fitxer .txt
     * @param club Conté l'ArrayList amb els socis
     * @throws FileNotFoundException
     * @throws prog2.vista.ExcepcioClub
     * @throws IOException
     */
    public void guardar(String nomFitxer, ClubUB club) throws ExcepcioClub, IOException {

        File file = new File(nomFitxer);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fitxer = new FileOutputStream(file);
            oos = new ObjectOutputStream(fitxer);
            oos.writeObject(club);
            oos.flush();
        } catch (IOException msg) {
            throw new ExcepcioClub("Problema amb l'entrada de dades");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                }catch(IOException msg){
                    throw new ExcepcioClub("Problema amb la sortida de dades");
                }

            }
        }

    }

    /**
     * Mètode que ens serveix per a carregar les dades guardades prèviament en
     * el fitxer .txt
     *
     * @param nomFitxer Conté el nom del fitxer .txt
     * @return retorna la informació guardada en el fitxer
     * @throws prog2.vista.ExcepcioClub
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     */
    public static ClubUB carregar(String nomFitxer) throws ExcepcioClub, IOException, ClassNotFoundException, FileNotFoundException {
       File file = new File(nomFitxer);
       ClubUB clubUB = null;
       FileInputStream fitxer;
       ObjectInputStream ois = null;
       
       try{
           fitxer = new FileInputStream(file);
           ois = new ObjectInputStream(fitxer);
           clubUB = (ClubUB) ois.readObject();
       }catch (FileNotFoundException msg){
           throw new ExcepcioClub("No existeix el fitxer");
       }catch(ClassNotFoundException msg){
           throw new ExcepcioClub("No s'ha trobat el fitxer");
       }catch (IOException msg){
           throw new ExcepcioClub("Problema amb l'entrada/sortida de dades");
       }finally{
           if (ois != null){
               try{
                   ois.close();
               }catch (IOException msg){
                   throw new ExcepcioClub("Problema al tancar el fitxer");
               }
           }
       }
        return clubUB;

    }

    /**
     * Mètode per a afavorir l'encapsulament del menú
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void imprimirOpcio4(Scanner sc) throws ExcepcioClub {
        try {

            System.out.println("Digue's el DNI del soci que vols mostrar la factura");
            String dni = sc.next();
            System.out.println("Quantes excursions ha fet?");
            int numExcursions = sc.nextInt();
            if (numExcursions < 0 || numExcursions > 31) {
                throw new ExcepcioClub();
            }
            mostraFactura(dni, numExcursions);
        } catch (ExcepcioClub excursions) {

            throw new ExcepcioClub("Nombre d'excursions no vàlid. Ha de ser major que 0 i menor que 31");

        }
    }
}
