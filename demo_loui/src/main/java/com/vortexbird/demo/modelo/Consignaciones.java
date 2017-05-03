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
@Table(name = "consignaciones" )
public class Consignaciones implements java.io.Serializable {
    @Id
    @NotNull
    private ConsignacionesId id;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String conDescripcion;
    @NotNull
    private Date conFecha;
    @NotNull
    private Double conValor;
    private Long usuCedula;

    public Consignaciones() {
    }

    public Consignaciones(ConsignacionesId id, String conDescripcion,
        Date conFecha, Double conValor, Long usuCedula) {
        this.id = id;
        this.conDescripcion = conDescripcion;
        this.conFecha = conFecha;
        this.conValor = conValor;
        this.usuCedula = usuCedula;
    }

    public ConsignacionesId getId() {
        return this.id;
    }

    public void setId(ConsignacionesId id) {
        this.id = id;
    }

    public String getConDescripcion() {
        return this.conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    public Date getConFecha() {
        return this.conFecha;
    }

    public void setConFecha(Date conFecha) {
        this.conFecha = conFecha;
    }

    public Double getConValor() {
        return this.conValor;
    }

    public void setConValor(Double conValor) {
        this.conValor = conValor;
    }

    public Long getUsuCedula() {
        return this.usuCedula;
    }

    public void setUsuCedula(Long usuCedula) {
        this.usuCedula = usuCedula;
    }
}
