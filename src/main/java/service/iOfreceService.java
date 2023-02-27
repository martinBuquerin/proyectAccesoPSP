package service;

import domain.Ofrece;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iOfreceService {

    List<Ofrece> seleccionaOfrece();

    Ofrece buscarOfrecePorId(int ofrece);

    List<Ofrece> buscarOfrecePorEmail(String usuario);

    void insertarServicioOfrecido(Ofrece ofrece);

    void eliminarServicioOfrecido(Ofrece ofrece);

    void actualizarServicioOfrecido(Ofrece ofrece);
}
