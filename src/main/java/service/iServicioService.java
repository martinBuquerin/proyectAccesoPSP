package service;

import domain.Servicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iServicioService {

    List<Servicio> seleccionaContrato();

    void insertarServicio(Servicio servicio);

    void eliminarServicio(Servicio servicio);

    void actualizarServicio(Servicio servicio);
}
