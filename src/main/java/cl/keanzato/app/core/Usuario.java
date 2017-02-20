package cl.keanzato.app.core;

public class Usuario {

	private String idusuario;
	private int rut;
	private String password;
	private String correo;
	/**
	 * @return the idusuario
	 */
	public String getIdusuario() {
		return idusuario;
	}
	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	/**
	 * @return the rut
	 */
	public int getRut() {
		return rut;
	}
	/**
	 * @param rut the rut to set
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @param idusuario
	 * @param rut
	 * @param password
	 * @param correo
	 */
	public Usuario(String idusuario, int rut, String password, String correo) {
		super();
		this.idusuario = idusuario;
		this.rut = rut;
		this.password = password;
		this.correo = correo;
	}
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	
	
}
