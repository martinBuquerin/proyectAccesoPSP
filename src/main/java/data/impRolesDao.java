package data;

import domain.Roles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class impRolesDao implements iRolesDao {

    @PersistenceContext(unitName = "data")
    EntityManager em = null;

    @Override
    public List<Roles> seleccionaRol() {
        List<Roles> roles = this.em.createNamedQuery("Roles.findAll").getResultList();
        return roles;
    }

    @Override
    public Roles buscarRolPorNombre(String rol) {
        Query buscarPorNombre = this.em.createNamedQuery("Roles.findByNombre");
        buscarPorNombre.setParameter("nombre", rol);
        Roles roles = (Roles) buscarPorNombre.getSingleResult();
        return roles;
    }

    @Override
    public void insertarRol(Roles rol) {
        this.em.persist(rol);
    }

    @Override
    public void eliminarRol(Roles rol) {
        this.em.remove(this.em.merge(rol));
    }

    @Override
    public void actualizarRol(Roles rol) {
        this.em.merge(rol);
    }
}
