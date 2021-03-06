package cl.keanzato.app.core;

public class Cuenta {

	private int idcuenta;
	private String idusuario;
	private int monto;
	private String proviene;
	private String fechaingreso;
	/**
	 * @return the idcuenta
	 */
	public int getIdcuenta() {
		return idcuenta;
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
	 * @param idcuenta the idcuenta to set
	 */
	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
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
	 * @return the proviene
	 */
	public String getProviene() {
		return proviene;
	}
	/**
	 * @param proviene the proviene to set
	 */
	public void setProviene(String proviene) {
		this.proviene = proviene;
	}
	/**
	 * @return the fechaingreso
	 */
	public String getFechaingreso() {
		return fechaingreso;
	}
	/**
	 * @param fechaingreso the fechaingreso to set
	 */
	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	/**
	 * @param idcuenta
	 * @param monto
	 * @param proviene
	 * @param fechaingreso
	 */
	public Cuenta(int idcuenta,String idusuario,int monto, String proviene, String fechaingreso) {
		super();
		this.idcuenta = idcuenta;
		this.idusuario = idusuario;
		this.monto = monto;
		this.proviene = proviene;
		this.fechaingreso = fechaingreso;
	}
	/**
	 * 
	 */
	public Cuenta() {
		super();
	}
}
