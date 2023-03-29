/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import prog2.controlador.Controlador;
import prog2.model.Dades;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class MercatUB implements Serializable {

    Scanner sc = new Scanner(System.in);
    Controlador controlador = new Controlador();
    Dades dades = new Dades();

    /**
     * Mètode per gesdtionar el clubUB
     *
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws MercatException
     */
    public void gestioMercat() throws ClassNotFoundException, MercatException, IOException {
        // Creación de un objeto para leer el input desde el teclado

        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }

    /**
     * Mètode per a enumerar les opcions del menú principal
     */
    private static enum OpcionesMenu {
        M_Opcion_1_GestioArticles,
        M_Opcion_2_GestioClients,
        M_Opcion_3_GestioComandes,
        M_Opcion_4_GuardarDades,
        M_Opcion_5_CarregarDades,
        M_Opcion_6_Sortir

    };

    /**
     * Mètode per a enumerar les opcions del submenú
     */
    private static enum OpcionesMenu2 {

        M_Opcion_1_AfegirArticles,
        M_Opcion_2_VisualitzarArticles,
        M_Opcion_3_Sortir

    };

    private static enum OpcionesMenu3 {
        M_Opcion_1_AfegirClient,
        M_Opcion_2_VisualitzarClients,
        M_Opcion_3_Sortir

    };

    private static enum OpcionesMenu4 {
        M_Opcion_1_AfegirComanda,
        M_Opcion_2_EsborrarComanda,
        M_Opcion_3_VisualitzarComandes,
        M_Opcion_4_VisualitzarComandesUrgents,
        M_Opcion_5_Sortir

    };
    /**
     * Mètode per a descriure les opcions del menú principal
     */
    private static final String[] descMenu = {
        "Gestió articles",
        "Gestió clients",
        "Gestió comandes",
        "Guardar dades",
        "Carregar dades",
        "Sortir"

    };
    /**
     * Mètode per a descriure les opcions del submenú
     */
    private static final String[] descMenu2 = {
        "Afegir article",
        "Visualitzar articles",
        "Sortir"

    };
    private static final String[] descMenu3 = {
        "Afegir client",
        "Visualitzar clients",
        "Sortir"

    };
    private static final String[] descMenu4 = {
        "Afegir comanda",
        "Esborrar comanda",
        "Visualitzar comandes",
        "Visualitzar comandes urgents",
        "Sortir"

    };

    /**
     * Mètode per a gestionar el menú principal
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws MercatException
     */
    private void gestioMenu(Scanner sc) throws ClassNotFoundException, IOException, MercatException {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuMercat = new Menu<>("Menu mercat", OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuMercat.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuMercat.mostrarMenu();
            opcionMenu = menuMercat.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_GestioArticles:
                    gestioMenu2(sc);
                    break;
                case M_Opcion_2_GestioClients:
                    gestioMenu3(sc);

                    break;
                case M_Opcion_3_GestioComandes:
                    gestioMenu4(sc);

                    break;
                case M_Opcion_4_GuardarDades:
                    controlador.guarda();

                    break;
                case M_Opcion_5_CarregarDades:
                    controlador.carregaDades();

                    break;
                case M_Opcion_6_Sortir:

                    break;

            }

        } while (opcionMenu != OpcionesMenu.M_Opcion_6_Sortir);
    }

    /**
     * Mètode per a gestionar el submenú
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws MercatException
     */
    private void gestioMenu2(Scanner sc) throws MercatException {
        Menu<OpcionesMenu2> menuMercat = new Menu<>("Menu mercat", OpcionesMenu2.values());
        menuMercat.setDescripcions(descMenu2);
        OpcionesMenu2 opcionMenu2;

        do {
            menuMercat.mostrarMenu();
            opcionMenu2 = menuMercat.getOpcio(sc);

            switch (opcionMenu2) {
                case M_Opcion_1_AfegirArticles:
                    controlador.afegirArticle(sc);
                    break;
                case M_Opcion_2_VisualitzarArticles:
                    controlador.mostraArticles();

                    break;
                case M_Opcion_3_Sortir:

                    break;

            }
        } while (opcionMenu2 != OpcionesMenu2.M_Opcion_3_Sortir);

    }

    /**
     * Mètode per a gestionar el submenú
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws MercatException
     */
    private void gestioMenu3(Scanner sc) throws MercatException {
        Menu<OpcionesMenu3> menuMercat = new Menu<>("Menu Mercat", OpcionesMenu3.values());
        menuMercat.setDescripcions(descMenu3);
        OpcionesMenu3 opcionMenu3;

        do {
            menuMercat.mostrarMenu();
            opcionMenu3 = menuMercat.getOpcio(sc);

            switch (opcionMenu3) {
                case M_Opcion_1_AfegirClient:
                    controlador.afegirClient(sc);

                    break;
                case M_Opcion_2_VisualitzarClients:
                    controlador.mostraClients();

                    break;
                case M_Opcion_3_Sortir:

                    break;

            }
        } while (opcionMenu3 != OpcionesMenu3.M_Opcion_3_Sortir);

    }

    /**
     * Mètode per a gestionar el submenú
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws MercatException
     */
    private void gestioMenu4(Scanner sc) throws MercatException {
        Menu<OpcionesMenu4> menuMercat = new Menu<>("Menu Mercat", OpcionesMenu4.values());
        menuMercat.setDescripcions(descMenu4);
        OpcionesMenu4 opcionMenu4;

        do {
            menuMercat.mostrarMenu();
            opcionMenu4 = menuMercat.getOpcio(sc);

            switch (opcionMenu4) {
                case M_Opcion_1_AfegirComanda:
                    controlador.afegirComanda(sc);

                    break;
                case M_Opcion_2_EsborrarComanda:
                    controlador.esborrarComandes(sc);

                    break;
                case M_Opcion_3_VisualitzarComandes:
                    controlador.mostraComandes();

                    break;
                case M_Opcion_4_VisualitzarComandesUrgents:
                    controlador.mostraUrgents();
                    break;

                case M_Opcion_5_Sortir:
                    break;

            }
        } while (opcionMenu4 != OpcionesMenu4.M_Opcion_5_Sortir);

    }
}