package service;

import data.iDireccionDao;
import domain.Direccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class impDireccionService implements iDireccionService {

    @Inject
    private iDireccionDao direccionDao;

    @Override
    public List<Direccion> seleccionaDireccion() {
        return this.direccionDao.seleccionarDireccion();
    }

    @Override
    public void insertarDireccion(Direccion direccion) {
        this.direccionDao.insertarDireccion(direccion);
    }

    @Override
    public void eliminarDireccion(Direccion direccion) {
        this.direccionDao.eliminarDireccion(direccion);
    }

    @Override
    public void actualizarDireccion(Direccion direccion) {
        this.direccionDao.actualizarDireccion(direccion);
    }
}
