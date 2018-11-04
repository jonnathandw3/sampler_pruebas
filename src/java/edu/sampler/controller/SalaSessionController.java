/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.Sala;
import edu.sampler.entity.Sede;
import edu.sampler.facade.SalaFacadeLocal;
import edu.sampler.facade.SedeFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sebas
 */
@Named(value = "salaSessionController")
@SessionScoped
public class SalaSessionController implements Serializable {

    /**
     * Creates a new instance of SalaSessionController
     */
    @EJB
    SalaFacadeLocal salaFacadeLocal;
    @EJB
    SedeFacadeLocal sedeFacadeLocal;

    private String idSede;
    private String nombreSala;
    private String codigoSala;
    private String estadoSala;
    private String descripcion;
    private Sala salaGestion;
    
    public SalaSessionController() {
    }
    
    public List<Sala> listarSalas() {
        return salaFacadeLocal.findAll();
    }

    public List<Sede> listarSede() {
        return sedeFacadeLocal.findAll();
    }

    public String borrarSala(Sala salaBorrar) {
        salaFacadeLocal.remove(salaBorrar);
        return "";
    }

    public String ingresarNuevaSala() {

        Sala salaNueva = new Sala();
        
        double numeroAleatori = Math.random() * 100000;
        int codInt = (int) numeroAleatori;
        String codigo = "S" + codInt;

        salaNueva.setIdsede(sedeFacadeLocal.find(Integer.parseInt(idSede)));
        salaNueva.setNombreSala(nombreSala);
        salaNueva.setCodigoSala(codigo);
        salaNueva.setEstadoSala(Integer.parseInt(estadoSala));
        salaNueva.setDescripcion(descripcion);

        salaFacadeLocal.create(salaNueva);

        this.idSede = "";
        this.codigoSala = "";
        this.nombreSala = "";
        this.estadoSala = "";
        this.descripcion = "";

        return null;

    }

    public String actualizarSala() {
        salaFacadeLocal.edit(salaGestion);
        salaGestion = null;
        return null;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(String estadoSala) {
        this.estadoSala = estadoSala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sala getSalaGestion() {
        return salaGestion;
    }

    public void setSalaGestion(Sala salaGestion) {
        this.salaGestion = salaGestion;
    }
    
    
}
