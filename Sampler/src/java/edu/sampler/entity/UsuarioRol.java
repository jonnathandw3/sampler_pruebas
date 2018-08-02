/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "usuario_rol")
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariorol")
    private Integer idusuariorol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuariorol")
    private Collection<Autenticado> autenticadoCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_rol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol idRol;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public Integer getIdusuariorol() {
        return idusuariorol;
    }

    public void setIdusuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public Collection<Autenticado> getAutenticadoCollection() {
        return autenticadoCollection;
    }

    public void setAutenticadoCollection(Collection<Autenticado> autenticadoCollection) {
        this.autenticadoCollection = autenticadoCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariorol != null ? idusuariorol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.idusuariorol == null && other.idusuariorol != null) || (this.idusuariorol != null && !this.idusuariorol.equals(other.idusuariorol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.UsuarioRol[ idusuariorol=" + idusuariorol + " ]";
    }
    
}
