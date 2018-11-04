/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public int cantidadUsuario(int estado);

    public Usuario consultaUsuario(String correo, String documento);

    public Usuario validarUsuarioLogueado(String usuario, String clave);
    
}
