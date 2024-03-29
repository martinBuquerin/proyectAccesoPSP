package web;

import domain.Contrata;
import domain.Ofrece;
import domain.Servicio;
import domain.Usuario;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import service.iContratoService;
import service.iOfreceService;
import service.iRolesService;
import service.iServicioService;
import service.iUsuarioService;

@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class usuario extends HttpServlet {

    @Inject
    private iUsuarioService usuarioDao;
    @Inject
    private iContratoService contratoDao;
    @Inject
    private iOfreceService ofreceDao;
    @Inject
    private iServicioService servicioDao;
    @Inject
    private iRolesService rolDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        if (accion != null) {
            switch (accion) {
                case "contratarServicio":
                    contratarServicio(request, response);
                    break;
                case "editarPerfil":
                    editarUsuario(request, response);
                    break;
                case "verContratos":
                    String idUsuario = request.getParameter("id");
                    Usuario usuarioConectado = new Usuario(idUsuario);
                    List<Contrata> contratos = contratoDao.buscarContratosPorId(usuarioConectado);
                    System.out.println("contratos buscado por email" + contratos);

                    //System.out.println(profesionalOfrece);
                    sesion.setAttribute("contratos", contratos);
                    response.sendRedirect("usuarioContrata.jsp");
                    break;
                case "verPerfil":
                    verUsuario(request, response);
                    break;
                case "verServicios":
                    List<Servicio> servicios = servicioDao.seleccionaServicio();

                    sesion.setAttribute("servicios", servicios);
                    response.sendRedirect("servicioCards.jsp");

                    break;
                case "verServiciosPorId":
                    int idServicio = Integer.parseInt(request.getParameter("id"));
                    System.out.println("id Del Servicio " + idServicio);
                    List<Servicio> serviciosPorId = new ArrayList<>();
                    serviciosPorId = servicioDao.seleccionaServicio();
                    List<Usuario> profesionales = new ArrayList<>();
                    profesionales = usuarioDao.seleccionaUsuario();

                    List<Ofrece> profesionalOfrece = new ArrayList<>();
                    profesionalOfrece = ofreceDao.seleccionaOfrece();

                    System.out.println("Lista de servicios " + serviciosPorId);
                    for (int ii = 0; ii < profesionales.size(); ii++) {
                        String rolUsuario = profesionales.get(ii).getRolesidRol().getNombre();
                        if (!rolUsuario.equals("Profesional")) {
                            profesionales.remove(profesionales.get(ii));
                        }

                    }
                    System.out.println("Lista de profesionales " + profesionales);
                    int servicio = 0;
                    System.out.println("Lista de ofrece " + profesionalOfrece);
                    List<Ofrece> profesionalOfreceFinal = new ArrayList<>();
                    for (int l = 0; l < profesionalOfrece.size(); l++) {
                        servicio = profesionalOfrece.get(l).getServicioidServicio().getIdServicio();
                        if (servicio == idServicio) {
                            profesionalOfreceFinal.add(profesionalOfrece.get(l));
                            System.out.println(" profesionalOfrece.get(l).getServicioidServicio().getIdServicio()" + profesionalOfrece.get(l).getServicioidServicio().getIdServicio());
                        }
                    }

                    for (int i = 0; i < profesionalOfreceFinal.size(); i++) {
                        System.out.println("profesionalOfreceFinal con el mismo idServicio" + profesionalOfreceFinal.get(i).getServicioidServicio().getIdServicio());
                    }

                    sesion.setAttribute("servicios", profesionalOfreceFinal);
                    response.sendRedirect("servicioCardsPorCat.jsp");

                    break;

            }
        } else {
            // accionDefault(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        if (accion != null) {
            String nombre;
            List<Usuario> usuarios = new ArrayList<>();
            List<Usuario> profesionalesSinFiltrar = new ArrayList<>();

            switch (accion) {
                case "buscarServicio":
                    nombre = request.getParameter("servicio");
                    System.out.println("servicio " + nombre);
                    if (nombre == null) {
                        nombre = " ";
                    }
                    System.out.println("servicio " + nombre);
                    usuarios = this.usuarioDao.seleccionaUsuario();

                    profesionalesSinFiltrar = this.usuarioDao.buscarUsuarioPorRol(usuarios);
                    for (int i = 0; i < profesionalesSinFiltrar.size(); i++) {
                        System.out.println("profesionalesDespuesdeROL " + profesionalesSinFiltrar.get(i).getRolesidRol().getIdRol());
                    }
                    List<Usuario> profesionales = new ArrayList<>();
                    profesionales = this.usuarioDao.buscarPorServicio(nombre);
                    for (int i = 0; i < profesionales.size(); i++) {
                        System.out.println("despuesDbuscarPorServicio " + profesionales.get(i).getNombre());
                    }
                    sesion.setAttribute("servicios", profesionales);
                    response.sendRedirect("servicioCard.jsp");
                    break;
                case "validarLogin":
                    validarLogin(request, response);
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

        }
    }

    /*
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        //int imageId = Integer.parseInt(request.getParameter("id"));

        // Connect to the database
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecth?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");

            // Prepare a SELECT statement to retrieve the image data
            stmt = con.prepareStatement("SELECT imagen FROM usuario WHERE email = ?");
            stmt.setString(1, "han@gmail.com");
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Get the image data as a byte array
                byte[] imageData = rs.getBytes("imagen");

                // Set the content type and output stream
                response.setContentType("image/jpeg"); // Change to the appropriate MIME type for your image
                OutputStream out = response.getOutputStream();
                out.write(imageData);
                out.flush();
                out.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle any exceptions
            e.printStackTrace();
        } finally {
            // Close the database connection and statement
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // Handle any exceptions
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // Handle any exceptions
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // Handle any exceptions
                    e.printStackTrace();
                }
            }
        }
    }*/
    private void validarLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession();
        String email;
        String contrasena;
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
                        System.out.println(usuariosLogin.get(i));
                        userConectado = this.usuarioDao.buscarUsuarioPorEmail(userConectado);
                        sesion.setAttribute("email", userConectado);
                        response.sendRedirect("administrador.jsp");
                    } else if (rolUsuario.equals("Cliente")) {
                        System.out.println(usuariosLogin.get(i));
                        userConectado = this.usuarioDao.buscarUsuarioPorEmail(userConectado);
                        sesion.setAttribute("email", userConectado);
                        response.sendRedirect("index.jsp");
                    } else if (rolUsuario.equals("Profesional")) {
                        System.out.println(usuariosLogin.get(i));
                        userConectado = this.usuarioDao.buscarUsuarioPorEmail(userConectado);
                        sesion.setAttribute("email", userConectado);
                        response.sendRedirect("index.jsp");
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    private void contratarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int idOfrece = Integer.parseInt(request.getParameter("profesional"));
        String email = request.getParameter("correo");
        System.out.println("idOfrece desde servlet usuario" + idOfrece);
        System.out.println("email usuario desde servlet usuario para contratar" + email);

        if (email == null) {
            System.out.println("no tiene correo aca redirigir al modalLogin");
            response.sendRedirect("#modalLogin");
            return;
        } else {

            Ofrece ofrece = new Ofrece(idOfrece);
            ofrece = ofreceDao.buscarOfrecePorId(idOfrece);

            System.out.println("ofrece" + ofrece.getIdOfrece());
            Usuario usuarioProfesionaContratado = new Usuario(ofrece.getUsuarioEmail().getEmail());
            Usuario usuarioContratando = new Usuario(email);
            usuarioProfesionaContratado = this.usuarioDao.buscarUsuarioPorEmail(usuarioProfesionaContratado);
            usuarioContratando = this.usuarioDao.buscarUsuarioPorEmail(usuarioContratando);
            System.out.println("usuarioProfesionaContratado" + usuarioProfesionaContratado);
            System.out.println("usuarioContratando" + usuarioContratando);
            // busqueda de ofrecidos por email de profesional

            //List<Ofrece> profesionalOfrece = this.ofreceDao.buscarOfrecePorEmail(profesional);
            Contrata contrato = new Contrata(ofrece, usuarioContratando);
            System.out.println("contrato creado" + contrato);
            contratoDao.insertarContrato(contrato);
            List<Contrata> contratos = contratoDao.buscarContratosPorId(usuarioContratando);
            System.out.println("contratos buscado por email" + contratos);

            //System.out.println(profesionalOfrece);
            sesion.setAttribute("contratos", contratos);
            response.sendRedirect("usuarioContrata.jsp");

        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = this.usuarioDao.seleccionaUsuario();
        request.setAttribute("personas", usuarios);
        response.sendRedirect("test.jsp");
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
        response.sendRedirect("perfilEditar.jsp");
    }

    public void verUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        response.sendRedirect("perfil.jsp");
    }

}
