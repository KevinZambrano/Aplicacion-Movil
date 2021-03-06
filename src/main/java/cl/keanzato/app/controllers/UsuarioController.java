package cl.keanzato.app.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.keanzato.app.core.Usuario;
import cl.keanzato.app.dao.UsuarioDao;

@Path("usuarios")
public class UsuarioController {

	@Context
	private HttpServletRequest request;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response agregarUsuario(Usuario usuario) throws ClassNotFoundException {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.agregarCuenta(usuario);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException ex) {
			Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/session/activa")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuarioSession() {
		Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");

		return usuario;
	}
}
