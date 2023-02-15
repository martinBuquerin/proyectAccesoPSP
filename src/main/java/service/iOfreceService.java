package service;

import domain.Ofrece;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iOfreceService {
  List<Ofrece> seleccionaServicioOfrecido();
  
  void insertarServicioOfrecido(Ofrece paramOfrece);
  
  void eliminarServicioOfrecido(Ofrece paramOfrece);
  
  void actualizarServicioOfrecido(Ofrece paramOfrece);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\iOfreceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */