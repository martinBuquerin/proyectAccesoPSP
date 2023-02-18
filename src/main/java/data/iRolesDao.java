package data;

import domain.Roles;
import java.util.List;

public interface iRolesDao {

    List<Roles> seleccionaRol();

    Roles buscarRolPorNombre(String paramString);

    void insertarRol(Roles paramRoles);

    void eliminarRol(Roles paramRoles);

    void actualizarRol(Roles paramRoles);
}
