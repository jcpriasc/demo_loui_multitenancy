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
public class CuentasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CuentasDTO.class);
    private Long cliId;
    private String cueActiva;
    private String cueClave;
    private String cueNumero;
    private Double cueSaldo;

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCueActiva() {
        return cueActiva;
    }

    public void setCueActiva(String cueActiva) {
        this.cueActiva = cueActiva;
    }

    public String getCueClave() {
        return cueClave;
    }

    public void setCueClave(String cueClave) {
        this.cueClave = cueClave;
    }

    public String getCueNumero() {
        return cueNumero;
    }

    public void setCueNumero(String cueNumero) {
        this.cueNumero = cueNumero;
    }

    public Double getCueSaldo() {
        return cueSaldo;
    }

    public void setCueSaldo(Double cueSaldo) {
        this.cueSaldo = cueSaldo;
    }
}
