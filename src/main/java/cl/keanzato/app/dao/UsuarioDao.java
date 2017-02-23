package cl.keanzato.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cl.keanzato.app.conexion.ConexionBD;
import cl.keanzato.app.core.Usuario;
import cl.keanzato.app.interfaces.InterfaceUsuario;

public class UsuarioDao implements InterfaceUsuario {

	public boolean agregarCuenta(Usuario usuario) throws SQLException, ClassNotFoundException {
		try {
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("insert into usuario values(?,?,?,?)");
			consulta.setString(1, usuario.getIdusuario());
			consulta.setInt(2, usuario.getRut());
			consulta.setString(3, usuario.getPassword());
			consulta.setString(4, usuario.getCorreo());

			consulta.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public List<Usuario> lista() throws SQLException, ClassNotFoundException {
		try {

			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("select * from usuario");
			ResultSet rst = consulta.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();

			while (rst.next()) {
				usuarios.add(parser(rst));
			}

			return usuarios;
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean login(Usuario usuario) {
		try {
			if (usuario.getIdusuario() != null && usuario.getPassword() != null) {
				for (Usuario user : lista()) {
					if (user.getIdusuario().equals(usuario.getIdusuario())) {
						if (user.getPassword().equals(usuario.getPassword())) {
							return true;
						}
					}
				}
			}
			return false;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	private Usuario parser(ResultSet rst) throws SQLException {
		Usuario usuario = new Usuario();

		usuario.setIdusuario(rst.getString("idusuario"));
		usuario.setRut(rst.getInt("rut"));
		usuario.setPassword(rst.getString("password"));
		usuario.setCorreo(rst.getString("correo"));

		return usuario;
	}

	public Usuario getUsuario(String idusuario) throws SQLException, ClassNotFoundException {
		try {
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection()
					.prepareStatement("select * from usuario where idusuario = ?");
			consulta.setString(1, idusuario);
			ResultSet rst = consulta.executeQuery();
			Usuario usuario = new Usuario();
			while(rst.next()){
				usuario = parser(rst);
			}
			return usuario;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
