package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.Retiros;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.RetirosDTO;
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
public class RetirosMapper implements IRetirosMapper {
    private static final Logger log = LoggerFactory.getLogger(RetirosMapper.class);

    @Transactional(readOnly = true)
    public RetirosDTO retirosToRetirosDTO(Retiros retiros)
        throws Exception {
        try {
            RetirosDTO retirosDTO = new RetirosDTO();

            retirosDTO.setRetCodigo(retiros.getId().getRetCodigo());
            retirosDTO.setCueNumero(retiros.getId().getCueNumero());
            retirosDTO.setRetDescripcion((retiros.getRetDescripcion() != null)
                ? retiros.getRetDescripcion() : null);
            retirosDTO.setRetFecha(retiros.getRetFecha());
            retirosDTO.setRetValor((retiros.getRetValor() != null)
                ? retiros.getRetValor() : null);
            retirosDTO.setUsuCedula((retiros.getUsuCedula() != null)
                ? retiros.getUsuCedula() : null);

            return retirosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Retiros retirosDTOToRetiros(RetirosDTO retirosDTO)
        throws Exception {
        try {
            Retiros retiros = new Retiros();

            RetirosId retirosId = new RetirosId();

            if ((retirosDTO.getRetCodigo() != null) &&
                    (retirosDTO.getRetCodigo().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            retirosId.setRetCodigo((retirosDTO.getRetCodigo() != null)
                ? retirosDTO.getRetCodigo() : null);

            if ((retirosDTO.getCueNumero() != null) &&
                    (retirosDTO.getCueNumero().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            retirosId.setCueNumero((retirosDTO.getCueNumero() != null)
                ? retirosDTO.getCueNumero() : null);
            retiros.setId(retirosId);
            retiros.setRetDescripcion((retirosDTO.getRetDescripcion() != null)
                ? retirosDTO.getRetDescripcion() : null);
            retiros.setRetFecha(retirosDTO.getRetFecha());
            retiros.setRetValor((retirosDTO.getRetValor() != null)
                ? retirosDTO.getRetValor() : null);
            retiros.setUsuCedula((retirosDTO.getUsuCedula() != null)
                ? retirosDTO.getUsuCedula() : null);

            return retiros;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RetirosDTO> listRetirosToListRetirosDTO(
        List<Retiros> listRetiros) throws Exception {
        try {
            List<RetirosDTO> retirosDTOs = new ArrayList<RetirosDTO>();

            for (Retiros retiros : listRetiros) {
                RetirosDTO retirosDTO = retirosToRetirosDTO(retiros);

                retirosDTOs.add(retirosDTO);
            }

            return retirosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Retiros> listRetirosDTOToListRetiros(
        List<RetirosDTO> listRetirosDTO) throws Exception {
        try {
            List<Retiros> listRetiros = new ArrayList<Retiros>();

            for (RetirosDTO retirosDTO : listRetirosDTO) {
                Retiros retiros = retirosDTOToRetiros(retirosDTO);

                listRetiros.add(retiros);
            }

            return listRetiros;
        } catch (Exception e) {
            throw e;
        }
    }
}
