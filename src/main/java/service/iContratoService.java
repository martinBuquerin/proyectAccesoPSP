package service;

import domain.Contrata;
import domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iContratoService {

    List<Contrata> seleccionaContrato();
        
    List<Contrata> buscarContratosPorId(Usuario usuario);

    void insertarContrato(Contrata contrato);

    void eliminarContrato(Contrata contrato);

    void actualizarContrato(Contrata contrato);
}
