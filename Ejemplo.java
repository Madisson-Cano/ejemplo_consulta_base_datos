package com.ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo {
	private static final String URL = "jdbc:mysql://localhost:3307/ejemplo";
    private static final String USER = "root";  
    private static final String PASSWORD = "1234";

	public Ejemplo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL.");

            
            String sql = "SELECT * FROM cliente"; 
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

           
            while (resultSet.next()) {
                int No = resultSet.getInt("No");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                System.out.println("No: " + No + ", Nombre: " + nombre + ", Teléfono: " + telefono);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

