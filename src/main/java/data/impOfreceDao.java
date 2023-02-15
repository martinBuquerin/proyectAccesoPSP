/*    */ package data;
/*    */ 
/*    */ import domain.Ofrece;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ @Stateless
/*    */ public class impOfreceDao implements iOfreceDao {
/*    */   @PersistenceContext(unitName = "data")
/*    */   EntityManager em;
/*    */   
/*    */   public List<Ofrece> seleccionaOfrece() {
/* 28 */     return this.em.createNamedQuery("Ofrece.findAll").getResultList();
/*    */   }
/*    */   
/*    */   public void insertarOfrece(Ofrece ofrece) {
/* 33 */     this.em.persist(ofrece);
/*    */   }
/*    */   
/*    */   public void eliminarOfrece(Ofrece ofrece) {
/* 39 */     this.em.remove(this.em.merge(ofrece));
/*    */   }
/*    */   
/*    */   public void actualizarOfrece(Ofrece ofrece) {
/* 44 */     this.em.merge(ofrece);
/*    */   }
/*    */   
/*    */   public Ofrece buscarOfrecePorId(Ofrece ofrece) {
/* 49 */     return (Ofrece)this.em.find(Ofrece.class, ofrece.getIdOfrece());
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\impOfreceDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */