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
import javax.swing.JOptionPane;
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
                case "contratarServicio":
                    String profesional = request.getParameter("profesional");
                    String email = request.getParameter("email");
                    System.out.println("profesional desde servlet usuario" + profesional);
                    System.out.println("email usuario desde servlet usuario para contratar" + email);
                    if (email == null) {
                        System.out.println("no tiene correo aca redirigir al modalLogin");
                        response.sendRedirect("#modalLogin");
                        break;
                    }
                    break;
                case "editarPerfil":
                    String id = request.getParameter("id");
                    System.out.println(id);
                    Usuario requiereEditar = new Usuario(id);
                    System.out.println("usuario creado con exito en editarperfil servet" + requiereEditar);
                   
                    requiereEditar = this.usuarioDao.buscarUsuarioPorEmail(requiereEditar);
                   
                    System.out.println("devuelta en administrador servlet editusurio" + requiereEditar);
                     // a partir de aca redirigir al jsp de editaUsuario
                    sesion.setAttribute("usuario", requiereEditar);
                    response.sendRedirect("editarperfil.jsp");
                    break;

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
                    //System.out.println(nombre);
                    usuarios = this.usuarioDao.seleccionaUsuario();
                    //System.out.println(usuarios);
                    profesionales = this.usuarioDao.buscarUsuarioPorRol(usuarios);
                    profesionales = this.usuarioDao.buscarPorServicio(nombre);
                    sesion.setAttribute("profesionales", profesionales);
                    //System.out.println("resultado busqueda"+profesionales);
                    response.sendRedirect("busqueda.jsp");
                    break;
                case "validarLogin":
                    String emailLog = request.getParameter("email");
                    String contrasenaLog = request.getParameter("contrasena");
                    System.out.println("email " + emailLog);
                    System.out.println("contraseña " + contrasenaLog);
                    try {
                        contrasena = this.usuarioDao.contraCript(contrasenaLog);
                        List<Usuario> usuariosLogin = this.usuarioDao.seleccionaUsuario();
                        System.out.println(usuariosLogin);
                        for (int i = 0; i < usuariosLogin.size(); i++) {
                            String correoUsuario = ((Usuario) usuariosLogin.get(i)).getEmail();
                            String contraUsuario = ((Usuario) usuariosLogin.get(i)).getContrasena();
                            if (correoUsuario.equals(emailLog) && contraUsuario.equals(contrasena)) {
                                System.out.println("conectado");
                                correoUsuario = ((Usuario) usuariosLogin.get(i)).getEmail();
                                String rolUsuario = ((Usuario) usuariosLogin.get(i)).getRolesidRol().getNombre();
                                Usuario userConectado = new Usuario(correoUsuario);
                                if (rolUsuario.equals("Administrador")) {
                                    sesion.setAttribute("email", correoUsuario);
                                    System.out.println(usuariosLogin.get(i));
                                    userConectado = this.usuarioDao.buscarUsuarioPorEmail(userConectado);
                                    response.sendRedirect("administrador.jsp");
                                } else if (rolUsuario.equals("Cliente")) {
                                    System.out.println(usuariosLogin.get(i));
                                    userConectado = this.usuarioDao.buscarUsuarioPorEmail(userConectado);
                                    sesion.setAttribute("email", userConectado);
                                    response.sendRedirect("index.jsp");
                                } else if (rolUsuario.equals("Profesional")) {
                                    sesion.setAttribute("email", correoUsuario);
                                    System.out.println(usuariosLogin.get(i));
                                    userConectado = this.usuarioDao.buscarUsuarioPorEmail(userConectado);
                                    response.sendRedirect("profesional.jsp");
                                }
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, (String) null, ex);
                    }
                    break;
                case "validarCuenta":
                    String emailRegistro = request.getParameter("email");
                    String contrasenaRegistro = request.getParameter("contrasena");
                    System.out.println("email " + emailRegistro);
                    System.out.println("contraseña " + contrasenaRegistro);
                    System.out.println("");
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
