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
@Table(name = "tiposDocumentos" )
public class TiposDocumentos implements java.io.Serializable {
    @Id
    @NotNull
    private Long tdocCodigo;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String tdocNombre;

    public TiposDocumentos() {
    }

    public TiposDocumentos(Long tdocCodigo, String tdocNombre) {
        this.tdocCodigo = tdocCodigo;
        this.tdocNombre = tdocNombre;
    }

    public Long getTdocCodigo() {
        return this.tdocCodigo;
    }

    public void setTdocCodigo(Long tdocCodigo) {
        this.tdocCodigo = tdocCodigo;
    }

    public String getTdocNombre() {
        return this.tdocNombre;
    }

    public void setTdocNombre(String tdocNombre) {
        this.tdocNombre = tdocNombre;
    }
}
