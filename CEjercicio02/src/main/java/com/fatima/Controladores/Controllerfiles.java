package com.fatima.Controladores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fatima.Dao.CLSArchivos;

/**
 * Servlet implementation class Controllerfiles
 */
@MultipartConfig
public class Controllerfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllerfiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Part archivo = request.getPart("archivo");
		
		String nombredelaimagen = archivo.getSubmittedFileName();
		String ruta = "C:\\Users\\CruzCalles\\Documents\\GitHub\\Fatima-Marlene-Cruz-Calles\\CEjercicio02\\src\\main\\webapp\\Files\\" + nombredelaimagen;
		
		try {
			FileOutputStream fileoutput = new FileOutputStream(ruta);
			InputStream stream = archivo.getInputStream();
			
			byte[] datos = new byte[stream.available()];
			stream.read(datos);
			fileoutput.write(datos);
			fileoutput.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		CLSArchivos files =  new CLSArchivos();
		files.guardararchivos(nombredelaimagen);
		
		
	}
	

}
