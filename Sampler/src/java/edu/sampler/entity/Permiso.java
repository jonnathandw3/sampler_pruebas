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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "permiso")
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpermiso")
    private Integer idpermiso;
    @Basic(optional = false)
    @Column(name = "id_rol")
    private int idRol;
    @Basic(optional = false)
    @Column(name = "crear")
    private boolean crear;
    @Basic(optional = false)
    @Column(name = "borar")
    private boolean borar;
    @Basic(optional = false)
    @Column(name = "actualizar")
    private boolean actualizar;
    @Basic(optional = false)
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPermiso")
    private Collection<PermisoRol> permisoRolCollection;
    @JoinColumn(name = "idmodulo", referencedColumnName = "idmodulo")
    @ManyToOne(optional = false)
    private Modulo idmodulo;

    public Permiso() {
    }

    public Permiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public Permiso(Integer idpermiso, int idRol, boolean crear, boolean borar, boolean actualizar, Date fechaModificacion) {
        this.idpermiso = idpermiso;
        this.idRol = idRol;
        this.crear = crear;
        this.borar = borar;
        this.actualizar = actualizar;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public boolean getCrear() {
        return crear;
    }

    public void setCrear(boolean crear) {
        this.crear = crear;
    }

    public boolean getBorar() {
        return borar;
    }

    public void setBorar(boolean borar) {
        this.borar = borar;
    }

    public boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Collection<PermisoRol> getPermisoRolCollection() {
        return permisoRolCollection;
    }

    public void setPermisoRolCollection(Collection<PermisoRol> permisoRolCollection) {
        this.permisoRolCollection = permisoRolCollection;
    }

    public Modulo getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Modulo idmodulo) {
        this.idmodulo = idmodulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermiso != null ? idpermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idpermiso == null && other.idpermiso != null) || (this.idpermiso != null && !this.idpermiso.equals(other.idpermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.Permiso[ idpermiso=" + idpermiso + " ]";
    }
    
}
