package service;

import data.iOfreceDao;
import domain.Ofrece;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class impOfreceService implements iOfreceService {

    @Inject
    private iOfreceDao ofreceDao;

    @Override
    public List<Ofrece> seleccionaServicioOfrecido() {
        return this.ofreceDao.seleccionaOfrece();
    }

    @Override
    public void insertarServicioOfrecido(Ofrece ofrece) {
        this.ofreceDao.insertarOfrece(ofrece);
    }

    @Override
    public void eliminarServicioOfrecido(Ofrece ofrece) {
        this.ofreceDao.eliminarOfrece(ofrece);
    }

    @Override
    public void actualizarServicioOfrecido(Ofrece ofrece) {
        this.ofreceDao.actualizarOfrece(ofrece);
    }
}
