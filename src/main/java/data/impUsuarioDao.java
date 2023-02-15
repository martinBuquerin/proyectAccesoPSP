/*     */ package data;
/*     */ 
/*     */ import domain.Roles;
/*     */ import domain.Usuario;
/*     */ import java.util.List;
/*     */ import javax.ejb.Stateless;
/*     */ import javax.inject.Inject;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.PersistenceContext;
/*     */ import javax.persistence.Query;
/*     */ 
/*     */ @Stateless
/*     */ public class impUsuarioDao implements iUsuarioDao {
/*     */   @PersistenceContext(unitName = "data")
/*     */   protected EntityManager em;
/*     */   
/*     */   @Inject
/*     */   public iUsuarioDao usuarioDao;
/*     */   
/*     */   public List<Usuario> seleccionaUsuario() {
/*  48 */     List<Usuario> usuarios = this.em.createNamedQuery("Usuario.findAll").getResultList();
/*  49 */     return usuarios;
/*     */   }
/*     */   
/*     */   public Usuario buscarUsuarioPorEmail(Usuario email) {
/*  54 */     Query buscarPorEmail = this.em.createNamedQuery("Usuario.findByEmail");
/*  55 */     String correo = email.getEmail();
/*  56 */     buscarPorEmail.setParameter("email", correo);
/*  57 */     Usuario usuario = (Usuario)buscarPorEmail.getSingleResult();
/*  58 */     System.out.println("usuario creado con exito en impUsuarioDao" + usuario);
/*  60 */     return usuario;
/*     */   }
/*     */   
/*     */   public void insertarUsuario(Usuario usuario) {
/* 106 */     this.em.persist(usuario);
/*     */   }
/*     */   
/*     */   public void eliminarUsuario(Usuario usuario) {
/* 112 */     this.em.remove(this.em.merge(usuario));
/*     */   }
/*     */   
/*     */   public void actualizarUsuario(Usuario usuario) {
/* 119 */     this.em.merge(usuario);
/*     */   }
/*     */   
/*     */   public List<Usuario> buscarUsuarioPorRol(Roles rol) {
/* 127 */     Query buscarPorRol = this.em.createNamedQuery("Roles.findByNombre");
/* 128 */     int id = rol.getIdRol().intValue();
/* 129 */     buscarPorRol.setParameter("rolesidRol", Integer.valueOf(id));
/* 130 */     List<Usuario> usuario = buscarPorRol.getResultList();
/* 132 */     return usuario;
/*     */   }
/*     */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\impUsuarioDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */