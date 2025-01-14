package createDDBB;

import java.sql.*;

public class DBGenerator {

    private String dbUrl;

    public DBGenerator(String dbName) {
        this.dbUrl = "jdbc:sqlite:" + dbName;
        createDatabase();
    }

    private void createDatabase() {
        try (Connection connection = DriverManager.getConnection(dbUrl)) {
            if (connection != null) {
                System.out.println("Base de datos creada o conectada exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar o crear la base de datos: " + e.getMessage());
        }
    }

    public void crearTabla(String nombre) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombre + " (\n"
                   + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                   + " nombre TEXT NOT NULL,\n"
                   + " valor REAL\n"
                   + ");";

        try (Connection connection = DriverManager.getConnection(dbUrl);
             Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla '" + nombre + "' creada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void insertarDatos(String tabla, String nombre, double valor) {
        String sql = "INSERT INTO " + tabla + " (nombre, valor) VALUES (?, ?);";

        try (Connection connection = DriverManager.getConnection(dbUrl);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, valor);
            pstmt.executeUpdate();
            System.out.println("Datos insertados en la tabla '" + tabla + "'.");
        } catch (SQLException e) {
            System.err.println("Error al insertar datos: " + e.getMessage());
        }
    }

    public void limpiarDB(String tabla) {
        String sql = "DELETE FROM " + tabla + ";";

        try (Connection connection = DriverManager.getConnection(dbUrl);
             Statement stmt = connection.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Se han eliminado " + rowsAffected + " registros de la tabla '" + tabla + "'.");
        } catch (SQLException e) {
            System.err.println("Error al limpiar la tabla '" + tabla + "': " + e.getMessage());
        }
    }
    
}