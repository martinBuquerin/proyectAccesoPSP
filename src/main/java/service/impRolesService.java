/*    */ package service;
/*    */ 
/*    */ import data.iRolesDao;
/*    */ import domain.Roles;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ @Stateless
/*    */ public class impRolesService implements iRolesService {
/*    */   @Inject
/*    */   public iRolesDao rolesDao;
/*    */   
/*    */   public List<Roles> seleccionaRol() {
/* 23 */     return this.rolesDao.seleccionaRol();
/*    */   }
/*    */   
/*    */   public Roles buscarRolPorNombre(String rol) {
/* 28 */     return this.rolesDao.buscarRolPorNombre(rol);
/*    */   }
/*    */   
/*    */   public void insertarRol(Roles rol) {
/* 33 */     this.rolesDao.insertarRol(rol);
/*    */   }
/*    */   
/*    */   public void eliminarRol(Roles rol) {
/* 38 */     this.rolesDao.eliminarRol(rol);
/*    */   }
/*    */   
/*    */   public void actualizarRol(Roles rol) {
/* 43 */     this.rolesDao.actualizarRol(rol);
/*    */   }
/*    */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\impRolesService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */