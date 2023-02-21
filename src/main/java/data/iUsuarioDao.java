package data;

import domain.Roles;
import domain.Usuario;
import java.util.List;
import javax.ejb.Local;


public interface iUsuarioDao {

    List<Usuario> seleccionaUsuario();

    List<Usuario> buscarUsuarioPorRol(Roles rol);
      
    List<Usuario>  buscarPorServicio(String servicio);

    Usuario buscarUsuarioPorEmail(Usuario usuario);

    void insertarUsuario(Usuario usuario);

    void eliminarUsuario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);
}
