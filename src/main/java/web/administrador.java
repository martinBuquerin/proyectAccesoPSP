/*     */ package web;
/*     */ 
/*     */ import domain.Direccion;
/*     */ import domain.Roles;
/*     */ import domain.Usuario;
/*     */ import java.io.IOException;
/*     */ import java.sql.Date;
/*     */ import java.time.LocalDate;
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
/*     */ import service.iDireccionService;
/*     */ import service.iRolesService;
/*     */ import service.iUsuarioService;
/*     */ 
/*     */ @WebServlet(name = "administrador", urlPatterns = {"/administrador"})
/*     */ public class administrador extends HttpServlet {
/*     */   @Inject
/*     */   private iUsuarioService usuarioDao;
/*     */   
/*     */   @Inject
/*     */   private iDireccionService direccionDao;
/*     */   
/*     */   @Inject
/*     */   private iRolesService rolDao;
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  67 */     String accion = request.getParameter("accion");
/*  68 */     HttpSession sesion = request.getSession();
/*  69 */     if (accion != null) {
/*     */       List<Roles> rol;
/*     */       String idEliminar;
/*     */       Usuario eliminar;
/*     */       String id;
/*     */       Usuario req;
/*     */       List<Usuario> usuarios;
/*     */       List<Usuario> usuariosPro;
/*     */       List<Usuario> profesionales;
/*     */       List<Direccion> direcciones;
/*  71 */       switch (accion) {
/*     */         case "registro":
/*  73 */           rol = this.rolDao.seleccionaRol();
/*  74 */           System.out.println("roles en registro" + rol);
/*  75 */           sesion.setAttribute("roles", rol);
/*  77 */           response.sendRedirect("header.jsp");
/*     */           break;
/*     */         case "eliminar":
/*  86 */           idEliminar = request.getParameter("id");
/*  87 */           System.out.println(idEliminar);
/*  88 */           eliminar = new Usuario(idEliminar);
/*  89 */           System.out.println("usuasrio creado con exito" + eliminar);
/*  90 */           eliminar = this.usuarioDao.buscarUsuarioPorEmail(eliminar);
/*  92 */           System.out.println("devuelta en administrador servlet" + eliminar);
/*  93 */           this.usuarioDao.eliminarUsuario(eliminar);
/*  96 */           response.sendRedirect("administrador.jsp");
/*     */           break;
/*     */         case "editar":
/* 102 */           id = request.getParameter("id");
/* 103 */           System.out.println(id);
/* 104 */           req = new Usuario(id);
/* 105 */           System.out.println("usuario creado con exito" + req);
/* 106 */           req = this.usuarioDao.buscarUsuarioPorEmail(req);
/* 108 */           System.out.println("devuelta en administrador servlet" + req);
/* 109 */           sesion.setAttribute("usuario", req);
/* 111 */           response.sendRedirect("editarperfil.jsp");
/*     */           break;
/*     */         case "verUsuarios":
/* 115 */           usuarios = this.usuarioDao.seleccionaUsuario();
/* 116 */           System.out.println(usuarios);
/* 117 */           sesion.setAttribute("usuarios", usuarios);
/* 118 */           response.sendRedirect("usuariosCards.jsp");
/*     */           break;
/*     */         case "verProfesionales":
/* 122 */           usuariosPro = this.usuarioDao.seleccionaUsuario();
/* 124 */           profesionales = this.usuarioDao.buscarUsuarioPorRol(usuariosPro);
/* 125 */           System.out.println(profesionales);
/* 128 */           sesion.setAttribute("usuarios", profesionales);
/* 130 */           response.sendRedirect("usuarios.jsp");
/*     */           break;
/*     */         case "verDirecciones":
/* 133 */           direcciones = this.direccionDao.seleccionaDireccion();
/* 134 */           System.out.println(direcciones);
/* 135 */           sesion.setAttribute("direcciones", direcciones);
/* 137 */           response.sendRedirect("direcciones.jsp");
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 175 */     String accion = request.getParameter("accion");
/* 176 */     HttpSession sesion = request.getSession();
/* 177 */     if (accion != null) {
/*     */       String email, contraFormulario, rol;
/*     */       Roles rols;
/*     */       Date fechaAlta;
/*     */       String emailUsuario, nombreActualizado, apellidoActualizado, telefonoActualizado, contrasenaActualizado, nombreEmpresaActualizado, descripcionEmpresaActualizado;
/*     */       Usuario usuarioActualizado;
/* 178 */       List<Usuario> usuarios = null;
/* 179 */       switch (accion) {
/*     */         case "insertar":
/* 184 */           email = request.getParameter("email");
/* 185 */           contraFormulario = request.getParameter("contrasena");
/* 186 */           rol = request.getParameter("rol");
/* 187 */           rols = new Roles(rol);
/* 190 */           fechaAlta = Date.valueOf(LocalDate.now());
/* 194 */           rols = this.rolDao.buscarRolPorNombre(rol);
/*     */           try {
/* 199 */             String contrasena = this.usuarioDao.contraCript(contraFormulario);
/* 200 */             Usuario u1 = new Usuario(email, fechaAlta, contrasena, rols);
/* 201 */             this.usuarioDao.insertarUsuario(u1);
/* 202 */             response.sendRedirect("index.jsp");
/* 203 */           } catch (Exception ex) {
/* 204 */             Logger.getLogger(administrador.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */           } 
/*     */           break;
/*     */         case "enviarUpdate":
/* 209 */           emailUsuario = request.getParameter("id");
/* 210 */           nombreActualizado = request.getParameter("nombreEditado");
/* 211 */           apellidoActualizado = request.getParameter("apellidoEditado");
/* 213 */           telefonoActualizado = request.getParameter("telefonoEditado");
/* 214 */           contrasenaActualizado = request.getParameter("contrasenaEditado");
/* 215 */           nombreEmpresaActualizado = request.getParameter("nombreEmpresa");
/* 216 */           descripcionEmpresaActualizado = request.getParameter("descripcionEmpresa");
/* 217 */           System.out.println(emailUsuario);
/* 218 */           usuarioActualizado = new Usuario(emailUsuario);
/* 219 */           usuarioActualizado = this.usuarioDao.buscarUsuarioPorEmail(usuarioActualizado);
/* 220 */           System.out.println("ususario creado y buscardo por email" + usuarioActualizado);
/* 221 */           usuarioActualizado.setNombre(nombreActualizado);
/* 222 */           usuarioActualizado.setApellido(apellidoActualizado);
/* 223 */           usuarioActualizado.setTelefono(telefonoActualizado);
/*     */           try {
/* 226 */             contrasenaActualizado = this.usuarioDao.contraCript(contrasenaActualizado);
/* 228 */           } catch (Exception ex) {
/* 229 */             Logger.getLogger(administrador.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */           } 
/* 232 */           usuarioActualizado.setContrasena(contrasenaActualizado);
/* 233 */           usuarioActualizado.setNombreEmpresa(nombreEmpresaActualizado);
/* 234 */           usuarioActualizado.setDescripcionEmpresa(descripcionEmpresaActualizado);
/* 235 */           System.out.println(usuarioActualizado);
/* 236 */           this.usuarioDao.actualizarUsuario(usuarioActualizado);
/* 237 */           response.sendRedirect("administrador.jsp");
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getServletInfo() {
/* 255 */     return "Short description";
/*     */   }
/*     */ }


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\web\administrador.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */