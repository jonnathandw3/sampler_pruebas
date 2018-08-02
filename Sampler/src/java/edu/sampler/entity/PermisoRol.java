/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "permiso_rol")
@NamedQueries({
    @NamedQuery(name = "PermisoRol.findAll", query = "SELECT p FROM PermisoRol p")})
public class PermisoRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermoso_rol")
    private Integer idpermosoRol;
    @JoinColumn(name = "id_rol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "id_permiso", referencedColumnName = "idpermiso")
    @ManyToOne(optional = false)
    private Permiso idPermiso;

    public PermisoRol() {
    }

    public PermisoRol(Integer idpermosoRol) {
        this.idpermosoRol = idpermosoRol;
    }

    public Integer getIdpermosoRol() {
        return idpermosoRol;
    }

    public void setIdpermosoRol(Integer idpermosoRol) {
        this.idpermosoRol = idpermosoRol;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Permiso getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Permiso idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermosoRol != null ? idpermosoRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoRol)) {
            return false;
        }
        PermisoRol other = (PermisoRol) object;
        if ((this.idpermosoRol == null && other.idpermosoRol != null) || (this.idpermosoRol != null && !this.idpermosoRol.equals(other.idpermosoRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.PermisoRol[ idpermosoRol=" + idpermosoRol + " ]";
    }
    
}
