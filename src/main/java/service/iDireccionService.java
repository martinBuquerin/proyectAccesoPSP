package service;

import domain.Direccion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iDireccionService {

    List<Direccion> seleccionaDireccion();

    void insertarDireccion(Direccion paramDireccion);

    void eliminarDireccion(Direccion paramDireccion);

    void actualizarDireccion(Direccion paramDireccion);
}
