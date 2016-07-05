package py.edu.facitec.l3.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionManager {
	private static Connection conexion;
	public static Statement stm;
	//Constante
	private static final String URL="jdbc:postgresql://localhost:5432/bd_tp";
	private static final String USER="postgres";
	private static final String PASSWORD = "naoyuki97";
	public static Connection abrirConexion () {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Succeso en el drive");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el drive");
			e.printStackTrace();
		}
		try {
			conexion= DriverManager.getConnection(URL, USER, PASSWORD);
			stm= conexion.createStatement();
			System.out.println("Succeso en la conexion");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
	public static void cerrarConecion(){
		if (conexion !=null){ 
			try {
				conexion.close();
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
