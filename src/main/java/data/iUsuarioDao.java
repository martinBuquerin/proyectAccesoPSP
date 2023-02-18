package data;

import domain.Roles;
import domain.Usuario;
import java.util.List;

public interface iUsuarioDao {

    List<Usuario> seleccionaUsuario();

    List<Usuario> buscarUsuarioPorRol(Roles paramRoles);

    Usuario buscarUsuarioPorEmail(Usuario paramUsuario);

    void insertarUsuario(Usuario paramUsuario);

    void eliminarUsuario(Usuario paramUsuario);

    void actualizarUsuario(Usuario paramUsuario);
}
