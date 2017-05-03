package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.IConsignacionesMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.ConsignacionesDTO;
import com.vortexbird.demo.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.faces.bean.ManagedProperty;


@RestController
@RequestMapping("/consignaciones")
public class ConsignacionesRestController {
    private static final Logger log = LoggerFactory.getLogger(ConsignacionesRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IConsignacionesMapper consignacionesMapper;

    @PutMapping(value = "/saveConsignaciones")
    public void saveConsignaciones(
        @RequestBody
    ConsignacionesDTO consignacionesDTO) throws Exception {
        try {
            Consignaciones entity = consignacionesMapper.consignacionesDTOToConsignaciones(consignacionesDTO);

            businessDelegatorView.saveConsignaciones(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteConsignaciones/{id}")
    public void deleteConsignaciones(
        @PathVariable("id")
    ConsignacionesDTO consignacionesDTO) throws Exception {
        try {
            Consignaciones entity = consignacionesMapper.consignacionesDTOToConsignaciones(consignacionesDTO);

            businessDelegatorView.deleteConsignaciones(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateConsignaciones/")
    public void updateConsignaciones(
        @RequestBody
    ConsignacionesDTO consignacionesDTO) throws Exception {
        try {
            Consignaciones entity = consignacionesMapper.consignacionesDTOToConsignaciones(consignacionesDTO);

            businessDelegatorView.updateConsignaciones(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataConsignaciones")
    public List<ConsignacionesDTO> getDataConsignaciones()
        throws Exception {
        try {
            return businessDelegatorView.getDataConsignaciones();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getConsignaciones/{id}")
    public ConsignacionesDTO getConsignaciones(
        @PathVariable("id")
    ConsignacionesId id) throws Exception {
        try {
            Consignaciones consignaciones = businessDelegatorView.getConsignaciones(id);

            return consignacionesMapper.consignacionesToConsignacionesDTO(consignaciones);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
