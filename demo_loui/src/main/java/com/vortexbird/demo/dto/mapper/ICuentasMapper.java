package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.modelo.Cuentas;
import com.vortexbird.demo.modelo.dto.CuentasDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ICuentasMapper {
    public CuentasDTO cuentasToCuentasDTO(Cuentas cuentas)
        throws Exception;

    public Cuentas cuentasDTOToCuentas(CuentasDTO cuentasDTO)
        throws Exception;

    public List<CuentasDTO> listCuentasToListCuentasDTO(List<Cuentas> cuentass)
        throws Exception;

    public List<Cuentas> listCuentasDTOToListCuentas(
        List<CuentasDTO> cuentasDTOs) throws Exception;
}
