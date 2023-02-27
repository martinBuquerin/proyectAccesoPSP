package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ofrece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofrece.findAll", query = "SELECT o FROM Ofrece o"),
    @NamedQuery(name = "Ofrece.findByIdOfrece", query = "SELECT o FROM Ofrece o WHERE o.idOfrece = :idOfrece")})
public class Ofrece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idOfrece")
    private Integer idOfrece;
    @JoinColumn(name = "servicio_idServicio", referencedColumnName = "idServicio")
    @ManyToOne(optional = false)
    private Servicio servicioidServicio;
    @JoinColumn(name = "usuario_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario usuarioEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofreceidOfrece")
    private List<Contrata> contrataList;

    public Ofrece() {
    }

    public Ofrece(Integer idOfrece) {
        this.idOfrece = idOfrece;
    }

    public Integer getIdOfrece() {
        return idOfrece;
    }

    public void setIdOfrece(Integer idOfrece) {
        this.idOfrece = idOfrece;
    }

    public Servicio getServicioidServicio() {
        return servicioidServicio;
    }

    public void setServicioidServicio(Servicio servicioidServicio) {
        this.servicioidServicio = servicioidServicio;
    }

    public Usuario getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(Usuario usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
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
        hash += (idOfrece != null ? idOfrece.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofrece)) {
            return false;
        }
        Ofrece other = (Ofrece) object;
        if ((this.idOfrece == null && other.idOfrece != null) || (this.idOfrece != null && !this.idOfrece.equals(other.idOfrece))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" idOfrece: ").append(idOfrece);
        sb.append(" servicioidServicio: ").append(servicioidServicio);
        sb.append(" usuarioEmail: ").append(usuarioEmail);
        sb.append(" contrataList: ").append(contrataList);
        return sb.toString();
    }

}
