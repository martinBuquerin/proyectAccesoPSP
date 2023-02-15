/*    */ package data;
/*    */ 
/*    */ import domain.Direccion;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ @Stateless
/*    */ public class impDireccionDao implements iDireccionDao {
/*    */   @PersistenceContext(unitName = "data")
/*    */   EntityManager em;
/*    */   
/*    */   public List<Direccion> seleccionarDireccion() {
/* 26 */     return this.em.createNamedQuery("Direccion.findAll").getResultList();
/*    */   }
/*    */   
/*    */   public void insertarDireccion(Direccion direccion) {
/* 31 */     this.em.persist(direccion);
/*    */   }
/*    */   
/*    */   public void eliminarDireccion(Direccion direccion) {
/* 36 */     this.em.remove(this.em.merge(direccion));
/*    */   }
/*    */   
/*    */   public void actualizarDireccion(Direccion direccion) {
/* 41 */     this.em.merge(direccion);
/*    */   }
/*    */   
/*    */   public Direccion buscarDireccionPorId(Direccion direccion) {
/* 46 */     return (Direccion)this.em.find(Direccion.class, direccion.getIdDireccion());
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\impDireccionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */