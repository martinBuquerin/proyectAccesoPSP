package data;

import domain.Contrata;
import domain.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    @Override
    public List<Contrata> buscarContratosPorId(Usuario usuario) {    


        TypedQuery<Contrata> buscarPorEmail = this.em.createQuery("SELECT c FROM Contrata c WHERE c.usuarioEmail = :usuarioEmail ", Contrata.class);
        String correo = usuario.getEmail();
        
        List<Contrata> contratos = buscarPorEmail.setParameter("usuarioEmail", usuario).getResultList();
   
        return contratos;
    }
}
