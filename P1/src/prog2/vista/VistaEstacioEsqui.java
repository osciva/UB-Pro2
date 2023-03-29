/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import prog2.model.LlistaPistes;
import java.util.Scanner;
import prog2.model.EstacioEsqui;
import prog2.model.LlistaRemuntadors;
import prog2.model.Meteo;


public class VistaEstacioEsqui {
    
    /* Atributs */
   
    private Meteo meteo = new Meteo(10, "Dolenta");
    private LlistaPistes cridarPistes = new LlistaPistes();
    private LlistaRemuntadors cridarRemuntadors = new LlistaRemuntadors();
    private EstacioEsqui estacio = new EstacioEsqui("Vall2000", 10, "Dolenta");    
    /* Constructor de la Vista*/
    public VistaEstacioEsqui(String nomEstacio, int velocitatVent, String visibilitat) {
       //VistaEstacioEsqui Vall2000 = new VistaEstacioEsqui("Vall2000", 10, "Dolenta");
    };
       
    /* Métodes */    
    /**
     * Mètode que ens permet gestionar la nostra Estació d'Esquí. La ges´ió de cada apartat del menú
     * ve a conseqüència del que introdueix l'usuari
     */
        
    public void gestioEstacio(){
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }
    
    /* ******************************************** */
    /* Gestion, Opciones y Descripcion del Menu (M) */
    /* ******************************************** */
    /**
     * Aquest mètode conté les diferents operacions que podem realitzar amb el menú
     */
    private static enum OpcionesMenu {
        M_Opcion_1_ListarPistas,
        M_Opcion_2_ListarPistasAbiertas,
        M_Opcion_3_ListarPistasCerradas,
        M_Opcion_4_ListarRemontadores,
        M_Opcion_5_ListarRemontadoresEnServicio,
        M_Opcion_6_ListarRemontadoresFueraServicio,
        M_Opcion_7_ModificarEstadoNieve,
        M_Opcion_8_CalcularTotalKms,
        M_Opcion_9_Modificar_Vent,
        M_Opcion_10_Modificar_Visibilitat,
        M_Opcion_11_Report_Meteo,
        M_Opcion_12_Salir
    };
    
    /**
     * Descripció per a l'usuari de les opcions del menú principal.Li indica segons la 
     * seva entrada la operació que podrà realitzar
     */
    private static final String[] descMenu = {
        "Llistar la informació de totes les pistes", // Opcion 1
        "Llistar la informació de les pistes obertes",  // Opcion 2
        "Llistar la informació de les pistes tancades",  // Opcion 3
        "Llistar la informació de tots els remuntadors mecànics",  // Opcion 4
        "Llistar la informació dels remuntadors en servei",  // Opcion 5
        "Llistar la informació dels remuntadors fora de servei",  // Opcion 6
        "Modificar l'estat de la neu d'una pista",  // Opcion 7
        "Calcular i mostrar el total de kilometres de pistes i de pistes obertes",  // Opcion 8
        "Modificar la velocitat del vent",  // Opcion 9
        "Modificar la visibilitat",  // Opcion 10
        "Mostrar les condicions meteorologiques actuals",  // Opcion 11
        "Sortir del gestor de l'estació"  // Opcion 12
    };
    
    // Funcion que gestiona el menu principal de la aplicacion
    // Tiene 3 pasos principales:
    //   1. Crear el objeto que representa (contiene) el menu
    //   2. Asignar las descripciones del menu
    //   3. Bucle donde se trata la opcion seleccionada por el usuario
    public void gestioMenu(Scanner sc) {
        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getEstacio(), OpcionesMenu.values());
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());
        estacio.inicialitzaDadesVall2000(cridarPistes, cridarRemuntadors);
        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuEstacio.setDescripcions(descMenu);
        
        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;
        
        // Lançar el bucle principal de la aplicación
        do {
            menuEstacio.mostrarMenu();
            opcionMenu = menuEstacio.getOpcio(sc);
            
            switch(opcionMenu) {
                case M_Opcion_1_ListarPistas:
                    System.out.println(cridarPistes.llistarPistes("Tots"));
                    
                    break;
                case M_Opcion_2_ListarPistasAbiertas:
                    System.out.println(cridarPistes.llistarPistes("Oberta"));
                    break;
                case M_Opcion_3_ListarPistasCerradas:
                    System.out.println(cridarPistes.llistarPistes("Tancada"));
                    break;
                case M_Opcion_4_ListarRemontadores:
                    System.out.println(cridarRemuntadors.llistarRemuntadors("Tots"));
                    break;
                case M_Opcion_5_ListarRemontadoresEnServicio:
                    System.out.println(cridarRemuntadors.llistarRemuntadors("En Servei"));
                    break;
                case M_Opcion_6_ListarRemontadoresFueraServicio:
                    System.out.println(cridarRemuntadors.llistarRemuntadors("Fora de Servei"));
                    break;
                case M_Opcion_7_ModificarEstadoNieve:
                    estacio.actualitzaEstatNeu(cridarPistes);
                    break;
                case M_Opcion_8_CalcularTotalKms:
                    estacio.calculaTotalKm(cridarPistes);
                    break;
                case M_Opcion_9_Modificar_Vent:
                    estacio.modificaVelocitatDelVent(meteo);
                    cridarRemuntadors.actualitzaEstat(meteo);
                    cridarPistes.actualitzaEstat();
                    estacio.actualitzaEstat();
                    break;
               case M_Opcion_10_Modificar_Visibilitat:
                    estacio.modificaVisibilitat(meteo);
                    cridarRemuntadors.actualitzaEstat(meteo);
                    cridarPistes.actualitzaEstat();
                    estacio.actualitzaEstat();
                    
                    break;
                case M_Opcion_11_Report_Meteo:
                    estacio.reportMeteo(meteo);
                    break;
            }
            
        } while(opcionMenu != OpcionesMenu.M_Opcion_12_Salir);
    }

}

