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
@Table(name = "retiros" )
public class Retiros implements java.io.Serializable {
    @Id
    @NotNull
    private RetirosId id;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String retDescripcion;
    @NotNull
    private Date retFecha;
    @NotNull
    private Double retValor;
    private Long usuCedula;

    public Retiros() {
    }

    public Retiros(RetirosId id, String retDescripcion, Date retFecha,
        Double retValor, Long usuCedula) {
        this.id = id;
        this.retDescripcion = retDescripcion;
        this.retFecha = retFecha;
        this.retValor = retValor;
        this.usuCedula = usuCedula;
    }

    public RetirosId getId() {
        return this.id;
    }

    public void setId(RetirosId id) {
        this.id = id;
    }

    public String getRetDescripcion() {
        return this.retDescripcion;
    }

    public void setRetDescripcion(String retDescripcion) {
        this.retDescripcion = retDescripcion;
    }

    public Date getRetFecha() {
        return this.retFecha;
    }

    public void setRetFecha(Date retFecha) {
        this.retFecha = retFecha;
    }

    public Double getRetValor() {
        return this.retValor;
    }

    public void setRetValor(Double retValor) {
        this.retValor = retValor;
    }

    public Long getUsuCedula() {
        return this.usuCedula;
    }

    public void setUsuCedula(Long usuCedula) {
        this.usuCedula = usuCedula;
    }
}
