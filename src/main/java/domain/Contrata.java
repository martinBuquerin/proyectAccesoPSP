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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "contrata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrata.findAll", query = "SELECT c FROM Contrata c"),
    @NamedQuery(name = "Contrata.findByIdContrato", query = "SELECT c FROM Contrata c WHERE c.idContrato = :idContrato")})
public class Contrata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContrato")
    private Integer idContrato;
    @JoinColumn(name = "ofrece_idOfrece", referencedColumnName = "idOfrece")
    @ManyToOne(optional = false)
    private Ofrece ofreceidOfrece;
    @JoinColumn(name = "usuario_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario usuarioEmail;

    public Contrata() {
    }
    
    public Contrata(Ofrece ofreceidOfrece,Usuario usuarioEmail) {
        this.ofreceidOfrece = ofreceidOfrece;
        this.usuarioEmail = usuarioEmail;
    }
    
 

    public Contrata(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Ofrece getOfreceidOfrece() {
        return ofreceidOfrece;
    }

    public void setOfreceidOfrece(Ofrece ofreceidOfrece) {
        this.ofreceidOfrece = ofreceidOfrece;
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
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrata)) {
            return false;
        }
        Contrata other = (Contrata) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" idContrato: ").append(idContrato);
        sb.append(" ofreceidOfrece: ").append(ofreceidOfrece);
        sb.append(" usuarioEmail: ").append(usuarioEmail);
;
        return sb.toString();
    }

   
    
}
