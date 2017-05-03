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
public class ConsignacionesId implements java.io.Serializable {
    @Id
    @NotNull
    private Long conCodigo;
    @Id
    @NotNull
    private String cueNumero;

    public ConsignacionesId() {
    }

    public Long getConCodigo() {
        return this.conCodigo;
    }

    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
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

        if (!(other instanceof ConsignacionesId)) {
            return false;
        }

        ConsignacionesId castOther = (ConsignacionesId) other;

        return ((this.getConCodigo() == castOther.getConCodigo()) ||
        ((this.getConCodigo() != null) && (castOther.getConCodigo() != null) &&
        this.getConCodigo().equals(castOther.getConCodigo()))) &&
        ((this.getCueNumero() == castOther.getCueNumero()) ||
        ((this.getCueNumero() != null) && (castOther.getCueNumero() != null) &&
        this.getCueNumero().equals(castOther.getCueNumero())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getConCodigo() == null) ? 0 : this.getConCodigo().hashCode());
        result = (37 * result) +
            ((getCueNumero() == null) ? 0 : this.getCueNumero().hashCode());

        return result;
    }
}
