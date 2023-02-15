/*    */ package service;
/*    */ 
/*    */ import data.iServicioDao;
/*    */ import domain.Servicio;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ @Stateless
/*    */ public class impServicioService implements iServicioService {
/*    */   @Inject
/*    */   private iServicioDao servicioDao;
/*    */   
/*    */   public List<Servicio> seleccionaContrato() {
/* 28 */     return this.servicioDao.seleccionaServicio();
/*    */   }
/*    */   
/*    */   public void insertarServicio(Servicio servicio) {
/* 33 */     this.servicioDao.insertarServicio(servicio);
/*    */   }
/*    */   
/*    */   public void eliminarServicio(Servicio servicio) {
/* 38 */     this.servicioDao.eliminarServicio(servicio);
/*    */   }
/*    */   
/*    */   public void actualizarServicio(Servicio servicio) {
/* 43 */     this.servicioDao.actualizarServicio(servicio);
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\impServicioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */