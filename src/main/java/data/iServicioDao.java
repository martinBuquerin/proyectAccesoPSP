package data;

import domain.Servicio;
import java.util.List;

public interface iServicioDao {

    List<Servicio> seleccionaServicio();

    Servicio buscarServicioPorId(Servicio servicio);

    void insertarServicio(Servicio servicio);

    void eliminarServicio(Servicio servicio);

    void actualizarServicio(Servicio servicio);
}
