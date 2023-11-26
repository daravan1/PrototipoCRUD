/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipobasecrud;

/**
 *
 * @author darav
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author darav
 */
public class Conexion {

    private Connection conn;

    public void establecerConexion() {
        try {
            // Cambiar la cadena de conexión para apuntar a la base de datos Northwind
            String url = "jdbc:sqlserver://nombre_servidor:conexion03;databaseName=Northwind;user=root;password=0000";
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQL Server (Northwind) has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarDatos() {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "INSERT INTO NombreDeTuTabla (Columna1, Columna2, Columna3) "
                    + "VALUES ('Valor1', 'Valor2', 'Valor3')";

            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());
        }
    }

    public void eliminarDatos() {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "DELETE FROM NombreTabla WHERE Condicion = 'ValorAEliminar'";
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());
        }
    }

    public void actualizarDatos() {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "UPDATE NombreTabla SET Columna1 = 'NuevoValor' WHERE Condicion = 'ValorACambiar'";
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> obtenerDatos() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();

            String data = "SELECT Columna1, Columna2 FROM NombreTabla";
            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                String resultado = rs.getString("Columna1") + " - " + rs.getString("Columna2");
                lista.add(resultado);
            }
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: Error al obtener datos");
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
