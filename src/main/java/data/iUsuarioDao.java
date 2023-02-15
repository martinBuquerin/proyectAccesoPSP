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


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\iUsuarioDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */