/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.Scanner;

public class EstacioEsqui {

    // crear objectes amb les classes que anem a utilitzar
    //enganxar bloc de notas i fer de forma autònoma
    String Estacio;
    LlistaPistes llistaPistes;
    LlistaRemuntadors llistaRemuntadors;
    Meteo meteo;
    int velocitatDelVent;
    String visibilitat;
    Remuntador remuntador;
    Pista pista;
    public Scanner sc = new Scanner(System.in);

    /**
     * *
     * Aquest mètode serveix per a introduir totes les dades inicials de les
     * pistes, dels remuntadors i establir les dependències
     *
     * @param llistaPistes Serveix per a poder accedir als mètodes afegirPista i
     * afegirDependencia de la classe LlistaPistes
     * @param llistaRemuntadors Serveix per a poder accedir al mètode
     * afegirRemuntador de la classe LlistaRemuntadors
     */
    public void inicialitzaDadesVall2000(LlistaPistes llistaPistes, LlistaRemuntadors llistaRemuntadors) {

        /* Remuntadors */
        Telecadira RM1 = new Telecadira("RM1", "Nord", "En Servei", 35, false);
        llistaRemuntadors.afegirRemuntador(RM1);

        Teleesqui RM2 = new Teleesqui("RM2", "Nord", "En Servei", 35, false);
        llistaRemuntadors.afegirRemuntador(RM2);

        Telecadira RM3 = new Telecadira("RM3", "Nord", "En Servei", 35, false);
        llistaRemuntadors.afegirRemuntador(RM3);

        Teleesqui RM4 = new Teleesqui("RM4", "Nord", "En Servei", 60, false);
        llistaRemuntadors.afegirRemuntador(RM4);

        Telecabina RM5 = new Telecabina("RM5", "Nord", "En Servei", 60, false);
        llistaRemuntadors.afegirRemuntador(RM5);

        cintaTransportadora RM6 = new cintaTransportadora("RM6", "Nord", "En Servei", 60, false);
        llistaRemuntadors.afegirRemuntador(RM6);

        Teleesqui RM7 = new Teleesqui("RM7", "Sud", "En Servei", 60, false);
        llistaRemuntadors.afegirRemuntador(RM7);

        Telecadira RM8 = new Telecadira("RM8", "Sud", "En Servei", 60, false);
        llistaRemuntadors.afegirRemuntador(RM8);

        Telecabina RM9 = new Telecabina("RM9", "Sud", "Fora de Servei", 60, true);
        llistaRemuntadors.afegirRemuntador(RM9);

        Teleferic RM10 = new Teleferic("RM10", "Inter-Sector", "En Servei", 60, false);
        llistaRemuntadors.afegirRemuntador(RM10);

//declarando variables del tipo de pista
// abaix creem objectes i cridem al constructor(que ens permet inicialitzar aquesta variable)
        /* Pistes */
        Pista P1 = new Pista("P1", "Nord", "Negra", 0.8f, "Dura", "Oberta");
        llistaPistes.afegirPista(P1);

        Pista P2 = new Pista("P2", "Nord", "Vermella", 1.1f, "Dura", "Oberta");
        llistaPistes.afegirPista(P2);

        Pista P3 = new Pista("P3", "Nord", "Blava", 1.8f, "Pols", "Oberta");
        llistaPistes.afegirPista(P3);

        Pista P4 = new Pista("P4", "Nord", "Vermella", 1.2f, "Dura", "Oberta");
        llistaPistes.afegirPista(P4);

        Pista P5 = new Pista("P5", "Nord", "Blava", 2.1f, "Primavera", "Oberta");
        llistaPistes.afegirPista(P5);

        Pista P6 = new Pista("P6", "Nord", "Blava", 2.9f, "Pols", "Oberta");
        llistaPistes.afegirPista(P6);

        Pista P7 = new Pista("P7", "Nord", "Verda", 1.2f, "Primavera", "Oberta");
        llistaPistes.afegirPista(P7);

        Pista P8 = new Pista("P8", "Nord", "Verda", 0.9f, "Pols", "Oberta");
        llistaPistes.afegirPista(P8);

        Pista P9 = new Pista("P9", "Sud", "Vermella", 2.1f, "Dura", "Tancada");
        llistaPistes.afegirPista(P9);

        Pista P10 = new Pista("P10", "Sud", "Negra", 0.6f, "Primavera", "Tancada");
        llistaPistes.afegirPista(P10);

        Pista P11 = new Pista("P11", "Sud", "Vermella", 1.3f, "Primavera", "Oberta");
        llistaPistes.afegirPista(P11);

        Pista P12 = new Pista("P12", "Sud", "Blava", 1.9f, "Pols", "Oberta");
        llistaPistes.afegirPista(P12);

        /* Dependencies */
//(mètode de la classe pista   ---> afegir dependència)
        P1.afegirDependencia(RM1);
        P2.afegirDependencia(RM2);
        P2.afegirDependencia(RM3);
        P3.afegirDependencia(RM5);
        P4.afegirDependencia(RM5);
        P5.afegirDependencia(RM5);
        P6.afegirDependencia(RM4);
        P7.afegirDependencia(RM5);
        P8.afegirDependencia(RM5);
        P8.afegirDependencia(RM6);
        P9.afegirDependencia(RM9);
        P10.afegirDependencia(RM9);
        P11.afegirDependencia(RM7);
        P11.afegirDependencia(RM9);
        P12.afegirDependencia(RM8);
    }

    /**
     * *
     * Constructor d'EstacióEsquí amb els atributs String estació,
     * velocitatdelVent i visibilitat
     *
     * @param Estacio atribut que contindrà el nom de l'estació d'esquí
     * @param velocitatDelVent atribut que contindrà la velocitat del vent ( en
     * km/h )
     * @param visibilitat atribut que contindrà la situació de la visibilitat (
     * Bona o Dolenta )
     */
    public EstacioEsqui(String Estacio, int velocitatDelVent, String visibilitat) {
        this.Estacio = Estacio;
        this.velocitatDelVent = velocitatDelVent;
        this.visibilitat = visibilitat;
        llistaRemuntadors = new LlistaRemuntadors();
        llistaPistes = new LlistaPistes();

    }

    /**
     * *
     * Ens serveix per a obtenir el nom de l'estació
     *
     * @return Retorna el nom de l'estació
     */
    public String getEstacio() {
        return Estacio;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el nom de l'estació
     *
     * @param Estacio Conté el nom de l'Estació
     */
    public void setEstacio(String Estacio) {
        this.Estacio = Estacio;
    }

    /**
     * *
     * Ens serveix per a obtenir el valor de la velocitat del vent
     *
     * @return Retorna el valor de la velocitat del vent
     */

    public int getVelocitatDelVent() {
        return velocitatDelVent;
    }

    /**
     * *
     * Ens serveix per a definir/assignar el valor de la velocitat del vent
     *
     * @param velocitatDelVent Conté el valor de la velocitat del vent
     *
     */
    public void setVelocitatDelVent(int velocitatDelVent) {
        this.velocitatDelVent = velocitatDelVent;
    }

    /**
     * *
     * Ens serveix per a obtenir la visibilitat (Bona o Dolenta)
     *
     * @return Retorna si la visibilitat és bona o dolenta
     */
    public String getVisibilitat() {
        return visibilitat;
    }

    /**
     * *
     *
     * Ens serveix per a definir/assignar la visibilitat
     *
     * @param visibilitat Conté el valor de la visibilitat
     */
    public void setVisibilitat(String visibilitat) {
        this.visibilitat = visibilitat;
    }

    /**
     * *
     * Mètode que serveix per a variar l'estat de la neu, d'una pista. Primer es
     * pregunta a l'usuari quina és la pista que vol modificar i un cop
     * l'entrada és vàlida li dóna a triar entre 3 opcions per a establir el nou
     * estat de la neu. Un cop triada una opció, l'estat de la neu s'actualitza
     *
     * @param llistaPistes Serveix per a poder accedir als mètodes getNom i
     * setEstatDeLNeu de la classe LlistaPistes
     */
    public void actualitzaEstatNeu(LlistaPistes llistaPistes) {
        String estatNeu;
        String nomPista;

        do {

            System.out.println("L'estat de quina pista vols modificar? ");
            nomPista = sc.nextLine();

        } while (!nomPista.equalsIgnoreCase("P1") && !nomPista.equalsIgnoreCase("P2")
                && !nomPista.equalsIgnoreCase("P3") && !nomPista.equalsIgnoreCase("P4")
                && !nomPista.equalsIgnoreCase("P5") && !nomPista.equalsIgnoreCase("P6")
                && !nomPista.equalsIgnoreCase("P7") && !nomPista.equalsIgnoreCase("P8")
                && !nomPista.equalsIgnoreCase("P9") && !nomPista.equalsIgnoreCase("P10")
                && !nomPista.equalsIgnoreCase("P11") && !nomPista.equalsIgnoreCase("P12"));

        do {
            System.out.println("Quin estat vols que tingui la neu de la "
                    + nomPista + "? Dura, Pols o Primavera?");
            estatNeu = sc.nextLine();

        } while (!estatNeu.equalsIgnoreCase("dura") && !estatNeu.equalsIgnoreCase("pols")
                && !estatNeu.equalsIgnoreCase("primavera"));

        for (int i = 0; i < llistaPistes.llista.size(); i++) {
            if (llistaPistes.llista.get(i).getNom().equalsIgnoreCase(nomPista)) {
                llistaPistes.llista.get(i).setEstatDeLaNeu(estatNeu);

            }
        }

    }

    /**
     * *
     * Mètode que serveix per a calcular el total de Kms tant de les pistes
     * obertes com de totes les pistes
     *
     * @param llistaPistes Serveix per a poder accedir al mètode
     * calculaKmsPistes de la classe LlistaPistes
     */
    public void calculaTotalKm(LlistaPistes llistaPistes) {
        System.out.println("El total de Km de  les pistes obertes és de: " + llistaPistes.calculaKmsPistes("Oberta") + "km");
        System.out.println("El total de Km de  totes les pistes és de: " + llistaPistes.calculaKmsPistes("Tots") + "km");

    }

    /**
     * *
     * Mètode que serveix per a modificar la velocitat del vent. Consta d'un
     * bucle while, que es donarà sempre i qaun l'usuari no introdueixi una
     * velocitat vàlida
     *
     * @param meteo Ens permetrà fixar la nova velovitat del vent
     */
    public void modificaVelocitatDelVent(Meteo meteo) {
        int velocitatDelVent;

        System.out.println("Quina velocitat té el vent? ");
        velocitatDelVent = sc.nextInt();
        while (velocitatDelVent < 0) {
            System.out.println("Quina velocitat té el vent? ");
            velocitatDelVent = sc.nextInt();
        }
        meteo.setVelocitatDelVent(velocitatDelVent);
    }

    /**
     * *
     *
     * Aquest mètode serveix per a modificar la visibilitat. Consta d'un bucle
     * while, que es donarà sempre i quan l'usuari no introdueixi una
     * visibilitat correcte
     *
     * @param meteo Ens permetrà fixar la nova visibilitat 
 ***
     */

    public void modificaVisibilitat(Meteo meteo) {
        String visibilitat;

        System.out.println("Quina visibilitat hi ha? Bona o Dolenta? ");
        visibilitat = sc.nextLine();
        while (!visibilitat.equalsIgnoreCase("Bona") && !visibilitat.equalsIgnoreCase("Dolenta")) {
            System.out.println("Quina visibilitat hi ha? Bona o Dolenta? ");
            visibilitat = sc.nextLine();
        }
        meteo.setVisibilitat(visibilitat);
    }

    /**
     * *
     * Aquest mètode ens redirigeix al mètode toString de la classe meteo on
     * s'indica les condicions meteorològiques actuals (és a dir, la velocitat
     * del vent i la visibilitat
     *
     * @param meteo Ens serveix per a poder accedir al mètode toString de la
     * classe Meteo
     */
    public void reportMeteo(Meteo meteo) {
        System.out.println(meteo.toString());
    }

    /**
     * *
     * Aquest mètode ens envia un missatge conforme el nostre codi ha estat
     * actualitzat. És un mètode prescindible perquè ja tenim uns altres 2
     * mètodes (els mètodes actualitzaEstat) que fan el mateix. Així que aquest
     * és només per adornar una mica el codi
     */
    public void actualitzaEstat() {
        System.out.println("Estat actualitzat!");
    }

}
