package data;

import domain.Roles;
import java.util.List;

public interface iRolesDao {
  List<Roles> seleccionaRol();
  
  Roles buscarRolPorNombre(String paramString);
  
  void insertarRol(Roles paramRoles);
  
  void eliminarRol(Roles paramRoles);
  
  void actualizarRol(Roles paramRoles);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\iRolesDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */