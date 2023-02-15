package service;

import domain.Roles;
import domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iUsuarioService {
  List<Usuario> seleccionaUsuario();
  
  void insertarUsuario(Usuario paramUsuario);
  
  void eliminarUsuario(Usuario paramUsuario);
  
  void actualizarUsuario(Usuario paramUsuario);
  
  List<Usuario> buscarUsuarioPorRol(Roles paramRoles);
  
  List<Usuario> buscarUsuarioPorRol(List<Usuario> paramList);
  
  String contraCript(String paramString) throws Exception;
  
  Usuario buscarUsuarioPorEmail(Usuario paramUsuario);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\iUsuarioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */