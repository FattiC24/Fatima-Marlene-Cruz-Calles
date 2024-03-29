package com.fatima.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fatima.Conexion.ConexionBd;
import com.fatima.Entidades.usuario;

public class ClsUsuario {
	ConexionBd conexion = new ConexionBd();
    Connection con = conexion.RetornarConexion();
    
	public ArrayList<usuario> ListadoUSUARIOS() {
        ArrayList<usuario> Lista = new ArrayList<>();

        try {

            CallableStatement consulta = con.prepareCall("call SP_S_SOLOUSUARIOS()");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPass(rs.getString("PassWord"));
                user.setIdTipoUsuario(rs.getInt("tipoUsuario"));
                Lista.add(user);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
        }

        return Lista;
    }
	public void Eliminar (usuario user){

        try {

            CallableStatement consulta = con.prepareCall("call SP_D_USER(?)");
                consulta.setInt("PidUsario", user.getIdUsuario());
                consulta.execute();
                System.out.print("Exito");
                con.close();
                
        } catch (Exception e) {
        	System.out.print(e);
        }

    }
	public void Actualizar (usuario user){

        try {

            CallableStatement consulta = con.prepareCall("call SP_U_USUARIO(?,?,?)");
                consulta.setString("PUsuario", user.getUsuario());
                consulta.setString("PPass", user.getPass());
                consulta.setInt("PidUsario", user.getIdUsuario());
                consulta.execute();
                System.out.print("Exito");
                con.close();
                
        } catch (Exception e) {
        	System.out.print(e);
        }

    }
	public void AgregarUsuario (usuario user){

        try {

            CallableStatement consulta = con.prepareCall("call SP_I_USUARIO(?,?,?)");
                consulta.setString("PUsuario", user.getUsuario());
                consulta.setString("PPass", user.getPass());
                consulta.setInt("PTipoUsuario", user.getIdTipoUsuario());
                consulta.execute();
                System.out.print("Exito");
                con.close();
                
        } catch (Exception e) {
        	System.out.print(e);
        }

    }

}
