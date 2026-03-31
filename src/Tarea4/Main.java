package Tarea4;
import java.sql.Connection;

import Tarea4.logica.ConexionDB;

public class Main {

	public static void main(String[] args) {
		
		try {
			Connection conexion = ConexionDB.obtenerConexion();
			System.out.println ("Conexion realizada correctamente");
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al conectar: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
