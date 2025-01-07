/*
 * Creamos el objeto Task o Tarea, con la cual trabajaremos para poder insertarlas en el programa
 */
package com.taskmanager.model;

public class Task {
    private int id;
    private String name;
    private String description;
    private String priority;
    private String status;

    // Constructor sin ID (para las tareas nuevas)
    
    public Task(String name, String description, String priority, String status) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    // Constructor con ID (para las tareas existentes)
    public Task(int id, String name, String description, String priority, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    // Getters y Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

