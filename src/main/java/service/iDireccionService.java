package service;

import domain.Direccion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iDireccionService {
  List<Direccion> seleccionaDireccion();
  
  void insertarDireccion(Direccion paramDireccion);
  
  void eliminarDireccion(Direccion paramDireccion);
  
  void actualizarDireccion(Direccion paramDireccion);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\iDireccionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */