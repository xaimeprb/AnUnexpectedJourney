/*
 * Data Access Object u Objeto de Acceso a Datos, se trata de un patrón de diseño para disponer
 * de un componente que actúe como puente de implementación entre los datos almacenados en los
 * objetos de la lógica de negocio y los datos de persistencia.
 */
package com.taskmanager.dao;

import com.taskmanager.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/task_manager";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Sin contraseña

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void insertTask(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (name, description, priority, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getPriority());
            statement.setString(4, task.getStatus());
            statement.executeUpdate();
        }
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection connection = connect(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("priority"), resultSet.getString("status"));
                tasks.add(task);
            }
        }
        return tasks;
    }
}
