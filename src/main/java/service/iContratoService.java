package service;

import domain.Contrata;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iContratoService {

    List<Contrata> seleccionaContrato();

    void insertarContrato(Contrata paramContrata);

    void eliminarContrato(Contrata paramContrata);

    void actualizarContrato(Contrata paramContrata);
}
