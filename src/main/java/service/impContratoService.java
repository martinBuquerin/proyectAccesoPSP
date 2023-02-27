package service;

import data.iContrataDao;
import domain.Contrata;
import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class impContratoService implements iContratoService {

    @Inject
    private iContrataDao contratoDao;

    @Override
    public List<Contrata> seleccionaContrato() {
        return this.contratoDao.seleccionaContrato();
    }

    @Override
    public void insertarContrato(Contrata contrato) {
        this.contratoDao.insertarContrato(contrato);
    }

    @Override
    public void eliminarContrato(Contrata contrato) {
        this.contratoDao.eliminarContrato(contrato);
    }

    @Override
    public void actualizarContrato(Contrata contrato) {
        this.contratoDao.eliminarContrato(contrato);
    }

    @Override
    public List<Contrata> buscarContratosPorId(Usuario usuario) {
       return this.contratoDao.buscarContratosPorId(usuario);
    }
}
