package data;

import domain.Ofrece;
import java.util.List;

public interface iOfreceDao {
  List<Ofrece> seleccionaOfrece();
  
  Ofrece buscarOfrecePorId(Ofrece paramOfrece);
  
  void insertarOfrece(Ofrece paramOfrece);
  
  void eliminarOfrece(Ofrece paramOfrece);
  
  void actualizarOfrece(Ofrece paramOfrece);
}


/* Location:              C:\Users\Martin\Documents\DATA\segundo\accesoAdatos\paraPresentar\WEB-INF\classes\!\data\iOfreceDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */