package data;

import domain.Direccion;
import java.util.List;

public interface iDireccionDao {
  List<Direccion> seleccionarDireccion();
  
  Direccion buscarDireccionPorId(Direccion paramDireccion);
  
  void insertarDireccion(Direccion paramDireccion);
  
  void eliminarDireccion(Direccion paramDireccion);
  
  void actualizarDireccion(Direccion paramDireccion);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\iDireccionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */