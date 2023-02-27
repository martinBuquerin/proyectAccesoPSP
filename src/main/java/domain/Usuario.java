package domain;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByFechaAlta", query = "SELECT u FROM Usuario u WHERE u.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByPausarCuenta", query = "SELECT u FROM Usuario u WHERE u.pausarCuenta = :pausarCuenta"),
    @NamedQuery(name = "Usuario.findByNombreEmpresa", query = "SELECT u FROM Usuario u WHERE u.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Usuario.findByDescripcionEmpresa", query = "SELECT u FROM Usuario u WHERE u.descripcionEmpresa = :descripcionEmpresa")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 60)
    @Column(name = "apellido")
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "email")
    private String email;
    @Size(max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrasena")
    private String contrasena;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Column(name = "pausarCuenta")
    private Boolean pausarCuenta;
    @Size(max = 45)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Size(max = 200)
    @Column(name = "descripcionEmpresa")
    private String descripcionEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioEmail")
    private List<Ofrece> ofreceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioEmail")
    private List<Direccion> direccionList;
    @JoinColumn(name = "roles_idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Roles rolesidRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioEmail")
    private List<Contrata> contrataList;
    


    public Usuario() {
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, Date fechaAlta, String contrasena) {
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.contrasena = contrasena;
    }

    public Usuario(String email, Date fechaAlta, String contrasena, Roles rol) {
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.contrasena = contrasena;
        this.rolesidRol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Boolean getPausarCuenta() {
        return pausarCuenta;
    }

    public void setPausarCuenta(Boolean pausarCuenta) {
        this.pausarCuenta = pausarCuenta;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    @XmlTransient
    public List<Ofrece> getOfreceList() {
        return ofreceList;
    }

    public void setOfreceList(List<Ofrece> ofreceList) {
        this.ofreceList = ofreceList;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public Roles getRolesidRol() {
        return rolesidRol;
    }

    public void setRolesidRol(Roles rolesidRol) {
        this.rolesidRol = rolesidRol;
    }

    @XmlTransient
    public List<Contrata> getContrataList() {
        return contrataList;
    }

    public void setContrataList(List<Contrata> contrataList) {
        this.contrataList = contrataList;
    }


 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nombre: ").append(nombre);
        sb.append(" apellido: ").append(apellido);
        sb.append(" email: ").append(email);
        sb.append(" telefono: ").append(telefono);
        sb.append(" fechaAlta: ").append(fechaAlta);
        sb.append(" contrasena: ").append(contrasena);
        sb.append(" imagen: ").append(imagen);
        sb.append(" pausarCuenta: ").append(pausarCuenta);
        sb.append(" nombreEmpresa: ").append(nombreEmpresa);
        sb.append(" descripcionEmpresa: ").append(descripcionEmpresa);
        sb.append(" ofreceList: ").append(ofreceList);
        sb.append(" direccionList: ").append(direccionList);
        sb.append(" rolesidRol: ").append(rolesidRol);
        sb.append(" contrataList: ").append(contrataList);

        return sb.toString();
    }

}
