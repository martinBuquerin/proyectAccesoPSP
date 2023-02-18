package data;

import domain.Ofrece;
import java.util.List;
import javax.ejb.Local;


public interface iOfreceDao {

    List<Ofrece> seleccionaOfrece();

    Ofrece buscarOfrecePorId(Ofrece ofrece);

    void insertarOfrece(Ofrece ofrece);

    void eliminarOfrece(Ofrece ofrece);

    void actualizarOfrece(Ofrece ofrece);
}
