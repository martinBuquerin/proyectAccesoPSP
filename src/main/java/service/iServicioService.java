package service;

import domain.Servicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iServicioService {
  List<Servicio> seleccionaContrato();
  
  void insertarServicio(Servicio paramServicio);
  
  void eliminarServicio(Servicio paramServicio);
  
  void actualizarServicio(Servicio paramServicio);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\iServicioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */