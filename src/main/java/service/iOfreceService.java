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
