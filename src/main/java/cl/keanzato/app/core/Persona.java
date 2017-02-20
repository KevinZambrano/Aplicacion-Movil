package cl.keanzato.app.core;

public class Persona {

	private int rut;
	private int digitoverificador;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private String pais;
	private String genero;
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
	 * @return the digitoverificador
	 */
	public int getDigitoverificador() {
		return digitoverificador;
	}
	/**
	 * @param digitoverificador the digitoverificador to set
	 */
	public void setDigitoverificador(int digitoverificador) {
		this.digitoverificador = digitoverificador;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidopaterno
	 */
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	/**
	 * @param apellidopaterno the apellidopaterno to set
	 */
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	/**
	 * @return the apellidomaterno
	 */
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	/**
	 * @param apellidomaterno the apellidomaterno to set
	 */
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @param rut
	 * @param digitoverificador
	 * @param nombre
	 * @param apellidopaterno
	 * @param apellidomaterno
	 * @param pais
	 * @param genero
	 */
	public Persona(int rut, int digitoverificador, String nombre, String apellidopaterno, String apellidomaterno,
			String pais, String genero) {
		super();
		this.rut = rut;
		this.digitoverificador = digitoverificador;
		this.nombre = nombre;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
		this.pais = pais;
		this.genero = genero;
	}
	/**
	 * 
	 */
	public Persona() {
		super();
	}
	
	
}
