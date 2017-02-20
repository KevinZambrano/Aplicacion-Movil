/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.controllers;

import cl.keanzato.app.core.Cuenta;
import cl.keanzato.app.dao.CuentaDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author k.zambrano.torres
 */
@Path("cuentas")
public class CuentaController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Cuenta> listaCuentas() throws ClassNotFoundException {
        try {
            CuentaDao cuentaDao = new CuentaDao();
            return cuentaDao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ingresos")
    public int totalFinanzas() {
        try {
            CuentaDao cuentaDao = new CuentaDao();
            return cuentaDao.totalFinanzas();
        } catch (Exception ex) {
            Logger.getLogger(CuentaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ingresos")
    public Response agregarCuenta(Cuenta cuenta) throws ClassNotFoundException {
        try {
            CuentaDao cuentaDao = new CuentaDao();
            cuentaDao.agregar(cuenta);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response eliminar(@PathParam("id") int id) throws ClassNotFoundException{
        try{
            CuentaDao cuentaDao = new CuentaDao();
            cuentaDao.eliminar(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
