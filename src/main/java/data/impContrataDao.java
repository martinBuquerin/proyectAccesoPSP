/*    */ package data;
/*    */ 
/*    */ import domain.Contrata;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ @Stateless
/*    */ public class impContrataDao implements iContrataDao, Serializable {
/*    */   @PersistenceContext(unitName = "data")
/*    */   EntityManager em;
/*    */   
/*    */   public List<Contrata> seleccionaContrato() {
/* 29 */     return this.em.createNamedQuery("Contrato.findAll").getResultList();
/*    */   }
/*    */   
/*    */   public void insertarContrato(Contrata contrato) {
/* 34 */     this.em.persist(contrato);
/*    */   }
/*    */   
/*    */   public void eliminarContrato(Contrata contrato) {
/* 39 */     this.em.remove(this.em.merge(contrato));
/*    */   }
/*    */   
/*    */   public void actualizarContrato(Contrata contrato) {
/* 45 */     this.em.merge(contrato);
/*    */   }
/*    */   
/*    */   public Contrata buscarClientePorId(Contrata contrato) {
/* 50 */     return (Contrata)this.em.find(Contrata.class, contrato.getIdContrato());
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\impContrataDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */