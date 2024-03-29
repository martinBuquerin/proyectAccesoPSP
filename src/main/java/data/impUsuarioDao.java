package data;

import domain.Ofrece;
import domain.Roles;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class impUsuarioDao implements iUsuarioDao {

    @PersistenceContext(unitName = "data")
    protected EntityManager em;

    @Override
    public List<Usuario> seleccionaUsuario() {
        List<Usuario> usuarios = this.em.createNamedQuery("Usuario.findAll").getResultList();

        return usuarios;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(Usuario email) {
        Query buscarPorEmail = this.em.createNamedQuery("Usuario.findByEmail");
        String correo = email.getEmail();
        buscarPorEmail.setParameter("email", correo);
        Usuario usuario = (Usuario) buscarPorEmail.getSingleResult();
        System.out.println("usuario creado con exito en impUsuarioDao" + usuario);
        return usuario;
    }

    @Override
    public List<Usuario> buscarPorServicio(String servicio) {

        TypedQuery<Usuario> consulta = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.nombreEmpresa LIKE :nombre ", Usuario.class);

        List<Usuario> resultado = new ArrayList<>();
        resultado = consulta.setParameter("nombre", "%" + servicio + "%").getResultList();
        System.out.println("resultadoDesdeConsulta.size"+resultado.size());
        return resultado;
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        this.em.persist(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        this.em.remove(this.em.merge(usuario));
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.em.merge(usuario);
    }

    @Override
    public List<Usuario> buscarUsuarioPorRol(Roles rol) {
        Query buscarPorRol = this.em.createNamedQuery("Roles.findByNombre");
        int id = rol.getIdRol().intValue();
        buscarPorRol.setParameter("rolesidRol", Integer.valueOf(id));
        List<Usuario> usuario = buscarPorRol.getResultList();
        return usuario;
    }

    @Override
    public Usuario buscarImagenes() {
        TypedQuery<Usuario> consulta = em.createQuery(
                "SELECT u.imagen FROM Usuario u WHERE u.email = :email ", Usuario.class);

        Usuario resultado = consulta.setParameter("email", "han@gmail.com").getSingleResult();

        byte[] imageBytes = resultado.getImagen();

        return resultado;
    }

}
