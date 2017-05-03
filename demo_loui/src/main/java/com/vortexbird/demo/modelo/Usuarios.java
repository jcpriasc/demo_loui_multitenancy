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
@Table(name = "usuarios" )
public class Usuarios implements java.io.Serializable {
    @Id
    @NotNull
    private Long usuCedula;
    private Long tusuCodigo;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String usuClave;
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String usuLogin;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String usuNombre;

    public Usuarios() {
    }

    public Usuarios(Long usuCedula, Long tusuCodigo, String usuClave,
        String usuLogin, String usuNombre) {
        this.usuCedula = usuCedula;
        this.tusuCodigo = tusuCodigo;
        this.usuClave = usuClave;
        this.usuLogin = usuLogin;
        this.usuNombre = usuNombre;
    }

    public Long getUsuCedula() {
        return this.usuCedula;
    }

    public void setUsuCedula(Long usuCedula) {
        this.usuCedula = usuCedula;
    }

    public Long getTusuCodigo() {
        return this.tusuCodigo;
    }

    public void setTusuCodigo(Long tusuCodigo) {
        this.tusuCodigo = tusuCodigo;
    }

    public String getUsuClave() {
        return this.usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getUsuLogin() {
        return this.usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuNombre() {
        return this.usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }
}
