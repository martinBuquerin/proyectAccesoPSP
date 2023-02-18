package service;

import data.iRolesDao;
import domain.Roles;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class impRolesService implements iRolesService {

    @Inject
    public iRolesDao rolesDao;

    @Override
    public List<Roles> seleccionaRol() {
        return this.rolesDao.seleccionaRol();
    }

    @Override
    public Roles buscarRolPorNombre(String rol) {
        return this.rolesDao.buscarRolPorNombre(rol);
    }

    @Override
    public void insertarRol(Roles rol) {
        this.rolesDao.insertarRol(rol);
    }

    @Override
    public void eliminarRol(Roles rol) {
        this.rolesDao.eliminarRol(rol);
    }

    @Override
    public void actualizarRol(Roles rol) {
        this.rolesDao.actualizarRol(rol);
    }
}
