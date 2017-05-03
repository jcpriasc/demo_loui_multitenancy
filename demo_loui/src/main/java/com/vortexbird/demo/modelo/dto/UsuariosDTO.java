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
public class UsuariosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuariosDTO.class);
    private Long tusuCodigo;
    private Long usuCedula;
    private String usuClave;
    private String usuLogin;
    private String usuNombre;

    public Long getTusuCodigo() {
        return tusuCodigo;
    }

    public void setTusuCodigo(Long tusuCodigo) {
        this.tusuCodigo = tusuCodigo;
    }

    public Long getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(Long usuCedula) {
        this.usuCedula = usuCedula;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }
}
