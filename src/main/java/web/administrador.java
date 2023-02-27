package web;

import domain.Direccion;
import domain.Roles;
import domain.Usuario;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;
import service.iDireccionService;
import service.iRolesService;
import service.iUsuarioService;


@MultipartConfig
@WebServlet(name = "administrador", urlPatterns = {"/administrador"})
public class administrador extends HttpServlet {
private javax.sql.DataSource myDataSource;
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

                    response.sendRedirect("administrador.jsp");
                    break;
                case "editar":
                    editarUsuario(request, response);

                    break;
                case "verUsuarios":
                    usuarios = this.usuarioDao.seleccionaUsuario();

                    
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

        if (accion != null) {
            HttpSession sesion = request.getSession();
            switch (accion) {
                case "insertar":
                    insertarUsuario(request, response);
                    break;
                case "enviarUpdate":
                    actualizarUsuario(request, response);
                    response.sendRedirect("administrador.jsp");
                    break;
            }
        }
    }

    public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession();
        String idEliminar;
        Usuario eliminar;
        idEliminar = request.getParameter("id");
        System.out.println(idEliminar);
        eliminar = new Usuario(idEliminar);
        System.out.println("usuasrio creado con exito" + eliminar);
        eliminar = this.usuarioDao.buscarUsuarioPorEmail(eliminar);
        System.out.println("devuelta en administrador servlet" + eliminar);
        this.usuarioDao.eliminarUsuario(eliminar);
    }

    public void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        String id;
        Usuario req;
        id = request.getParameter("id");
        System.out.println(id);
        req = new Usuario(id);
        System.out.println("usuario creado con exito en editar servet" + req);
        req = this.usuarioDao.buscarUsuarioPorEmail(req);
        System.out.println("devuelta en administrador servlet edit" + req);
        sesion.setAttribute("usuario", req);
        response.sendRedirect("editarperfil.jsp");
    }

    public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String emailUsuario, nombreActualizado, apellidoActualizado, telefonoActualizado, contrasenaActualizado, nombreEmpresaActualizado, descripcionEmpresaActualizado;
        Usuario usuarioActualizado;
        List<Usuario> usuarios = null;

        emailUsuario = request.getParameter("id");
        nombreActualizado = request.getParameter("nombreEditado");
        apellidoActualizado = request.getParameter("apellidoEditado");
        telefonoActualizado = request.getParameter("telefonoEditado");
        contrasenaActualizado = request.getParameter("contrasenaEditado");
        nombreEmpresaActualizado = request.getParameter("nombreEmpresa");
        descripcionEmpresaActualizado = request.getParameter("descripcionEmpresa");

        String name = request.getPart("foto").getSubmittedFileName();
//obtener el archivo temporal
        Part filePart = request.getPart("foto");
        long size = filePart.getSize();
        long max_size = 30000 * 30000;
        String type = filePart.getContentType();

        System.out.println("ruta " + name);
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] bytes = outputStream.toByteArray();
        //byte[] imageData = Files.readAllBytes(filePart.toPath());

        System.out.println(emailUsuario);
        usuarioActualizado = new Usuario(emailUsuario);
        usuarioActualizado = this.usuarioDao.buscarUsuarioPorEmail(usuarioActualizado);
        System.out.println("usuario creado y buscado por email" + usuarioActualizado);
        usuarioActualizado.setNombre(nombreActualizado);
        usuarioActualizado.setApellido(apellidoActualizado);
        usuarioActualizado.setTelefono(telefonoActualizado);
        usuarioActualizado.setImagen(bytes);

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

    }

    public void insertarUsuario(HttpServletRequest request, HttpServletResponse response) {
        String email, contraFormulario, rol;
        Roles rols;
        Date fechaAlta;
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

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
