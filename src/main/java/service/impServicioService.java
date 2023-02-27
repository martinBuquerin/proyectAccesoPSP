package service;

import data.iServicioDao;
import domain.Servicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class impServicioService implements iServicioService {
    
    @Inject
    private iServicioDao servicioDao;
    
    @Override
    public void insertarServicio(Servicio servicio) {
        this.servicioDao.insertarServicio(servicio);
    }
    
    @Override
    public void eliminarServicio(Servicio servicio) {
        this.servicioDao.eliminarServicio(servicio);
    }
    
    @Override
    public void actualizarServicio(Servicio servicio) {
        this.servicioDao.actualizarServicio(servicio);
    }
    
    @Override
    public List<Servicio> seleccionaServicio() {
        return this.servicioDao.seleccionaServicio();
    }
    
    @Override
    public Servicio buscarServicioPorId(Servicio servicio) {
        return this.servicioDao.buscarServicioPorId(servicio);
    }
}
