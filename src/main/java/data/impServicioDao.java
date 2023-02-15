/*    */ package data;
/*    */ 
/*    */ import domain.Servicio;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ @Stateless
/*    */ public class impServicioDao implements iServicioDao {
/*    */   @PersistenceContext(unitName = "data")
/*    */   EntityManager em;
/*    */   
/*    */   public List<Servicio> seleccionaServicio() {
/* 27 */     return this.em.createNamedQuery("Servicio.findAll").getResultList();
/*    */   }
/*    */   
/*    */   public void insertarServicio(Servicio servicio) {
/* 32 */     this.em.persist(servicio);
/*    */   }
/*    */   
/*    */   public void eliminarServicio(Servicio servicio) {
/* 37 */     this.em.remove(this.em.merge(servicio));
/*    */   }
/*    */   
/*    */   public void actualizarServicio(Servicio servicio) {
/* 42 */     this.em.merge(servicio);
/*    */   }
/*    */   
/*    */   public Servicio buscarServicioPorId(Servicio servicio) {
/* 47 */     return (Servicio)this.em.find(Servicio.class, servicio.getIdServicio());
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\impServicioDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */