package service;

import domain.Direccion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iDireccionService {

    List<Direccion> seleccionaDireccion();

    void insertarDireccion(Direccion direccion);

    void eliminarDireccion(Direccion direccion);

    void actualizarDireccion(Direccion direccion);
}
