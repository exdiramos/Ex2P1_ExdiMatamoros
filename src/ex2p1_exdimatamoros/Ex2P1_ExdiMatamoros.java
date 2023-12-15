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
            
            opcion = entrada.nextInt();
            
            switch (opcion){
                case 1:
                {
                    ArrayList<Tripulante> tripulacion;
                    reclutarTripulante(tripulacion);
                }
                    break;

                case 2:
                {
                    ArrayList<Tripulante> tripulacion;
                    listarTripulantes(tripulacion);
                }
                    break;

                case 3:
                {
                    ArrayList<Tripulante> tripulacion;
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
        System.out.println("Ingrese la especia del tripulante: ");
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
        Scanner scanner3 = new Scanner(System.in);
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

        }
    }
}
