package data;

import domain.Contrata;
import java.util.List;

public interface iContrataDao {
  List<Contrata> seleccionaContrato();
  
  Contrata buscarClientePorId(Contrata paramContrata);
  
  void insertarContrato(Contrata paramContrata);
  
  void eliminarContrato(Contrata paramContrata);
  
  void actualizarContrato(Contrata paramContrata);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\iContrataDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */