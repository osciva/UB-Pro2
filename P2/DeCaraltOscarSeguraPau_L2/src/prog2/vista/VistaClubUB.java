/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.*;
import prog2.model.ClubUB;
import java.io.IOException;
import java.io.Serializable;

public class VistaClubUB implements Serializable {

    ClubUB club = new ClubUB();
    Scanner sc = new Scanner(System.in);

    /**
     * Mètode per gesdtionar el clubUB
     *
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws ExcepcioClub
     */
    public void gestioClub() throws ClassNotFoundException, IOException, ExcepcioClub {
        // Creación de un objeto para leer el input desde el teclado

        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }

    /**
     * Mètode per a enumerar les opcions del menú principal
     */
    private static enum OpcionesMenu {
        M_Opcion_1_DonarAltaSoci,
        M_Opcion_2_Mostrar,
        M_Opcion_3_Eliminar,
        M_Opcion_4_MostraFactura,
        M_Opcion_5_ModificaNomSoci,
        M_Opcion_6_ModificarAsseguranca,
        M_opcion_7_GuardarLlista,
        M_opcion_8_RecuperarLlista,
        M_opcion_9_Sortir

    };

    /**
     * Mètode per a enumerar les opcions del submenú
     */
    private static enum OpcionesMenu2 {

        M_Opcion_1_SociFederat,
        M_Opcion_2_SociEstandard,
        M_Opcion_3_SociJunior,
        M_Opcion_4_Menu

    };
    /**
     * Mètode per a descriure les opcions del menú principal
     */
    private static final String[] descMenu = {
        "Donar d’alta un nou soci",
        "Mostrar llista de socis",
        "Eliminar soci",
        "Mostrar factura",
        "Modificar nom soci",
        "Modificar tipus assegurança soci",
        "Guardar llista",
        "Recuperar llista",
        "Sortir"

    };
    /**
     * Mètode per a descriure les opcions del submenú
     */
    private static final String[] descMenu2 = {
        "Afegir soci federat.",
        "Afegir soci estandard",
        "Afegir soci junior",
        "Tornar al menú anterior"

    };

    /**
     * Mètode per a gestionar el menú principal
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ExcepcioClub
     */
    public void gestioMenu(Scanner sc) throws IOException, ClassNotFoundException, ExcepcioClub {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuClub = new Menu<>("Menu club", OpcionesMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuClub.setDescripcions(descMenu);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;

        // Lanzar el bucle principal de la aplicación
        do {
            menuClub.mostrarMenu();
            opcionMenu = menuClub.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_DonarAltaSoci:
                    gestioMenu2(sc);
                    break;
                case M_Opcion_2_Mostrar:
                    club.mostraSocis();
                    break;
                case M_Opcion_3_Eliminar:
                    club.eliminaSoci(sc);
                    break;
                case M_Opcion_4_MostraFactura:
                    club.imprimirOpcio4(sc);
                    break;
                case M_Opcion_5_ModificaNomSoci:
                    club.modificaSoci(sc);
                    break;
                case M_Opcion_6_ModificarAsseguranca:
                    club.modificaAsseguranca(sc);
                    break;
                case M_opcion_7_GuardarLlista:
                    club.guardar("./Llistasocis.dat", club);
                    break;
                case M_opcion_8_RecuperarLlista:
                    club = ClubUB.carregar("./LListasocis.dat");
                    break;

            }

        } while (opcionMenu != OpcionesMenu.M_opcion_9_Sortir);
    }

    /**
     * Mètode per a gestionar el submenú
     *
     * @param sc Per a poder introduir coses per teclat (input)
     * @throws ExcepcioClub
     */
    public void gestioMenu2(Scanner sc) throws ExcepcioClub {
        Menu<OpcionesMenu2> menuSocis = new Menu<>("Menu Club", OpcionesMenu2.values());
        menuSocis.setDescripcions(descMenu2);
        OpcionesMenu2 opcionMenu2;

        do {
            menuSocis.mostrarMenu();
            opcionMenu2 = menuSocis.getOpcio(sc);

            switch (opcionMenu2) {
                case M_Opcion_1_SociFederat:
                    club.afegirSociFederat(sc);
                    break;
                case M_Opcion_2_SociEstandard:
                    club.afegirSociEstandard(sc);
                    break;
                case M_Opcion_3_SociJunior:
                    club.afegirSociJunior(sc);
                    break;
                case M_Opcion_4_Menu:
                    break;
            }
        } while (opcionMenu2 != OpcionesMenu2.M_Opcion_4_Menu);

    }
}
