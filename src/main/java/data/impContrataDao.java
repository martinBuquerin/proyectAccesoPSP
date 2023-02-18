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

    public List<Contrata> seleccionaContrato() {
        return this.em.createNamedQuery("Contrato.findAll").getResultList();
    }

    public void insertarContrato(Contrata contrato) {
        this.em.persist(contrato);
    }

    public void eliminarContrato(Contrata contrato) {
        this.em.remove(this.em.merge(contrato));
    }

    public void actualizarContrato(Contrata contrato) {
        this.em.merge(contrato);
    }

    public Contrata buscarClientePorId(Contrata contrato) {
        return (Contrata) this.em.find(Contrata.class, contrato.getIdContrato());
    }
}
