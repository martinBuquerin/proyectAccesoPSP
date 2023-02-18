package data;

import domain.Direccion;
import java.util.List;

public interface iDireccionDao {

    List<Direccion> seleccionarDireccion();

    Direccion buscarDireccionPorId(Direccion paramDireccion);

    void insertarDireccion(Direccion paramDireccion);

    void eliminarDireccion(Direccion paramDireccion);

    void actualizarDireccion(Direccion paramDireccion);
}
