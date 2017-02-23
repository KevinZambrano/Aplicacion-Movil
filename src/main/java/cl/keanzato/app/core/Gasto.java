package cl.keanzato.app.core;

public class Gasto {

	private int idgasto;
	private String idusuario;
	private int monto;
	private String descripcion;
	private String fechagasto;
	
	/**
	 * @return the idgasto
	 */
	public int getIdgasto() {
		return idgasto;
	}
	/**
	 * @param idgasto the idgasto to set
	 */
	public void setIdgasto(int idgasto) {
		this.idgasto = idgasto;
	}
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
	 * @return the monto
	 */
	public int getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(int monto) {
		this.monto = monto;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the fechagasto
	 */
	public String getFechagasto() {
		return fechagasto;
	}
	/**
	 * @param fechagasto the fechagasto to set
	 */
	public void setFechagasto(String fechagasto) {
		this.fechagasto = fechagasto;
	}
	/**
	 * @param idgasto
	 * @param idusuario
	 * @param monto
	 * @param descripcion
	 * @param fechagasto
	 */
	public Gasto(int idgasto, String idusuario, int monto, String descripcion, String fechagasto) {
		super();
		this.idgasto = idgasto;
		this.idusuario = idusuario;
		this.monto = monto;
		this.descripcion = descripcion;
		this.fechagasto = fechagasto;
	}
	/**
	 * 
	 */
	public Gasto() {
		super();
	}
	
	
}
