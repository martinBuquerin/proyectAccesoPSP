/*    */ package data;
/*    */ 
/*    */ import domain.Roles;
/*    */ import java.util.List;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ public class impRolesDao implements iRolesDao {
/*    */   @PersistenceContext(unitName = "data")
/* 21 */   EntityManager em = null;
/*    */   
/*    */   public List<Roles> seleccionaRol() {
/* 26 */     List<Roles> roles = this.em.createNamedQuery("Roles.findAll").getResultList();
/* 27 */     return roles;
/*    */   }
/*    */   
/*    */   public Roles buscarRolPorNombre(String rol) {
/* 32 */     Query buscarPorNombre = this.em.createNamedQuery("Roles.findByNombre");
/* 33 */     buscarPorNombre.setParameter("nombre", rol);
/* 34 */     Roles roles = (Roles)buscarPorNombre.getSingleResult();
/* 35 */     return roles;
/*    */   }
/*    */   
/*    */   public void insertarRol(Roles rol) {
/* 41 */     this.em.persist(rol);
/*    */   }
/*    */   
/*    */   public void eliminarRol(Roles rol) {
/* 46 */     this.em.remove(this.em.merge(rol));
/*    */   }
/*    */   
/*    */   public void actualizarRol(Roles rol) {
/* 51 */     this.em.merge(rol);
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\impRolesDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */