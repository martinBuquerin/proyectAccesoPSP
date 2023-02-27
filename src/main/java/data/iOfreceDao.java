package data;

import domain.Ofrece;
import java.util.List;


public interface iOfreceDao {

    List<Ofrece> seleccionaOfrece();

      public Ofrece buscarOfrecePorId(int ofrece);

    List<Ofrece> buscarOfrecePorEmail(String usuario);

    void insertarOfrece(Ofrece ofrece);

    void eliminarOfrece(Ofrece ofrece);

    void actualizarOfrece(Ofrece ofrece);
}
