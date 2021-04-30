package com.fatima.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fatima.Entidades.usuario;
import com.fatima.Negocio.*;

/**
 * Servlet implementation class ControllerAcceso
 */
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
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
		
			HttpSession session  = request.getSession(true);
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
				
			usuario log = new usuario();
			clsLogin clsL = new clsLogin();

			log.setUsuario(user);
			log.setPass(pass);
			
			String btncerrar = request.getParameter("btncerrar");
			if(btncerrar != null) {
				response.sendRedirect("index.jsp");
				session.invalidate();
			}else {
			
			
			int valoracceso = clsL.acceso(log);

			if (valoracceso == 1) {
				//Este es un usuario Administrador
				System.out.println("> Administrador.");
				response.sendRedirect("Administrador.jsp");
				session.setAttribute("usuario", valoracceso);
				
			} else if (valoracceso == 2) {
				//Este es un usuario normal
				System.out.println("> Usuario.");
				response.sendRedirect("usuario.jsp");
			} else {
				System.out.println("> Error.");
					response.sendRedirect("Error.jsp");
				}
			}
	}
}
