package com.vortexbird.demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "cuentas" )
public class Cuentas implements java.io.Serializable {
    @Id
    @NotNull
    private String cueNumero;
    @NotNull
    private Long cliId;
    @NotNull
    @NotEmpty
    @Size(max = 2)
    private String cueActiva;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cueClave;
    @NotNull
    private Double cueSaldo;

    public Cuentas() {
    }

    public Cuentas(String cueNumero, Long cliId, String cueActiva,
        String cueClave, Double cueSaldo) {
        this.cueNumero = cueNumero;
        this.cliId = cliId;
        this.cueActiva = cueActiva;
        this.cueClave = cueClave;
        this.cueSaldo = cueSaldo;
    }

    public String getCueNumero() {
        return this.cueNumero;
    }

    public void setCueNumero(String cueNumero) {
        this.cueNumero = cueNumero;
    }

    public Long getCliId() {
        return this.cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCueActiva() {
        return this.cueActiva;
    }

    public void setCueActiva(String cueActiva) {
        this.cueActiva = cueActiva;
    }

    public String getCueClave() {
        return this.cueClave;
    }

    public void setCueClave(String cueClave) {
        this.cueClave = cueClave;
    }

    public Double getCueSaldo() {
        return this.cueSaldo;
    }

    public void setCueSaldo(Double cueSaldo) {
        this.cueSaldo = cueSaldo;
    }
}
