/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sebas
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SamplerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
@Override
    public Usuario validarUsuarioLogueado(String usuario, String clave) {
        Usuario usuarioLogin = null;
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.password = :clave ");

            q.setParameter("usuario", usuario);
            q.setParameter("clave", clave);
            List<Usuario> usuLista = q.getResultList();

            if (!usuLista.isEmpty()) {
                usuarioLogin = usuLista.get(0);
            }

        } catch (Exception e) {
        }
        return usuarioLogin;
    }

    @Override
    public Usuario consultaUsuario(String correo, String documento) {
        Usuario usuarioTest = null;
        try {
            Query q = em.createQuery("SELECT c FROM Usuario c WHERE c.documento = :documento OR c.email = :correo");
            q.setParameter("documento", documento);
            q.setParameter("correo", correo);

            List<Usuario> listaUsuarios = q.getResultList();

            if (!listaUsuarios.isEmpty()) {
                usuarioTest = listaUsuarios.get(0);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return usuarioTest;
    }
}