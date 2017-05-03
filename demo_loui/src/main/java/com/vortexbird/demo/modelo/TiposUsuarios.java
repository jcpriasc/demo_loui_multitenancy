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
@Table(name = "tiposUsuarios" )
public class TiposUsuarios implements java.io.Serializable {
    @Id
    @NotNull
    private Long tusuCodigo;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String tusuNombre;

    public TiposUsuarios() {
    }

    public TiposUsuarios(Long tusuCodigo, String tusuNombre) {
        this.tusuCodigo = tusuCodigo;
        this.tusuNombre = tusuNombre;
    }

    public Long getTusuCodigo() {
        return this.tusuCodigo;
    }

    public void setTusuCodigo(Long tusuCodigo) {
        this.tusuCodigo = tusuCodigo;
    }

    public String getTusuNombre() {
        return this.tusuNombre;
    }

    public void setTusuNombre(String tusuNombre) {
        this.tusuNombre = tusuNombre;
    }
}
