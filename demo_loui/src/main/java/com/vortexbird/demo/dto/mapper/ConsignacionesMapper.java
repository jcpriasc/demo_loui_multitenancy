package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.Consignaciones;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.ConsignacionesDTO;
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
public class ConsignacionesMapper implements IConsignacionesMapper {
    private static final Logger log = LoggerFactory.getLogger(ConsignacionesMapper.class);

    @Transactional(readOnly = true)
    public ConsignacionesDTO consignacionesToConsignacionesDTO(
        Consignaciones consignaciones) throws Exception {
        try {
            ConsignacionesDTO consignacionesDTO = new ConsignacionesDTO();

            consignacionesDTO.setConCodigo(consignaciones.getId().getConCodigo());
            consignacionesDTO.setCueNumero(consignaciones.getId().getCueNumero());
            consignacionesDTO.setConDescripcion((consignaciones.getConDescripcion() != null)
                ? consignaciones.getConDescripcion() : null);
            consignacionesDTO.setConFecha(consignaciones.getConFecha());
            consignacionesDTO.setConValor((consignaciones.getConValor() != null)
                ? consignaciones.getConValor() : null);
            consignacionesDTO.setUsuCedula((consignaciones.getUsuCedula() != null)
                ? consignaciones.getUsuCedula() : null);

            return consignacionesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Consignaciones consignacionesDTOToConsignaciones(
        ConsignacionesDTO consignacionesDTO) throws Exception {
        try {
            Consignaciones consignaciones = new Consignaciones();

            ConsignacionesId consignacionesId = new ConsignacionesId();

            if ((consignacionesDTO.getConCodigo() != null) &&
                    (consignacionesDTO.getConCodigo().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            consignacionesId.setConCodigo((consignacionesDTO.getConCodigo() != null)
                ? consignacionesDTO.getConCodigo() : null);

            if ((consignacionesDTO.getCueNumero() != null) &&
                    (consignacionesDTO.getCueNumero().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            consignacionesId.setCueNumero((consignacionesDTO.getCueNumero() != null)
                ? consignacionesDTO.getCueNumero() : null);
            consignaciones.setId(consignacionesId);
            consignaciones.setConDescripcion((consignacionesDTO.getConDescripcion() != null)
                ? consignacionesDTO.getConDescripcion() : null);
            consignaciones.setConFecha(consignacionesDTO.getConFecha());
            consignaciones.setConValor((consignacionesDTO.getConValor() != null)
                ? consignacionesDTO.getConValor() : null);
            consignaciones.setUsuCedula((consignacionesDTO.getUsuCedula() != null)
                ? consignacionesDTO.getUsuCedula() : null);

            return consignaciones;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ConsignacionesDTO> listConsignacionesToListConsignacionesDTO(
        List<Consignaciones> listConsignaciones) throws Exception {
        try {
            List<ConsignacionesDTO> consignacionesDTOs = new ArrayList<ConsignacionesDTO>();

            for (Consignaciones consignaciones : listConsignaciones) {
                ConsignacionesDTO consignacionesDTO = consignacionesToConsignacionesDTO(consignaciones);

                consignacionesDTOs.add(consignacionesDTO);
            }

            return consignacionesDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Consignaciones> listConsignacionesDTOToListConsignaciones(
        List<ConsignacionesDTO> listConsignacionesDTO)
        throws Exception {
        try {
            List<Consignaciones> listConsignaciones = new ArrayList<Consignaciones>();

            for (ConsignacionesDTO consignacionesDTO : listConsignacionesDTO) {
                Consignaciones consignaciones = consignacionesDTOToConsignaciones(consignacionesDTO);

                listConsignaciones.add(consignaciones);
            }

            return listConsignaciones;
        } catch (Exception e) {
            throw e;
        }
    }
}
