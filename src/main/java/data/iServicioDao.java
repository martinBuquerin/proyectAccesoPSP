package data;

import domain.Servicio;
import java.util.List;

public interface iServicioDao {

    List<Servicio> seleccionaServicio();

    Servicio buscarServicioPorId(Servicio paramServicio);

    void insertarServicio(Servicio paramServicio);

    void eliminarServicio(Servicio paramServicio);

    void actualizarServicio(Servicio paramServicio);
}
