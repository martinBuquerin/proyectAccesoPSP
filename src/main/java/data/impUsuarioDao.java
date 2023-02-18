package data;

import domain.Roles;
import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class impUsuarioDao implements iUsuarioDao {

    @PersistenceContext(unitName = "data")
    protected EntityManager em;

    @Inject
    public iUsuarioDao usuarioDao;

    public List<Usuario> seleccionaUsuario() {
        List<Usuario> usuarios = this.em.createNamedQuery("Usuario.findAll").getResultList();
        return usuarios;
    }

    public Usuario buscarUsuarioPorEmail(Usuario email) {
        Query buscarPorEmail = this.em.createNamedQuery("Usuario.findByEmail");
        String correo = email.getEmail();
        buscarPorEmail.setParameter("email", correo);
        Usuario usuario = (Usuario) buscarPorEmail.getSingleResult();
        System.out.println("usuario creado con exito en impUsuarioDao" + usuario);
        return usuario;
    }

    public void insertarUsuario(Usuario usuario) {
        this.em.persist(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        this.em.remove(this.em.merge(usuario));
    }

    public void actualizarUsuario(Usuario usuario) {
        this.em.merge(usuario);
    }

    public List<Usuario> buscarUsuarioPorRol(Roles rol) {
        Query buscarPorRol = this.em.createNamedQuery("Roles.findByNombre");
        int id = rol.getIdRol().intValue();
        buscarPorRol.setParameter("rolesidRol", Integer.valueOf(id));
        List<Usuario> usuario = buscarPorRol.getResultList();
        return usuario;
    }
}
