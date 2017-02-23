package cl.keanzato.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.keanzato.app.conexion.ConexionBD;
import cl.keanzato.app.core.Cuenta;
import cl.keanzato.app.interfaces.InterfaceCuenta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CuentaDao implements InterfaceCuenta {

	
    public List<Cuenta> lista() throws SQLException, ClassNotFoundException {
        try {
            ConexionBD conn = ConexionBD.getInstancia();
            PreparedStatement consulta = conn.getConnection().prepareStatement("select * from cuenta");
            ResultSet rst = consulta.executeQuery();
            List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (rst.next()) {
                cuentas.add(parser(rst));
            }
            return cuentas;
        } catch (SQLException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean agregar(Cuenta cuenta) throws SQLException, ClassNotFoundException {
        try {
            ConexionBD conn = ConexionBD.getInstancia();
            PreparedStatement consulta = conn.getConnection().prepareStatement("insert into cuenta values(null,?,?,?,?)");
            consulta.setString(1, cuenta.getIdusuario());
            consulta.setInt(2, cuenta.getMonto());
            consulta.setString(3, cuenta.getProviene());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            cuenta.setFechaingreso(dateFormat.format(new Date()));
            consulta.setString(4, cuenta.getFechaingreso());
            consulta.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private Cuenta parser(ResultSet rst) throws SQLException {
        Cuenta cuenta = new Cuenta();

        cuenta.setIdcuenta(rst.getInt("idcuenta"));
        cuenta.setIdusuario(rst.getString("idusuario"));
        cuenta.setMonto(rst.getInt("monto"));
        cuenta.setProviene(rst.getString("proviene"));
        cuenta.setFechaingreso(rst.getString("fechaingreso"));

        return cuenta;
    }

  
    public int totalFinanzas(String idusuario) {
        int suma = 0;
        try {

            for (Cuenta cuenta : lista()) {
            	if(cuenta.getIdusuario().equals(idusuario))
                suma = suma + cuenta.getMonto();
            }
            return suma;
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }catch(Exception ex){
        	System.out.println(ex.getMessage());
        	return 0;
        }
    }

  
    public boolean eliminar(int idcuenta) throws SQLException, ClassNotFoundException {
        try{
            ConexionBD conn = ConexionBD.getInstancia();
            PreparedStatement consulta = conn.getConnection().prepareStatement("delete from cuenta where idcuenta = ?");
            
            consulta.setInt(1, idcuenta);
            consulta.executeUpdate();
            return true;
        }catch(SQLException ex){
             Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }catch(Exception ex){
             Logger.getLogger(CuentaDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }

}
