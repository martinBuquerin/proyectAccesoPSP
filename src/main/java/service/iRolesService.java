package service;

import domain.Roles;
import java.util.List;
import javax.ejb.Local;

@Local
public interface iRolesService {

    List<Roles> seleccionaRol();

    Roles buscarRolPorNombre(String paramString);

    void insertarRol(Roles paramRoles);

    void eliminarRol(Roles paramRoles);

    void actualizarRol(Roles paramRoles);
}
