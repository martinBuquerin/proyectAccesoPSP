package data;

import domain.Servicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class impServicioDao implements iServicioDao {

    @PersistenceContext(unitName = "data")
    EntityManager em;

    @Override
    public List<Servicio> seleccionaServicio() {
        return this.em.createNamedQuery("Servicio.findAll").getResultList();
    }

    @Override
    public void insertarServicio(Servicio servicio) {
        this.em.persist(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        this.em.remove(this.em.merge(servicio));
    }

    @Override
    public void actualizarServicio(Servicio servicio) {
        this.em.merge(servicio);
    }

    @Override
    public Servicio buscarServicioPorId(Servicio servicio) {
        return (Servicio) this.em.find(Servicio.class, servicio.getIdServicio());
    }
}
