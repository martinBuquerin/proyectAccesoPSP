package service;

import domain.Roles;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iRolesService {

    List<Roles> seleccionaRol();

    Roles buscarRolPorNombre(String rol);

    void insertarRol(Roles rol);

    void eliminarRol(Roles rol);

    void actualizarRol(Roles rol);
}
