package cl.keanzato.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.keanzato.app.conexion.ConexionBD;
import cl.keanzato.app.core.Persona;
import cl.keanzato.app.interfaces.InterfacePersona;

public class PersonaDao implements InterfacePersona {

	public List<Persona> lista() throws SQLException, ClassNotFoundException {
		try {
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("select * from persona");
			ResultSet rst = consulta.executeQuery();
			List<Persona> personas = new ArrayList<Persona>();

			while (rst.next()) {
				personas.add(parser(rst));
			}
			return personas;
		} catch (Exception ex) {
			return null;
		}
	}

	public void agregar(Persona persona) throws SQLException, ClassNotFoundException {
		try {
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection()
					.prepareStatement("insert into persona values(?,?,?,?,?,?,?)");

			consulta.setInt(1, persona.getRut());
			consulta.setInt(2, persona.getDigitoverificador());
			consulta.setString(3, persona.getNombre());
			consulta.setString(4, persona.getApellidopaterno());
			consulta.setString(5, persona.getApellidomaterno());
			consulta.setString(6, persona.getPais());
			consulta.setString(7, persona.getGenero());
			
			consulta.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Persona getPersona(int rut)throws SQLException, ClassNotFoundException {
		try{
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("select * from persona where rut=?");
			consulta.setInt(1, rut);
			ResultSet rst= consulta.executeQuery();
			Persona persona = new Persona();
			while(rst.next()){
				persona = parser(rst);
			}
			
			return persona;
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	private Persona parser(ResultSet rst) throws SQLException {
		Persona persona = new Persona();

		persona.setRut(rst.getInt("rut"));
		persona.setDigitoverificador(rst.getInt("digitoverificador"));
		persona.setNombre(rst.getString("nombre"));
		persona.setApellidopaterno(rst.getString("apellidopaterno"));
		persona.setApellidomaterno(rst.getString("apellidomaterno"));
		persona.setPais(rst.getString("pais"));
		persona.setGenero(rst.getString("genero"));

		return persona;
	}
}
