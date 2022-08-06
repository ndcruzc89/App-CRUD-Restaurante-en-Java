package co.edu.utp.misiontic.nelsoncruz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    
    // DAO -> Data Access Object -> métodos para gestionar la persistencia de los objetos
    // DTO -> Data Transfer Object
    // VO -> Value Object
    
    private static final String DATABASE = "D:\\Nelson\\Documentos\\Doc_Mision_TIC\\Ciclo2\\Programacion_Basica\\corrientazo\\src\\main\\resources\\corrientazo.db";

    public static Connection getConnection() throws SQLException {
        var url = "jdbc:sqlite:"+ DATABASE;
        return DriverManager.getConnection(url);
    }
}




