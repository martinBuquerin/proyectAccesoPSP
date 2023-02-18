/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle"),
    @NamedQuery(name = "Direccion.findByNumero", query = "SELECT d FROM Direccion d WHERE d.numero = :numero"),
    @NamedQuery(name = "Direccion.findByPiso", query = "SELECT d FROM Direccion d WHERE d.piso = :piso"),
    @NamedQuery(name = "Direccion.findByCp", query = "SELECT d FROM Direccion d WHERE d.cp = :cp"),
    @NamedQuery(name = "Direccion.findByLocalidad", query = "SELECT d FROM Direccion d WHERE d.localidad = :localidad"),
    @NamedQuery(name = "Direccion.findByProvincia", query = "SELECT d FROM Direccion d WHERE d.provincia = :provincia"),
    @NamedQuery(name = "Direccion.findByPais", query = "SELECT d FROM Direccion d WHERE d.pais = :pais")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion")
    private Integer idDireccion;
    @Size(max = 60)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 10)
    @Column(name = "piso")
    private String piso;
    @Column(name = "cp")
    private Integer cp;
    @Size(max = 18)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 18)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 20)
    @Column(name = "pais")
    private String pais;
    @JoinColumn(name = "usuario_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario usuarioEmail;

    public Direccion() {
    }

    public Direccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Usuario getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(Usuario usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" idDireccion:").append(idDireccion);
        sb.append(" calle: ").append(calle);
        sb.append(" numero: ").append(numero);
        sb.append(" piso: ").append(piso);
        sb.append(" cp: ").append(cp);
        sb.append(" localidad: ").append(localidad);
        sb.append(" provincia: ").append(provincia);
        sb.append(" pais: ").append(pais);
        sb.append(" usuarioEmail: ").append(usuarioEmail);

        return sb.toString();
    }

}
