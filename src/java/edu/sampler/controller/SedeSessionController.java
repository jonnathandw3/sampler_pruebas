/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.DemograficoDane;
import edu.sampler.entity.Sede;
import edu.sampler.facade.DemograficoDaneFacadeLocal;
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
@Named(value = "sedeSessionController")
@SessionScoped
public class SedeSessionController implements Serializable {

   @EJB
    DemograficoDaneFacadeLocal demograficoFacadeLocal;
    @EJB
    SedeFacadeLocal sedeFacadeLocal;

    private String nombre_sede;
    private String direccion;
    private int telefono;
    private int ciudad;
    private int estado_sede;
    private String descripcion;
    private Sede sedeBorrar;
    private Sede sedeGestion;

    /**
     * Creates a new instance of SedeSessionController
     */
    public SedeSessionController() {
    }

    public String borrarSede(Sede sedeBorrar) {
        sedeFacadeLocal.remove(sedeBorrar);
        return "";
    }

    public String actualizarSede() {
        sedeFacadeLocal.edit(sedeGestion);
        sedeGestion = null;
        return null;
    }   

    public List<Sede> todosSede() {
        return sedeFacadeLocal.findAll();
    }

    public List<DemograficoDane> listaCiudad() {
        return demograficoFacadeLocal.findAll();
    }

    public String ingresarNuevaSede() {
        Sede sedeNuevo = new Sede();

        sedeNuevo.setNombreSede(nombre_sede);
        sedeNuevo.setDireccion(direccion);
        sedeNuevo.setTelefono(telefono);
        sedeNuevo.setCiudad(demograficoFacadeLocal.find(this.ciudad));
        sedeNuevo.setEstadoSede(estado_sede);
        sedeNuevo.setDescripcion(descripcion);

        sedeFacadeLocal.create(sedeNuevo);

        this.nombre_sede = "";
        this.direccion = "";
        this.telefono = 0;
        this.estado_sede = 0;
        this.descripcion = "";

        FacesMessage infoMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sede", "Registrado exitosamente");
        FacesContext.getCurrentInstance().addMessage("miSede", infoMensaje);

        return null;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getEstado_sede() {
        return estado_sede;
    }

    public void setEstado_sede(int estado_sede) {
        this.estado_sede = estado_sede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sede getSedeBorrar() {
        return sedeBorrar;
    }

    public void setSedeBorrar(Sede sedeBorrar) {
        this.sedeBorrar = sedeBorrar;
    }

    public Sede getSedeGestion() {
        return sedeGestion;
    }

    public void setSedeGestion(Sede sedeGestion) {
        this.sedeGestion = sedeGestion;
    }
    
    
    
}
