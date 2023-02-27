package service;

import domain.Ofrece;
import domain.Roles;
import domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iUsuarioService {

    List<Usuario> seleccionaUsuario();

    void insertarUsuario(Usuario usuario);

    void eliminarUsuario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);

    List<Usuario> buscarUsuarioPorRol(Roles usuario);

    List<Usuario> buscarUsuarioPorRol(List<Usuario> usuario);

    String contraCript(String contrasena) throws Exception;

    Usuario buscarUsuarioPorEmail(Usuario usuario);

   public List<Ofrece> buscarPorServicio();

    public Usuario buscarImagenes();
}
