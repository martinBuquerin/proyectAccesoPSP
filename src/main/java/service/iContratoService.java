package service;

import domain.Contrata;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iContratoService {

    List<Contrata> seleccionaContrato();

    void insertarContrato(Contrata contrato);

    void eliminarContrato(Contrata contrato);

    void actualizarContrato(Contrata contrato);
}
