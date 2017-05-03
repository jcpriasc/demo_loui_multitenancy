package com.vortexbird.demo.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class ConsignacionesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ConsignacionesDTO.class);
    private String conDescripcion;
    private Date conFecha;
    private Double conValor;
    private Long conCodigo;
    private String cueNumero;
    private Long usuCedula;

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    public Date getConFecha() {
        return conFecha;
    }

    public void setConFecha(Date conFecha) {
        this.conFecha = conFecha;
    }

    public Double getConValor() {
        return conValor;
    }

    public void setConValor(Double conValor) {
        this.conValor = conValor;
    }

    public Long getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getCueNumero() {
        return cueNumero;
    }

    public void setCueNumero(String cueNumero) {
        this.cueNumero = cueNumero;
    }

    public Long getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(Long usuCedula) {
        this.usuCedula = usuCedula;
    }
}
