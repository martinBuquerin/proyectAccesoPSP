package data;

import domain.Ofrece;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class impOfreceDao implements iOfreceDao {

    @PersistenceContext(unitName = "data")
    EntityManager em;

    @Override
    public List<Ofrece> seleccionaOfrece() {
        return this.em.createNamedQuery("Ofrece.findAll").getResultList();
    }

    @Override
    public void insertarOfrece(Ofrece ofrece) {
        this.em.persist(ofrece);
    }

    @Override
    public void eliminarOfrece(Ofrece ofrece) {
        this.em.remove(this.em.merge(ofrece));
    }

    @Override
    public void actualizarOfrece(Ofrece ofrece) {
        this.em.merge(ofrece);
    }

    @Override
    public Ofrece buscarOfrecePorId(Ofrece ofrece) {
        return (Ofrece) this.em.find(Ofrece.class, ofrece.getIdOfrece());
    }
}
