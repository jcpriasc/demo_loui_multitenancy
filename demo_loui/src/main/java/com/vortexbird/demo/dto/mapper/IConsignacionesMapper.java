package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.modelo.Consignaciones;
import com.vortexbird.demo.modelo.ConsignacionesId;
import com.vortexbird.demo.modelo.dto.ConsignacionesDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IConsignacionesMapper {
    public ConsignacionesDTO consignacionesToConsignacionesDTO(
        Consignaciones consignaciones) throws Exception;

    public Consignaciones consignacionesDTOToConsignaciones(
        ConsignacionesDTO consignacionesDTO) throws Exception;

    public List<ConsignacionesDTO> listConsignacionesToListConsignacionesDTO(
        List<Consignaciones> consignacioness) throws Exception;

    public List<Consignaciones> listConsignacionesDTOToListConsignaciones(
        List<ConsignacionesDTO> consignacionesDTOs) throws Exception;
}
