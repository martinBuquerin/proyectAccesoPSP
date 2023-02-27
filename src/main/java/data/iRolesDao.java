package data;

import domain.Roles;
import java.util.List;


public interface iRolesDao {

    List<Roles> seleccionaRol();

    Roles buscarRolPorNombre(String rol);

    void insertarRol(Roles rol);

    void eliminarRol(Roles rol);

    void actualizarRol(Roles rol);
}
