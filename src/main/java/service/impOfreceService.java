/*    */ package service;
/*    */ 
/*    */ import data.iOfreceDao;
/*    */ import domain.Ofrece;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ @Stateless
/*    */ public class impOfreceService implements iOfreceService {
/*    */   @Inject
/*    */   private iOfreceDao ofreceDao;
/*    */   
/*    */   public List<Ofrece> seleccionaServicioOfrecido() {
/* 24 */     return this.ofreceDao.seleccionaOfrece();
/*    */   }
/*    */   
/*    */   public void insertarServicioOfrecido(Ofrece ofrece) {
/* 29 */     this.ofreceDao.insertarOfrece(ofrece);
/*    */   }
/*    */   
/*    */   public void eliminarServicioOfrecido(Ofrece ofrece) {
/* 34 */     this.ofreceDao.eliminarOfrece(ofrece);
/*    */   }
/*    */   
/*    */   public void actualizarServicioOfrecido(Ofrece ofrece) {
/* 39 */     this.ofreceDao.actualizarOfrece(ofrece);
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\impOfreceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */