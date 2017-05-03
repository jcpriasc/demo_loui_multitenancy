package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.Cuentas;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.CuentasDTO;
import com.vortexbird.demo.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class CuentasMapper implements ICuentasMapper {
    private static final Logger log = LoggerFactory.getLogger(CuentasMapper.class);

    @Transactional(readOnly = true)
    public CuentasDTO cuentasToCuentasDTO(Cuentas cuentas)
        throws Exception {
        try {
            CuentasDTO cuentasDTO = new CuentasDTO();

            cuentasDTO.setCueNumero(cuentas.getCueNumero());
            cuentasDTO.setCliId((cuentas.getCliId() != null)
                ? cuentas.getCliId() : null);
            cuentasDTO.setCueActiva((cuentas.getCueActiva() != null)
                ? cuentas.getCueActiva() : null);
            cuentasDTO.setCueClave((cuentas.getCueClave() != null)
                ? cuentas.getCueClave() : null);
            cuentasDTO.setCueSaldo((cuentas.getCueSaldo() != null)
                ? cuentas.getCueSaldo() : null);

            return cuentasDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Cuentas cuentasDTOToCuentas(CuentasDTO cuentasDTO)
        throws Exception {
        try {
            Cuentas cuentas = new Cuentas();

            cuentas.setCueNumero(cuentasDTO.getCueNumero());
            cuentas.setCliId((cuentasDTO.getCliId() != null)
                ? cuentasDTO.getCliId() : null);
            cuentas.setCueActiva((cuentasDTO.getCueActiva() != null)
                ? cuentasDTO.getCueActiva() : null);
            cuentas.setCueClave((cuentasDTO.getCueClave() != null)
                ? cuentasDTO.getCueClave() : null);
            cuentas.setCueSaldo((cuentasDTO.getCueSaldo() != null)
                ? cuentasDTO.getCueSaldo() : null);

            return cuentas;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CuentasDTO> listCuentasToListCuentasDTO(
        List<Cuentas> listCuentas) throws Exception {
        try {
            List<CuentasDTO> cuentasDTOs = new ArrayList<CuentasDTO>();

            for (Cuentas cuentas : listCuentas) {
                CuentasDTO cuentasDTO = cuentasToCuentasDTO(cuentas);

                cuentasDTOs.add(cuentasDTO);
            }

            return cuentasDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Cuentas> listCuentasDTOToListCuentas(
        List<CuentasDTO> listCuentasDTO) throws Exception {
        try {
            List<Cuentas> listCuentas = new ArrayList<Cuentas>();

            for (CuentasDTO cuentasDTO : listCuentasDTO) {
                Cuentas cuentas = cuentasDTOToCuentas(cuentasDTO);

                listCuentas.add(cuentas);
            }

            return listCuentas;
        } catch (Exception e) {
            throw e;
        }
    }
}
