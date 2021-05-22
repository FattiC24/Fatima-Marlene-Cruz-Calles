package com.fatima.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fatima.Conexion.ConexionBd;

public class CLSArchivos {
	public void guardararchivos(String nombre) {
		try {
			ConexionBd con = new ConexionBd();
		PreparedStatement stm;
		String consulta = "insert into imagen(nameoffile) values (?)";
		
			stm = con.RetornarConexion().prepareStatement(consulta);
			stm.setString(1, nombre);
			int fila= stm.executeUpdate();
		} catch (Exception e) {
			System.out.print(e);
		}
		
		}
		
		public String seleccionararchivos() {
			ConexionBd con = new ConexionBd();
			String nombre = "";
			PreparedStatement stm;
			String consulta = "Select * from imagen";
			try {
				stm = con.RetornarConexion().prepareStatement(consulta);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
	                nombre = rs.getString("nameoffile");
	            }
			} catch (Exception e) {
				System.out.println(e);
			}
			return nombre;
			}

}
