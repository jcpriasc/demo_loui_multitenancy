package com.vortexbird.demo.presentation.businessDelegate;

import com.vortexbird.demo.modelo.Clientes;
import com.vortexbird.demo.modelo.Consignaciones;
import com.vortexbird.demo.modelo.ConsignacionesId;
import com.vortexbird.demo.modelo.Cuentas;
import com.vortexbird.demo.modelo.Retiros;
import com.vortexbird.demo.modelo.RetirosId;
import com.vortexbird.demo.modelo.TiposDocumentos;
import com.vortexbird.demo.modelo.TiposUsuarios;
import com.vortexbird.demo.modelo.Usuarios;
import com.vortexbird.demo.modelo.control.ClientesLogic;
import com.vortexbird.demo.modelo.control.ConsignacionesLogic;
import com.vortexbird.demo.modelo.control.CuentasLogic;
import com.vortexbird.demo.modelo.control.IClientesLogic;
import com.vortexbird.demo.modelo.control.IConsignacionesLogic;
import com.vortexbird.demo.modelo.control.ICuentasLogic;
import com.vortexbird.demo.modelo.control.IRetirosLogic;
import com.vortexbird.demo.modelo.control.ITiposDocumentosLogic;
import com.vortexbird.demo.modelo.control.ITiposUsuariosLogic;
import com.vortexbird.demo.modelo.control.IUsuariosLogic;
import com.vortexbird.demo.modelo.control.RetirosLogic;
import com.vortexbird.demo.modelo.control.TiposDocumentosLogic;
import com.vortexbird.demo.modelo.control.TiposUsuariosLogic;
import com.vortexbird.demo.modelo.control.UsuariosLogic;
import com.vortexbird.demo.modelo.dto.ClientesDTO;
import com.vortexbird.demo.modelo.dto.ConsignacionesDTO;
import com.vortexbird.demo.modelo.dto.CuentasDTO;
import com.vortexbird.demo.modelo.dto.RetirosDTO;
import com.vortexbird.demo.modelo.dto.TiposDocumentosDTO;
import com.vortexbird.demo.modelo.dto.TiposUsuariosDTO;
import com.vortexbird.demo.modelo.dto.UsuariosDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Clientes> getClientes() throws Exception;

    public void saveClientes(Clientes entity) throws Exception;

    public void deleteClientes(Clientes entity) throws Exception;

    public void updateClientes(Clientes entity) throws Exception;

    public Clientes getClientes(Long cliId) throws Exception;

    public List<Clientes> findByCriteriaInClientes(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Clientes> findPageClientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberClientes() throws Exception;

    public List<ClientesDTO> getDataClientes() throws Exception;

    public void validateClientes(Clientes clientes) throws Exception;

    public List<Consignaciones> getConsignaciones() throws Exception;

    public void saveConsignaciones(Consignaciones entity)
        throws Exception;

    public void deleteConsignaciones(Consignaciones entity)
        throws Exception;

    public void updateConsignaciones(Consignaciones entity)
        throws Exception;

    public Consignaciones getConsignaciones(ConsignacionesId id)
        throws Exception;

    public List<Consignaciones> findByCriteriaInConsignaciones(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Consignaciones> findPageConsignaciones(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberConsignaciones() throws Exception;

    public List<ConsignacionesDTO> getDataConsignaciones()
        throws Exception;

    public void validateConsignaciones(Consignaciones consignaciones)
        throws Exception;

    public List<Cuentas> getCuentas() throws Exception;

    public void saveCuentas(Cuentas entity) throws Exception;

    public void deleteCuentas(Cuentas entity) throws Exception;

    public void updateCuentas(Cuentas entity) throws Exception;

    public Cuentas getCuentas(String cueNumero) throws Exception;

    public List<Cuentas> findByCriteriaInCuentas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cuentas> findPageCuentas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCuentas() throws Exception;

    public List<CuentasDTO> getDataCuentas() throws Exception;

    public void validateCuentas(Cuentas cuentas) throws Exception;

    public List<Retiros> getRetiros() throws Exception;

    public void saveRetiros(Retiros entity) throws Exception;

    public void deleteRetiros(Retiros entity) throws Exception;

    public void updateRetiros(Retiros entity) throws Exception;

    public Retiros getRetiros(RetirosId id) throws Exception;

    public List<Retiros> findByCriteriaInRetiros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Retiros> findPageRetiros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRetiros() throws Exception;

    public List<RetirosDTO> getDataRetiros() throws Exception;

    public void validateRetiros(Retiros retiros) throws Exception;

    public List<TiposDocumentos> getTiposDocumentos() throws Exception;

    public void saveTiposDocumentos(TiposDocumentos entity)
        throws Exception;

    public void deleteTiposDocumentos(TiposDocumentos entity)
        throws Exception;

    public void updateTiposDocumentos(TiposDocumentos entity)
        throws Exception;

    public TiposDocumentos getTiposDocumentos(Long tdocCodigo)
        throws Exception;

    public List<TiposDocumentos> findByCriteriaInTiposDocumentos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TiposDocumentos> findPageTiposDocumentos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTiposDocumentos() throws Exception;

    public List<TiposDocumentosDTO> getDataTiposDocumentos()
        throws Exception;

    public void validateTiposDocumentos(TiposDocumentos tiposDocumentos)
        throws Exception;

    public List<TiposUsuarios> getTiposUsuarios() throws Exception;

    public void saveTiposUsuarios(TiposUsuarios entity)
        throws Exception;

    public void deleteTiposUsuarios(TiposUsuarios entity)
        throws Exception;

    public void updateTiposUsuarios(TiposUsuarios entity)
        throws Exception;

    public TiposUsuarios getTiposUsuarios(Long tusuCodigo)
        throws Exception;

    public List<TiposUsuarios> findByCriteriaInTiposUsuarios(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TiposUsuarios> findPageTiposUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTiposUsuarios() throws Exception;

    public List<TiposUsuariosDTO> getDataTiposUsuarios()
        throws Exception;

    public void validateTiposUsuarios(TiposUsuarios tiposUsuarios)
        throws Exception;

    public List<Usuarios> getUsuarios() throws Exception;

    public void saveUsuarios(Usuarios entity) throws Exception;

    public void deleteUsuarios(Usuarios entity) throws Exception;

    public void updateUsuarios(Usuarios entity) throws Exception;

    public Usuarios getUsuarios(Long usuCedula) throws Exception;

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;

    public void validateUsuarios(Usuarios usuarios) throws Exception;
}
