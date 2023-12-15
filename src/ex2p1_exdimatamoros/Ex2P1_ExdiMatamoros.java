/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2p1_exdimatamoros;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author exdir
 */
public class Ex2P1_ExdiMatamoros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        boolean condicion = true;
        while (condicion){
            System.out.println("-----MASS EFFECT-----");
            System.out.println("1.Reclutar Tripulante ");
            System.out.println("2.Listar Tripulacion ");
            System.out.println("3.Batalla Final ");
            System.out.println("4.Exit ");
            System.out.println("---------------------");
            System.out.print("Ingrese una opcion: ");
            
            opcion = entrada.nextInt();
            
            switch (opcion){
                case 1:
                {
                    ArrayList<Tripulante> tripulacion = null;
                    reclutarTripulante(tripulacion);
                }
                    break;

                case 2:
                {
                    ArrayList<Tripulante> tripulacion = null;
                    listarTripulantes(tripulacion);
                }
                    break;

                case 3:
                {
                    ArrayList<Tripulante> tripulacion = null;
                    ataqueCollector(tripulacion);
                }
                    break;

                case 4:
                    condicion = false;
                    System.out.println("EJECUCION FINALIZADA, VUELVA PRONTO.....");
                    break;
                default:
                    System.out.println("OPCION INGRESADA NO VALIDA, VUELVA A INTENTAR......");
            }
        }
    }
    public static void reclutarTripulante(ArrayList<Tripulante> tripulacion) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String especie;
        String planeta;
        System.out.println("Ingrese el nombre del tripulante: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese la especie del tripulante: ");
        especie = scanner.nextLine();
        System.out.println("Ingrese el planeta de origen del tripulante");
        planeta = scanner.nextLine();

        int habilidadAtaque = 0;
        int habilidadDefensa = 0;
        int habilidadTecnica = 0;
        int estadoHabilidades = 1;
        while (estadoHabilidades != 0) {
            System.out.println("Ingrese la hablidad de ataque del tripulante(entre 100 y 300): ");
            habilidadAtaque = scanner.nextInt();
            System.out.println("Ingrese la habilidad de defensa del tripulante(entre 100 y 300): ");
            habilidadDefensa = scanner.nextInt();
            System.out.println("Ingrese la habilidad tecnica del tripulante (entre 100 y 300): ");
            habilidadTecnica = scanner.nextInt();
            if (habilidadAtaque >= 100 && habilidadAtaque <= 300 && habilidadDefensa >= 100 && habilidadDefensa <= 300 && habilidadTecnica >= 100 && habilidadTecnica <= 300) {
                estadoHabilidades = 0;
            } else {
                System.out.println("Las habilidades deben estar entre 100 y 300, intente nuevamente. ");
            }
        }
    }

    public static void listarTripulantes(ArrayList<Tripulante> tripulacion) {
        if (tripulacion.isEmpty()) {
            System.out.println("La tripulacion esta vacia.");
        } else {
            System.out.println("----TRIPULACION EN BASE DE DATOS DE LA NORMANDY----");
            for (int i = 0; i < tripulacion.size(); i++) {
                Tripulante tripulante = tripulacion.get(i);
                System.out.println("Nombre de tripulacion: " + tripulante.getNombre() + "| Especie: " + tripulante.getEspecie() + "| Planeta de origen: " + tripulante.getPlaneta());
                System.out.println("ANALISIS DE HABILIDADES");
                System.out.println("Ataque = " + tripulante.getHabilidadAtaque() + "Habilidad Tecnica = " + tripulante.getHabilidadTecnica() + " Defensa=" + tripulante.getHabilidadDefensa());
                System.out.println();
            }

        }
    }

    public static boolean ataqueCollector(ArrayList<Tripulante> tripulacion) {
        Scanner scanner2 = new Scanner(System.in);
        Random random = new Random();

        int turnos = 0;
        int bajas = 0;

        while (turnos < 5) {
            int situacionAleatoria = random.nextInt(8);

            System.out.println("-+-+-+- Situación Aleatoria -+-+-+-");
            System.out.println("Descripcion: " + obtenerDescripcionSituacionAleatoria(situacionAleatoria));
            System.out.println("Miembros de la tripulacion:");

            for (int i = 0; i < tripulacion.size(); i++) {
                System.out.println(i + "- " + tripulacion.get(i).toString());
            }

            System.out.print("Seleccione un miembro del equipo para enfrentar la situacion: ");
            int indiceTripulante = scanner2.nextInt();

            if (indiceTripulante >= 0 && indiceTripulante < tripulacion.size()) {
                Tripulante tripulanteElegido = tripulacion.get(indiceTripulante);

                int resultadoHabilidad = random.nextInt(201) + 100;

                System.out.println("Resultado de habilidad del tripulante: " + resultadoHabilidad);

                if (habilidadSuficiente(tripulanteElegido, situacionAleatoria, resultadoHabilidad)) {
                    System.out.println(tripulanteElegido.getNombre() + " tuvo exito en su mision!!");
                } else {
                    System.out.println(tripulanteElegido.getNombre() + " murio en batalla. No logro terminar su misión. Si quedan miembros del equipo, intente de nuevo.");
                    tripulacion.remove(tripulanteElegido);
                    bajas++;
                }
            } else {
                System.out.println("¡Indice de tripulante no valido!");
            }

            turnos++;
        }

        // Situación adicional para el quinto turno
        System.out.println("-+-+-+- Situación Final -+-+-+-");
        System.out.println("Descripcion: Llego al nucleo de la nave. Destruya la ultima arma de los collectors para triunfar (necesidad de ataque)");

        System.out.println("Miembros de la tripulacion:");

        for (int i = 0; i < tripulacion.size(); i++) {
            System.out.println(i + "- " + tripulacion.get(i).toString());
        }

        System.out.print("Seleccione un miembro del equipo para destruir la ultima arma: ");
        int indiceTripulanteFinal = scanner2.nextInt();

        if (indiceTripulanteFinal >= 0 && indiceTripulanteFinal < tripulacion.size()) {
            Tripulante tripulanteElegidoFinal = tripulacion.get(indiceTripulanteFinal);

            int resultadoHabilidadFinal = random.nextInt(201) + 100;

            System.out.println("Resultado de habilidad del tripulante para destruir la ultima arma: " + resultadoHabilidadFinal);

            if (resultadoHabilidadFinal >= tripulanteElegidoFinal.getHabilidadAtaque()) {
                System.out.println(tripulanteElegidoFinal.getNombre() + " tuvo exito en destruir la ultima arma! La misión fue un exito.");
                return true;
            } else {
                System.out.println(tripulanteElegidoFinal.getNombre() + " no tuvo exito en destruir la ultima arma. La misión fue un fracaso!");
                tripulacion.remove(tripulanteElegidoFinal);
                bajas++;
            }
        } else {
            System.out.println("¡Índice de tripulante no válido para la situación final!");
        }

        if (bajas == tripulacion.size()) {
            System.out.println("¡Todos los miembros del equipo han muerto! La misión fue un fracaso.");
            return false;
        }

        return true;
    }

    public static String obtenerDescripcionSituacionAleatoria(int situacionAleatoria) {
        switch (situacionAleatoria) {
            case 0:
                return "Un escudo se interpone en el camino, se necesita desactivar (necesidad técnica)";
            case 1:
                return "El sistema de seguridad se activo, se necesita desactivar (necesidad tecnica)";
            case 2:
                return "Se encuentran con un grupo de collectors. Necesitan atacarlos (necesidad de ataque)";
            case 3:
                return "Los collectors lanzan explosivos hacia el grupo. Necesita defenderse (necesidad de defensa)";
            case 4:
                return "Se enfrenta a un comandante de los collectors. Necesita atacarlos (necesidad ofensiva)";
            case 5:
                return "Caen en una trampa de los collectors. Necesita escapar con vida (necesidad defensiva)";
            case 6:
                return "Se necesita abrir una puerta bloqueada, que no se puede romper (necesidad tecnica)";
            case 7:
                return "Elija a alguien para liderar al equipo a través de un escuadrón de collectors (necesidad ofensiva)";
            default:
                return "Descripcion de la situacion no especificada";
        }
    }

    private static boolean habilidadSuficiente(Tripulante tripulante, int situacionAleatoria, int resultadoHabilidad) {
        String necesidad = obtenerTipoNecesidad(situacionAleatoria);

        switch (necesidad) {
            case "tecnica":
                return resultadoHabilidad >= tripulante.getHabilidadTecnica();
            case "ataque":
                return resultadoHabilidad >= tripulante.getHabilidadAtaque();
            case "defensa":
                return resultadoHabilidad >= tripulante.getHabilidadDefensa();
            default:
                System.out.println("Necesidad no reconocida.");
                return false;
        }
    }

    private static String obtenerTipoNecesidad(int situacionAleatoria) {
        switch (situacionAleatoria) {
            case 0:
            case 1:
            case 6:
                return "tecnica";
            case 2:
            case 4:
            case 7:
                return "ataque";
            case 3:
            case 5:
                return "defensa";
            default:
                System.out.println("Situacin no reconocida.");
                return "";
        }
    }
}
