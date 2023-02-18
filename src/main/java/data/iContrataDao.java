package data;

import domain.Contrata;
import java.util.List;

public interface iContrataDao {

    List<Contrata> seleccionaContrato();

    Contrata buscarClientePorId(Contrata paramContrata);

    void insertarContrato(Contrata paramContrata);

    void eliminarContrato(Contrata paramContrata);

    void actualizarContrato(Contrata paramContrata);
}
