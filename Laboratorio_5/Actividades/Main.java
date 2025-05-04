package lab05.listaenlazada;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        List<Tarea> tareasCompletadas = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Imprimir todas las tareas actuales");
            System.out.println("4. Verificar si una tarea existe");
            System.out.println("5. Invertir la lista de tareas");
            System.out.println("6. Transferir tarea a lista de completadas");
            System.out.println("7. Mostrar tareas completadas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese prioridad (entero): ");
                    int prioridad = scanner.nextInt();
                    gestor.agregarTarea(new Tarea(descripcion, prioridad));
                    System.out.println("Tarea agregada correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese descripción de la tarea a eliminar: ");
                    String descEliminar = scanner.nextLine();
                    System.out.print("Ingrese prioridad de la tarea a eliminar: ");
                    int prioEliminar = scanner.nextInt();
                    if (gestor.eliminarTarea(new Tarea(descEliminar, prioEliminar))) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("\nTareas actuales:");
                    gestor.imprimirTareas();
                    break;

                case 4:
                    System.out.print("Ingrese descripción de la tarea a buscar: ");
                    String descBuscar = scanner.nextLine();
                    System.out.print("Ingrese prioridad de la tarea a buscar: ");
                    int prioBuscar = scanner.nextInt();
                    boolean existe = gestor.contieneTarea(new Tarea(descBuscar, prioBuscar));
                    System.out.println("¿Existe la tarea? " + existe);
                    break;

                case 5:
                    gestor.invertirTareas();
                    System.out.println("Lista de tareas invertida.");
                    break;

                case 6:
                    System.out.print("Ingrese descripción de la tarea a completar: ");
                    String descCompletar = scanner.nextLine();
                    System.out.print("Ingrese prioridad de la tarea a completar: ");
                    int prioCompletar = scanner.nextInt();
                    Tarea tareaCompletar = new Tarea(descCompletar, prioCompletar);
                    if (gestor.eliminarTarea(tareaCompletar)) {
                        tareasCompletadas.add(tareaCompletar);
                        System.out.println("Tarea transferida a completadas.");
                    } else {
                        System.out.println("No se encontró la tarea para completar.");
                    }
                    break;

                case 7:
                    System.out.println("\nTareas completadas:");
                    for (Tarea t : tareasCompletadas) {
                        System.out.println(t);
                    }
                    break;

                case 8:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
