package web;

import domain.Direccion;
import domain.Roles;
import domain.Usuario;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.iDireccionService;
import service.iRolesService;
import service.iUsuarioService;

@WebServlet(name = "administrador", urlPatterns = {"/administrador"})
public class administrador extends HttpServlet {

    @Inject
    private iUsuarioService usuarioDao;

    @Inject
    private iDireccionService direccionDao;

    @Inject
    private iRolesService rolDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        if (accion != null) {
            List<Roles> rol;

            String idEliminar;
            Usuario eliminar;
            String id;
            Usuario req;

            List<Usuario> usuarios;
            List<Usuario> usuariosPro;

            List<Usuario> profesionales;
            List<Direccion> direcciones;

            switch (accion) {
                case "registro":
                    rol = this.rolDao.seleccionaRol();
                    System.out.println("roles en registro" + rol);
                    sesion.setAttribute("roles", rol);
                    response.sendRedirect("header.jsp");
                    break;
                case "eliminar":
                    idEliminar = request.getParameter("id");
                    System.out.println(idEliminar);
                    eliminar = new Usuario(idEliminar);
                    System.out.println("usuasrio creado con exito" + eliminar);
                    eliminar = this.usuarioDao.buscarUsuarioPorEmail(eliminar);
                    System.out.println("devuelta en administrador servlet" + eliminar);
                    this.usuarioDao.eliminarUsuario(eliminar);
                    response.sendRedirect("administrador.jsp");
                    break;
                case "editar":
                    id = request.getParameter("id");
                    System.out.println(id);
                    req = new Usuario(id);
                    System.out.println("usuario creado con exito en editar servet" + req);
                    req = this.usuarioDao.buscarUsuarioPorEmail(req);
                    System.out.println("devuelta en administrador servlet edit" + req);
                    sesion.setAttribute("usuario", req);
                    response.sendRedirect("editarperfil.jsp");
                    break;
                case "verUsuarios":
                    usuarios = this.usuarioDao.seleccionaUsuario();
                    System.out.println(usuarios);
                    sesion.setAttribute("usuarios", usuarios);
                    response.sendRedirect("usuariosCards.jsp");
                    break;
                case "verProfesionales":
                    usuariosPro = this.usuarioDao.seleccionaUsuario();
                    profesionales = this.usuarioDao.buscarUsuarioPorRol(usuariosPro);
                    System.out.println(profesionales);
                    sesion.setAttribute("usuarios", profesionales);
                    response.sendRedirect("usuarios.jsp");
                    break;
                case "verDirecciones":
                    direcciones = this.direccionDao.seleccionaDireccion();
                    System.out.println(direcciones);
                    sesion.setAttribute("direcciones", direcciones);
                    response.sendRedirect("direcciones.jsp");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();

        if (accion != null) {
            String email, contraFormulario, rol;
            Roles rols;
            Date fechaAlta;
            String emailUsuario, nombreActualizado, apellidoActualizado, telefonoActualizado, contrasenaActualizado, nombreEmpresaActualizado, descripcionEmpresaActualizado;
            Usuario usuarioActualizado;
            List<Usuario> usuarios = null;
            switch (accion) {
                case "insertar":
                    email = request.getParameter("email");
                    contraFormulario = request.getParameter("contrasena");
                    rol = request.getParameter("rol");
                    rols = new Roles(rol);
                    fechaAlta = Date.valueOf(LocalDate.now());
                    rols = this.rolDao.buscarRolPorNombre(rol);
                    try {
                        String contrasena = this.usuarioDao.contraCript(contraFormulario);
                        Usuario u1 = new Usuario(email, fechaAlta, contrasena, rols);
                        this.usuarioDao.insertarUsuario(u1);
                        response.sendRedirect("index.jsp");
                    } catch (Exception ex) {
                        Logger.getLogger(administrador.class.getName()).log(Level.SEVERE, (String) null, ex);
                    }
                    break;
                case "enviarUpdate":
                    emailUsuario = request.getParameter("id");
                    nombreActualizado = request.getParameter("nombreEditado");
                    apellidoActualizado = request.getParameter("apellidoEditado");
                    telefonoActualizado = request.getParameter("telefonoEditado");
                    contrasenaActualizado = request.getParameter("contrasenaEditado");
                    nombreEmpresaActualizado = request.getParameter("nombreEmpresa");
                    descripcionEmpresaActualizado = request.getParameter("descripcionEmpresa");
                    System.out.println(emailUsuario);
                    usuarioActualizado = new Usuario(emailUsuario);
                    usuarioActualizado = this.usuarioDao.buscarUsuarioPorEmail(usuarioActualizado);
                    System.out.println("usuario creado y buscado por email" + usuarioActualizado);
                    usuarioActualizado.setNombre(nombreActualizado);
                    usuarioActualizado.setApellido(apellidoActualizado);
                    usuarioActualizado.setTelefono(telefonoActualizado);
                    try {
                        contrasenaActualizado = this.usuarioDao.contraCript(contrasenaActualizado);
                    } catch (Exception ex) {
                        Logger.getLogger(administrador.class.getName()).log(Level.SEVERE, (String) null, ex);
                    }
                    usuarioActualizado.setContrasena(contrasenaActualizado);
                    usuarioActualizado.setNombreEmpresa(nombreEmpresaActualizado);
                    usuarioActualizado.setDescripcionEmpresa(descripcionEmpresaActualizado);
                    System.out.println(usuarioActualizado);
                    this.usuarioDao.actualizarUsuario(usuarioActualizado);
                    response.sendRedirect("administrador.jsp");
                    break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
