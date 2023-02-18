package data;

import domain.Direccion;
import java.util.List;
import javax.ejb.Local;


public interface iDireccionDao {

    List<Direccion> seleccionarDireccion();

    Direccion buscarDireccionPorId(Direccion direccion);

    void insertarDireccion(Direccion direccion);

    void eliminarDireccion(Direccion direccion);

    void actualizarDireccion(Direccion direccion);
}
