package com.taskmanager.main;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();
                    System.out.print("Prioridad: (Alta, Media, Baja)");
                    String priority = scanner.nextLine();
                    System.out.print("Estado: ");
                    String status = scanner.nextLine();

                    Task task = new Task(name, description, priority, status);

                    try {
                        taskDAO.insertTask(task);
                        System.out.println("Tarea agregada.");
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        List<Task> tasks = taskDAO.getAllTasks();
                        tasks.forEach(t -> {
                            System.out.println("ID: " + t.getId());
                            System.out.println("Nombre: " + t.getName());
                            System.out.println("Descripción: " + t.getDescription());
                            System.out.println("Prioridad: " + t.getPriority());
                            System.out.println("Estado: " + t.getStatus());
                            System.out.println("-------------------");
                        });
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}

