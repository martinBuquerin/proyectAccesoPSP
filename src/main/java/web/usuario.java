package web;

import domain.Usuario;
import java.io.IOException;
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
import service.iRolesService;
import service.iUsuarioService;

@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class usuario extends HttpServlet {

    @Inject
    private iUsuarioService usuarioDao;

    @Inject
    private iRolesService rolDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        if (accion != null) {
            switch (accion) {

            }
        } else {
            accionDefault(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        if (accion != null) {
            String nombre;
            List<Usuario> usuarios;
            List<Usuario> profesionales;
            String email;
            String contrasena;
            switch (accion) {
                case "buscarServicio":
                    nombre = request.getParameter("servicio");
                    System.out.println(nombre);
                    usuarios = this.usuarioDao.seleccionaUsuario();
                    System.out.println(usuarios);
                    profesionales = this.usuarioDao.buscarUsuarioPorRol(usuarios);
                    System.out.println(profesionales);
                    sesion.setAttribute("profesionales", profesionales);
                    response.sendRedirect("profesionales.jsp");
                    break;
                case "validarLogin":
                    email = request.getParameter("email");
                    contrasena = request.getParameter("contrasena");
                    System.out.println("email " + email);
                    System.out.println("contraseña " + contrasena);
                    try {
                        contrasena = this.usuarioDao.contraCript(contrasena);
                        List<Usuario> usuariosLogin = this.usuarioDao.seleccionaUsuario();
                        System.out.println(usuariosLogin);
                        for (int i = 0; i < usuariosLogin.size(); i++) {
                            String correoUsuario = ((Usuario) usuariosLogin.get(i)).getEmail();
                            String contraUsuario = ((Usuario) usuariosLogin.get(i)).getContrasena();
                            if (correoUsuario.equals(email) && contraUsuario.equals(contrasena)) {
                                System.out.println("conectado");
                                correoUsuario = ((Usuario) usuariosLogin.get(i)).getEmail();
                                String rolUsuario = ((Usuario) usuariosLogin.get(i)).getRolesidRol().getNombre();
                                if (rolUsuario.equals("Administrador")) {
                                    sesion.setAttribute("email", correoUsuario);
                                    System.out.println(usuariosLogin.get(i));
                                    response.sendRedirect("administrador.jsp");
                                } else if (rolUsuario.equals("Cliente")) {
                                    sesion.setAttribute("email", correoUsuario);
                                    System.out.println(usuariosLogin.get(i));
                                    response.sendRedirect("index.jsp");
                                } else {
                                    sesion.setAttribute("email", correoUsuario);
                                    System.out.println(usuariosLogin.get(i));
                                    response.sendRedirect("profesional.jsp");
                                }
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, (String) null, ex);
                    }
                    break;
            }
        } else {
            accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.jsp");
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = this.usuarioDao.seleccionaUsuario();
        request.setAttribute("personas", usuarios);
        response.sendRedirect("test.jsp");
    }
}
