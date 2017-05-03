package com.vortexbird.demo.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
public class RetirosId implements java.io.Serializable {
    @Id
    @NotNull
    private Long retCodigo;
    @Id
    @NotNull
    private String cueNumero;

    public RetirosId() {
    }

    public Long getRetCodigo() {
        return this.retCodigo;
    }

    public void setRetCodigo(Long retCodigo) {
        this.retCodigo = retCodigo;
    }

    public String getCueNumero() {
        return this.cueNumero;
    }

    public void setCueNumero(String cueNumero) {
        this.cueNumero = cueNumero;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }

        if ((other == null)) {
            return false;
        }

        if (!(other instanceof RetirosId)) {
            return false;
        }

        RetirosId castOther = (RetirosId) other;

        return ((this.getRetCodigo() == castOther.getRetCodigo()) ||
        ((this.getRetCodigo() != null) && (castOther.getRetCodigo() != null) &&
        this.getRetCodigo().equals(castOther.getRetCodigo()))) &&
        ((this.getCueNumero() == castOther.getCueNumero()) ||
        ((this.getCueNumero() != null) && (castOther.getCueNumero() != null) &&
        this.getCueNumero().equals(castOther.getCueNumero())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getRetCodigo() == null) ? 0 : this.getRetCodigo().hashCode());
        result = (37 * result) +
            ((getCueNumero() == null) ? 0 : this.getCueNumero().hashCode());

        return result;
    }
}
