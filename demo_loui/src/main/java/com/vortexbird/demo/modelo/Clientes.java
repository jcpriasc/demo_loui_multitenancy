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
@Table(name = "clientes" )
public class Clientes implements java.io.Serializable {
    @Id
    @NotNull
    private Long cliId;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cliDireccion;
    private String cliMail;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cliNombre;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cliTelefono;
    @NotNull
    private Long tdocCodigo;

    public Clientes() {
    }

    public Clientes(Long cliId, String cliDireccion, String cliMail,
        String cliNombre, String cliTelefono, Long tdocCodigo) {
        this.cliId = cliId;
        this.cliDireccion = cliDireccion;
        this.cliMail = cliMail;
        this.cliNombre = cliNombre;
        this.cliTelefono = cliTelefono;
        this.tdocCodigo = tdocCodigo;
    }

    public Long getCliId() {
        return this.cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliDireccion() {
        return this.cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliMail() {
        return this.cliMail;
    }

    public void setCliMail(String cliMail) {
        this.cliMail = cliMail;
    }

    public String getCliNombre() {
        return this.cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliTelefono() {
        return this.cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public Long getTdocCodigo() {
        return this.tdocCodigo;
    }

    public void setTdocCodigo(Long tdocCodigo) {
        this.tdocCodigo = tdocCodigo;
    }
}
