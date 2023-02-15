/*     */ package web;
/*     */ 
/*     */ import domain.Usuario;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.inject.Inject;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.annotation.WebServlet;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import service.iRolesService;
/*     */ import service.iUsuarioService;
/*     */ 
/*     */ @WebServlet(name = "usuario", urlPatterns = {"/usuario"})
/*     */ public class usuario extends HttpServlet {
/*     */   @Inject
/*     */   private iUsuarioService usuarioDao;
/*     */   
/*     */   @Inject
/*     */   private iRolesService rolDao;
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  36 */     String accion = request.getParameter("accion");
/*  37 */     HttpSession sesion = request.getSession();
/*  38 */     if (accion != null) {
/*  39 */       switch (accion) {
/*     */       
/*     */       } 
/*     */     } else {
/*  54 */       accionDefault(request, response);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  67 */     String accion = request.getParameter("accion");
/*  68 */     HttpSession sesion = request.getSession();
/*  69 */     if (accion != null) {
/*     */       String nombre;
/*     */       List<Usuario> usuarios;
/*     */       List<Usuario> profesionales;
/*     */       String email;
/*     */       String contrasena;
/*  70 */       switch (accion) {
/*     */         case "buscarServicio":
/*  73 */           nombre = request.getParameter("servicio");
/*  74 */           System.out.println(nombre);
/*  75 */           usuarios = this.usuarioDao.seleccionaUsuario();
/*  76 */           System.out.println(usuarios);
/*  77 */           profesionales = this.usuarioDao.buscarUsuarioPorRol(usuarios);
/*  78 */           System.out.println(profesionales);
/*  81 */           sesion.setAttribute("profesionales", profesionales);
/*  83 */           response.sendRedirect("profesionales.jsp");
/*     */           break;
/*     */         case "validarLogin":
/*  89 */           email = request.getParameter("email");
/*  90 */           contrasena = request.getParameter("contrasena");
/*  92 */           System.out.println("email " + email);
/*  93 */           System.out.println("contraseña " + contrasena);
/*     */           try {
/*  96 */             contrasena = this.usuarioDao.contraCript(contrasena);
/*  97 */             List<Usuario> usuariosLogin = this.usuarioDao.seleccionaUsuario();
/*  98 */             System.out.println(usuariosLogin);
/*  99 */             for (int i = 0; i < usuariosLogin.size(); i++) {
/* 101 */               String correoUsuario = ((Usuario)usuariosLogin.get(i)).getEmail();
/* 102 */               String contraUsuario = ((Usuario)usuariosLogin.get(i)).getContrasena();
/* 103 */               if (correoUsuario.equals(email) && contraUsuario.equals(contrasena)) {
/* 104 */                 System.out.println("conectado");
/* 105 */                 correoUsuario = ((Usuario)usuariosLogin.get(i)).getEmail();
/* 106 */                 String rolUsuario = ((Usuario)usuariosLogin.get(i)).getRolesidRol().getNombre();
/* 107 */                 if (rolUsuario.equals("Administrador")) {
/* 108 */                   sesion.setAttribute("email", correoUsuario);
/* 109 */                   System.out.println(usuariosLogin.get(i));
/* 110 */                   response.sendRedirect("administrador.jsp");
/* 111 */                 } else if (rolUsuario.equals("Cliente")) {
/* 112 */                   sesion.setAttribute("email", correoUsuario);
/* 113 */                   System.out.println(usuariosLogin.get(i));
/* 114 */                   response.sendRedirect("index.jsp");
/*     */                 } else {
/* 116 */                   sesion.setAttribute("email", correoUsuario);
/* 117 */                   System.out.println(usuariosLogin.get(i));
/* 118 */                   response.sendRedirect("profesional.jsp");
/*     */                 } 
/*     */               } 
/*     */             } 
/* 123 */           } catch (Exception ex) {
/* 124 */             Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } else {
/* 134 */       accionDefault(request, response);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
/* 140 */     response.sendRedirect("index.jsp");
/*     */   }
/*     */   
/*     */   private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 144 */     List<Usuario> usuarios = this.usuarioDao.seleccionaUsuario();
/* 148 */     request.setAttribute("personas", usuarios);
/* 151 */     response.sendRedirect("test.jsp");
/*     */   }
/*     */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\we\\usuario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */