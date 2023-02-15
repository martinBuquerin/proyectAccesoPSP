/*    */ package service;
/*    */ 
/*    */ import data.iContrataDao;
/*    */ import domain.Contrata;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ @Stateless
/*    */ public class impContratoService implements iContratoService {
/*    */   @Inject
/*    */   private iContrataDao contratoDao;
/*    */   
/*    */   public List<Contrata> seleccionaContrato() {
/* 27 */     return this.contratoDao.seleccionaContrato();
/*    */   }
/*    */   
/*    */   public void insertarContrato(Contrata contrato) {
/* 32 */     this.contratoDao.insertarContrato(contrato);
/*    */   }
/*    */   
/*    */   public void eliminarContrato(Contrata contrato) {
/* 37 */     this.contratoDao.eliminarContrato(contrato);
/*    */   }
/*    */   
/*    */   public void actualizarContrato(Contrata contrato) {
/* 42 */     this.contratoDao.eliminarContrato(contrato);
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\impContratoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */