/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.Activo;
import edu.sampler.entity.Sede;
import edu.sampler.facade.ActivoFacadeLocal;
import edu.sampler.facade.SedeFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sebas
 */
@Named(value = "activoSessionController")
@SessionScoped
public class ActivoSessionController implements Serializable {

    @EJB
    ActivoFacadeLocal activoFacadeLocal;
    @EJB
    SedeFacadeLocal sedeFacadeLocal;
    
    private String codigoActivo;
    private String cantidad;
    private Sede sedeGestion;
    private String valor;
    private String nombreActivo;
    private String idSede;
    private Activo activoGestion;
    private Activo activoBorrar;
    
    public ActivoSessionController() {
         
    }
    
    public String borrarActivo(Activo activoBorrar){
        activoFacadeLocal.remove(activoBorrar);
        return "";
    }

    public String actualizarActivo() {
        activoFacadeLocal.edit(activoGestion);
        activoGestion = null;
        return null;
    }   
    
    public List<Activo> todosActivos() {
        return activoFacadeLocal.findAll();
    }
    
    public String ingresarNuevoActivo() {
        Activo activoNuevo = new Activo();
        
        double numeroAleatori = Math.random() * 100000;
            int CodigoActivoInt = (int) numeroAleatori;
            String codigo = "" + CodigoActivoInt;
            
        
        activoNuevo.setCantidad(Integer.parseInt(cantidad));
        activoNuevo.setIdSede(sedeFacadeLocal.find(Integer.parseInt(idSede)));
        activoNuevo.setCodigoActivo(codigo);
        activoNuevo.setNombreActivo(nombreActivo);
        activoNuevo.setValor(Double.parseDouble(valor));
      
        activoFacadeLocal.create(activoNuevo);
        
        this.cantidad = "";
        this.valor = "";
        this.nombreActivo = "";

        FacesMessage infoMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Activo", "Registrado exitosamente");
        FacesContext.getCurrentInstance().addMessage("miActivo", infoMensaje);

        return null;
    }
    
    

    public List<Sede> listaSedes() {
        return sedeFacadeLocal.findAll();
    }

    public String getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(String codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Sede getSedeGestion() {
        return sedeGestion;
    }

    public void setSedeGestion(Sede sedeGestion) {
        this.sedeGestion = sedeGestion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombreActivo() {
        return nombreActivo;
    }

    public void setNombreActivo(String nombreActivo) {
        this.nombreActivo = nombreActivo;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    public Activo getActivoGestion() {
        return activoGestion;
    }

    public void setActivoGestion(Activo activoGestion) {
        this.activoGestion = activoGestion;
    }

    public Activo getActivoBorrar() {
        return activoBorrar;
    }

    public void setActivoBorrar(Activo activoBorrar) {
        this.activoBorrar = activoBorrar;
    }
    
}
