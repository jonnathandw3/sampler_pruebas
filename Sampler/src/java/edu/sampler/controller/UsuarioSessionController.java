/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.Rol;
import edu.sampler.entity.TipoDocumento;
import edu.sampler.entity.Usuario;
import edu.sampler.facade.RolFacadeLocal;
import edu.sampler.facade.TipoDocumentoFacadeLocal;
import edu.sampler.facade.UsuarioFacadeLocal;
import edu.sampler.model.JavaMail;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author sebas
 */
@Named(value = "usuarioSessionController")
@SessionScoped
public class UsuarioSessionController implements Serializable {

    /**
     * Creates a new instance of UsuarioSessionController
     */
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    RolFacadeLocal rolFacadeLocal;
    @EJB
    TipoDocumentoFacadeLocal tipoDocumentoFacadeLocal;

    private Usuario usuarioLogin;
    private Usuario usuarioGestion;
    private Usuario usuarioEliminar;
    private Rol rolGestion;
    private String usuario;
    private String clave;
    private String fechaCumple;
    private String estado;
    private String correo;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String tipoDocumento;
    private String documento;
    private String idRol;

    public UsuarioSessionController() {
    }

    public void cerrarSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml?faces-redirect=true");
    }

    public List<Usuario> todosUsuarios() {
        return usuarioFacadeLocal.findAll();
    }

    public List<Rol> todosRoles() {
        return rolFacadeLocal.findAll();
    }

    public List<TipoDocumento> todosTiposDocumento() {
        return tipoDocumentoFacadeLocal.findAll();
    }

    public void actualizarUsuario() {
        usuarioFacadeLocal.edit(usuarioGestion);
        usuarioGestion = null;
    }

    public void eliminarUsuario(Usuario usuarioEliminar) {
        usuarioFacadeLocal.remove(usuarioEliminar);

    }

    public String validarUsuarioLogueado() {
        String salida = "";

        try {
            usuarioLogin = usuarioFacadeLocal.validarUsuarioLogueado(usuario, clave);
            if (usuarioLogin != null) {
                return "Modules/mdl.reservas.dashboard.xhtml?faces-redirect=true";

            } else {
                this.usuario = "";
                this.clave = "";
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return salida;
    }

    public String ingresarNuevoUsuario() {

        LocalDate fecha = LocalDate.parse(fechaCumple, DateTimeFormatter.ISO_DATE);
        Date date = java.sql.Date.valueOf(fecha);
        Usuario usuarioNuevo = new Usuario();

        String usu = "usuario";
        String usuRed = usu.substring(0, 1) + apellido;
        usuRed = usuRed.toUpperCase();

        double numeroAleatori = Math.random() * 100000;
        int claveInt = (int) numeroAleatori;
        String clave = "" + claveInt;

        java.util.Date dates = new java.util.Date();
        long fechaSis = dates.getTime();
        Date now = new Date(fechaSis);

        usuarioNuevo.setUsuario(usuRed);
        usuarioNuevo.setPassword(clave);
        usuarioNuevo.setFechaCumple(date);
        usuarioNuevo.setFechaCreacion(now);
        usuarioNuevo.setEstado('1');
        usuarioNuevo.setEmail(correo);
        usuarioNuevo.setNombreUsuario(nombre);
        usuarioNuevo.setNombre2Usuario(nombre2);
        usuarioNuevo.setApellidoUsuario(apellido);
        usuarioNuevo.setApellido2Usuario(apellido2);
        usuarioNuevo.setTipoDocumento(tipoDocumentoFacadeLocal.find(Integer.parseInt(tipoDocumento)));
        usuarioNuevo.setDocumento(documento);
        usuarioNuevo.setIdRol(Integer.parseInt(idRol));

        JavaMail.sendClaves(usuarioNuevo.getEmail(), usuarioNuevo.getNombreUsuario() + " " + usuarioNuevo.getApellidoUsuario(), usuarioNuevo.getUsuario(), usuarioNuevo.getPassword());
        usuarioFacadeLocal.create(usuarioNuevo);
        this.usuario = "";
        this.clave = "";
        this.fechaCumple = "";
        this.estado = "";
        this.correo = "";
        this.nombre = "";
        this.nombre2 = "";
        this.apellido = "";
        this.apellido2 = "";
        this.tipoDocumento = "";
        this.documento = "";
        this.idRol = "";

        return null;

    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public Rol getRolGestion() {
        return rolGestion;
    }

    public void setRolGestion(Rol rolGestion) {
        this.rolGestion = rolGestion;
    }

    public String getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(String fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    public Usuario getUsuarioGestion() {
        return usuarioGestion;
    }

    public void setUsuarioGestion(Usuario usuarioGestion) {
        this.usuarioGestion = usuarioGestion;
    }

    public Usuario getUsuarioEliminar() {
        return usuarioEliminar;
    }

    public void setUsuarioEliminar(Usuario usuarioEliminar) {
        this.usuarioEliminar = usuarioEliminar;
    }

}
