package com.fatima.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fatima.Dao.ClsUsuario;
import com.fatima.Entidades.usuario;
import com.google.gson.Gson;

/**
 * Servlet implementation class ControllerMostrarInformacion
 */
@WebServlet("/ControllerMostrarInformacion")
public class ControllerMostrarInformacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerMostrarInformacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Evaluar = request.getParameter("Eliminar");
		
		String agregando= request.getParameter("Guardar");
		String Idusuario = request.getParameter("IdUsuario");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("Pass");

		ClsUsuario clsusu = new ClsUsuario();
		usuario usu = new usuario();
		
		if(Evaluar!=null) {
			if (Evaluar.equals("btne")) {

				usu.setIdUsuario(Integer.parseInt(request.getParameter("usu")));
				clsusu.Eliminar(usu);
				response.sendRedirect("saludo.jsp");
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Gson json = new Gson();
		
		ClsUsuario clsusuario = new ClsUsuario();
		
		response.getWriter().append(json.toJson(clsusuario.ListadoUSUARIOS()));
	}

}
