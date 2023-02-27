package service;

import domain.Servicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iServicioService {

    List<Servicio> seleccionaServicio();

    Servicio buscarServicioPorId(Servicio servicio);

    void insertarServicio(Servicio servicio);

    void eliminarServicio(Servicio servicio);

    void actualizarServicio(Servicio servicio);
}
