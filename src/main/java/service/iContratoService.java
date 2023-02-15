package service;

import domain.Contrata;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iContratoService {
  List<Contrata> seleccionaContrato();
  
  void insertarContrato(Contrata paramContrata);
  
  void eliminarContrato(Contrata paramContrata);
  
  void actualizarContrato(Contrata paramContrata);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\service\iContratoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */