package data;

import domain.Ofrece;
import domain.Roles;
import domain.Usuario;
import java.util.List;

public interface iUsuarioDao {

    List<Usuario> seleccionaUsuario();

    List<Usuario> buscarUsuarioPorRol(Roles rol);

   public List<Usuario> buscarPorServicio(String servicio);

    Usuario buscarUsuarioPorEmail(Usuario usuario);

    void insertarUsuario(Usuario usuario);

    void eliminarUsuario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);

    public Usuario buscarImagenes();
}
