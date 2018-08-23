/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "historico_inventario")
@NamedQueries({
    @NamedQuery(name = "HistoricoInventario.findAll", query = "SELECT h FROM HistoricoInventario h")})
public class HistoricoInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistorico_inventario")
    private Integer idhistoricoInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactivoproducto")
    private int idactivoproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estadohistorico_inventario")
    private String estadohistoricoInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahistorico_inventario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahistoricoInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_sede", referencedColumnName = "idsede")
    @ManyToOne(optional = false)
    private Sede idSede;

    public HistoricoInventario() {
    }

    public HistoricoInventario(Integer idhistoricoInventario) {
        this.idhistoricoInventario = idhistoricoInventario;
    }

    public HistoricoInventario(Integer idhistoricoInventario, int idactivoproducto, int cantidad, String estadohistoricoInventario, Date fechahistoricoInventario, String tipo) {
        this.idhistoricoInventario = idhistoricoInventario;
        this.idactivoproducto = idactivoproducto;
        this.cantidad = cantidad;
        this.estadohistoricoInventario = estadohistoricoInventario;
        this.fechahistoricoInventario = fechahistoricoInventario;
        this.tipo = tipo;
    }

    public Integer getIdhistoricoInventario() {
        return idhistoricoInventario;
    }

    public void setIdhistoricoInventario(Integer idhistoricoInventario) {
        this.idhistoricoInventario = idhistoricoInventario;
    }

    public int getIdactivoproducto() {
        return idactivoproducto;
    }

    public void setIdactivoproducto(int idactivoproducto) {
        this.idactivoproducto = idactivoproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadohistoricoInventario() {
        return estadohistoricoInventario;
    }

    public void setEstadohistoricoInventario(String estadohistoricoInventario) {
        this.estadohistoricoInventario = estadohistoricoInventario;
    }

    public Date getFechahistoricoInventario() {
        return fechahistoricoInventario;
    }

    public void setFechahistoricoInventario(Date fechahistoricoInventario) {
        this.fechahistoricoInventario = fechahistoricoInventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistoricoInventario != null ? idhistoricoInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoInventario)) {
            return false;
        }
        HistoricoInventario other = (HistoricoInventario) object;
        if ((this.idhistoricoInventario == null && other.idhistoricoInventario != null) || (this.idhistoricoInventario != null && !this.idhistoricoInventario.equals(other.idhistoricoInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.HistoricoInventario[ idhistoricoInventario=" + idhistoricoInventario + " ]";
    }
    
}
