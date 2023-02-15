package data;

import domain.Servicio;
import java.util.List;

public interface iServicioDao {
  List<Servicio> seleccionaServicio();
  
  Servicio buscarServicioPorId(Servicio paramServicio);
  
  void insertarServicio(Servicio paramServicio);
  
  void eliminarServicio(Servicio paramServicio);
  
  void actualizarServicio(Servicio paramServicio);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\iServicioDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */