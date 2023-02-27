package service;

import data.iUsuarioDao;
import domain.Ofrece;
import domain.Roles;
import domain.Usuario;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class impUsuarioService implements iUsuarioService {

    @Inject
    private iUsuarioDao usuarioDao;

    @Override
    public List<Usuario> seleccionaUsuario() {
        return this.usuarioDao.seleccionaUsuario();
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        this.usuarioDao.insertarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        this.usuarioDao.eliminarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.usuarioDao.actualizarUsuario(usuario);
    }

    @Override
    public List<Usuario> buscarUsuarioPorRol(Roles rol) {
        return this.usuarioDao.buscarUsuarioPorRol(rol);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(Usuario email) {
        return this.usuarioDao.buscarUsuarioPorEmail(email);
    }

    @Override
    public List<Usuario> buscarUsuarioPorRol(List<Usuario> usuarios) {
        List<Usuario> usuario = usuarios;
        for (int i = 0; i < usuario.size(); i++) {
            int idRol = ((Usuario) usuario.get(i)).getRolesidRol().getIdRol().intValue();
            if (idRol != 9) {
                System.out.println(((Usuario) usuario.get(i)).getRolesidRol().getIdRol());
                usuarios.remove(i);
            }
        }
        return usuarios;
    }

    @Override
    public List<Ofrece> buscarPorServicio(){
         return this.usuarioDao.buscarPorServicio();
    }

    @Override
    public String contraCript(String input) throws Exception {
        String md5 = null;
        if (null == input) {
            return null;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            md5 = (new BigInteger(1, digest.digest())).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        return md5;
    }

    @Override
    public Usuario buscarImagenes() {
        return this.usuarioDao.buscarImagenes();
    }
}
