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
