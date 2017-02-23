package cl.keanzato.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.keanzato.app.core.Usuario;
import cl.keanzato.app.dao.UsuarioDao;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario user = new Usuario(usuario, password);
			if (usuarioDao.login(user)) {
				request.getSession().setAttribute("USUARIO", user);
				response.sendRedirect("mobile/index.html#");
			} else
				response.sendRedirect("/SpringAngular/#/login");
		} catch (Exception ex) {
			response.sendRedirect("/SpringAngular/#/login");
		}

	}

}
