package data;

import domain.Contrata;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class impContrataDao implements iContrataDao, Serializable {

    @PersistenceContext(unitName = "data")
    EntityManager em;

    @Override
    public List<Contrata> seleccionaContrato() {
        return this.em.createNamedQuery("Contrato.findAll").getResultList();
    }

    @Override
    public void insertarContrato(Contrata contrato) {
        this.em.persist(contrato);
    }

    @Override
    public void eliminarContrato(Contrata contrato) {
        this.em.remove(this.em.merge(contrato));
    }

    @Override
    public void actualizarContrato(Contrata contrato) {
        this.em.merge(contrato);
    }

    @Override
    public Contrata buscarClientePorId(Contrata contrato) {
        return (Contrata) this.em.find(Contrata.class, contrato.getIdContrato());
    }
}
