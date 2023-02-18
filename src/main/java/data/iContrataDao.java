package data;

import domain.Contrata;
import java.util.List;
import javax.ejb.Local;


public interface iContrataDao {

    List<Contrata> seleccionaContrato();

    Contrata buscarClientePorId(Contrata contrato);

    void insertarContrato(Contrata contrato);

    void eliminarContrato(Contrata contrato);

    void actualizarContrato(Contrata contrato);
}
