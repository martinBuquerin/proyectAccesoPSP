/*    */ package service;
/*    */ 
/*    */ import data.iDireccionDao;
/*    */ import domain.Direccion;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ @Stateless
/*    */ public class impDireccionService implements iDireccionService {
/*    */   @Inject
/*    */   private iDireccionDao direccionDao;
/*    */   
/*    */   public List<Direccion> seleccionaDireccion() {
/* 28 */     return this.direccionDao.seleccionarDireccion();
/*    */   }
/*    */   
/*    */   public void insertarDireccion(Direccion direccion) {
/* 33 */     this.direccionDao.insertarDireccion(direccion);
/*    */   }
/*    */   
/*    */   public void eliminarDireccion(Direccion direccion) {
/* 38 */     this.direccionDao.eliminarDireccion(direccion);
/*    */   }
/*    */   
/*    */   public void actualizarDireccion(Direccion direccion) {
/* 43 */     this.direccionDao.actualizarDireccion(direccion);
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\impDireccionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */