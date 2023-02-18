package data;

import domain.Direccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class impDireccionDao implements iDireccionDao {

    @PersistenceContext(unitName = "data")
    EntityManager em;

    public List<Direccion> seleccionarDireccion() {
        return this.em.createNamedQuery("Direccion.findAll").getResultList();
    }

    public void insertarDireccion(Direccion direccion) {
        this.em.persist(direccion);
    }

    public void eliminarDireccion(Direccion direccion) {
        this.em.remove(this.em.merge(direccion));
    }

    public void actualizarDireccion(Direccion direccion) {
        this.em.merge(direccion);
    }

    public Direccion buscarDireccionPorId(Direccion direccion) {
        return (Direccion) this.em.find(Direccion.class, direccion.getIdDireccion());
    }
}
