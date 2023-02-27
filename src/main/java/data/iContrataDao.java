package data;

import domain.Contrata;
import domain.Usuario;
import java.util.List;


public interface iContrataDao {

    List<Contrata> seleccionaContrato();

    Contrata buscarClientePorId(Contrata contrato);
    
    List<Contrata> buscarContratosPorId(Usuario usuario);

    void insertarContrato(Contrata contrato);

    void eliminarContrato(Contrata contrato);

    void actualizarContrato(Contrata contrato);
}
