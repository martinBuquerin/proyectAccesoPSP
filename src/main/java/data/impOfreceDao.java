package data;

import domain.Ofrece;
import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    public Ofrece buscarOfrecePorId(int ofrece) {
            Ofrece ofreceSer = new Ofrece(ofrece);
         System.out.println("idOfrece" + ofrece );
          Query buscarOfrecePorId = em.createQuery(
                "SELECT o FROM Ofrece o WHERE o.idOfrece = :idOfrece ");
    
      
       Ofrece resultado = (Ofrece) buscarOfrecePorId.setParameter("idOfrece", ofrece).getSingleResult();
        
        System.out.println("resultado desde impofrecedao "+resultado);
        return resultado;
       
    }

    @Override
    public  List<Ofrece> buscarOfrecePorEmail(String usuario) {
         Usuario user = new Usuario(usuario);
         System.out.println("id bope" + usuario );
          Query buscarPorEmail = em.createQuery(
                "SELECT o FROM Ofrece o WHERE o.usuarioEmail = :usuarioEmail ");
    
      
         List<Ofrece> resultado = buscarPorEmail.setParameter("usuarioEmail", user).getResultList();
        
        System.out.println("resultado desde impofrecedao "+resultado);
        return resultado;
    }

}
