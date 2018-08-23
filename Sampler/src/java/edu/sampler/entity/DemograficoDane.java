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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "demografico_dane")
@NamedQueries({
    @NamedQuery(name = "DemograficoDane.findAll", query = "SELECT d FROM DemograficoDane d")})
public class DemograficoDane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddane")
    private Integer iddane;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_dept")
    private int codigoDept;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_mpio")
    private int codigoMpio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_mpio")
    private String nomMpio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_dept")
    private String nomDept;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private Collection<Sede> sedeCollection;

    public DemograficoDane() {
    }

    public DemograficoDane(Integer iddane) {
        this.iddane = iddane;
    }

    public DemograficoDane(Integer iddane, int codigoDept, int codigoMpio, String nomMpio, String nomDept) {
        this.iddane = iddane;
        this.codigoDept = codigoDept;
        this.codigoMpio = codigoMpio;
        this.nomMpio = nomMpio;
        this.nomDept = nomDept;
    }

    public Integer getIddane() {
        return iddane;
    }

    public void setIddane(Integer iddane) {
        this.iddane = iddane;
    }

    public int getCodigoDept() {
        return codigoDept;
    }

    public void setCodigoDept(int codigoDept) {
        this.codigoDept = codigoDept;
    }

    public int getCodigoMpio() {
        return codigoMpio;
    }

    public void setCodigoMpio(int codigoMpio) {
        this.codigoMpio = codigoMpio;
    }

    public String getNomMpio() {
        return nomMpio;
    }

    public void setNomMpio(String nomMpio) {
        this.nomMpio = nomMpio;
    }

    public String getNomDept() {
        return nomDept;
    }

    public void setNomDept(String nomDept) {
        this.nomDept = nomDept;
    }

    public Collection<Sede> getSedeCollection() {
        return sedeCollection;
    }

    public void setSedeCollection(Collection<Sede> sedeCollection) {
        this.sedeCollection = sedeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddane != null ? iddane.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemograficoDane)) {
            return false;
        }
        DemograficoDane other = (DemograficoDane) object;
        if ((this.iddane == null && other.iddane != null) || (this.iddane != null && !this.iddane.equals(other.iddane))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.DemograficoDane[ iddane=" + iddane + " ]";
    }
    
}
