/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "sede")
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsede")
    private Integer idsede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_sede")
    private String nombreSede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_funcionamiento")
    @Temporal(TemporalType.TIME)
    private Date horaFuncionamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_salas")
    private int numeroSalas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_sede")
    private int estadoSede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "ciudad", referencedColumnName = "iddane")
    @ManyToOne(optional = false)
    private DemograficoDane ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private Collection<HistoricoInventario> historicoInventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsede")
    private Collection<Sala> salaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSede")
    private Collection<Activo> activoCollection;

    public Sede() {
    }

    public Sede(Integer idsede) {
        this.idsede = idsede;
    }

    public Sede(Integer idsede, String nombreSede, String direccion, int telefono, Date horaFuncionamiento, int numeroSalas, int estadoSede, String descripcion) {
        this.idsede = idsede;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaFuncionamiento = horaFuncionamiento;
        this.numeroSalas = numeroSalas;
        this.estadoSede = estadoSede;
        this.descripcion = descripcion;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
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

    public Date getHoraFuncionamiento() {
        return horaFuncionamiento;
    }

    public void setHoraFuncionamiento(Date horaFuncionamiento) {
        this.horaFuncionamiento = horaFuncionamiento;
    }

    public int getNumeroSalas() {
        return numeroSalas;
    }

    public void setNumeroSalas(int numeroSalas) {
        this.numeroSalas = numeroSalas;
    }

    public int getEstadoSede() {
        return estadoSede;
    }

    public void setEstadoSede(int estadoSede) {
        this.estadoSede = estadoSede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DemograficoDane getCiudad() {
        return ciudad;
    }

    public void setCiudad(DemograficoDane ciudad) {
        this.ciudad = ciudad;
    }

    public Collection<HistoricoInventario> getHistoricoInventarioCollection() {
        return historicoInventarioCollection;
    }

    public void setHistoricoInventarioCollection(Collection<HistoricoInventario> historicoInventarioCollection) {
        this.historicoInventarioCollection = historicoInventarioCollection;
    }

    public Collection<Sala> getSalaCollection() {
        return salaCollection;
    }

    public void setSalaCollection(Collection<Sala> salaCollection) {
        this.salaCollection = salaCollection;
    }

    public Collection<Activo> getActivoCollection() {
        return activoCollection;
    }

    public void setActivoCollection(Collection<Activo> activoCollection) {
        this.activoCollection = activoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsede != null ? idsede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.idsede == null && other.idsede != null) || (this.idsede != null && !this.idsede.equals(other.idsede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.Sede[ idsede=" + idsede + " ]";
    }
    
}
