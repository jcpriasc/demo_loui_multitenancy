package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.IRetirosMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.RetirosDTO;
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
@RequestMapping("/retiros")
public class RetirosRestController {
    private static final Logger log = LoggerFactory.getLogger(RetirosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IRetirosMapper retirosMapper;

    @PutMapping(value = "/saveRetiros")
    public void saveRetiros(@RequestBody
    RetirosDTO retirosDTO) throws Exception {
        try {
            Retiros entity = retirosMapper.retirosDTOToRetiros(retirosDTO);

            businessDelegatorView.saveRetiros(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRetiros/{id}")
    public void deleteRetiros(@PathVariable("id")
    RetirosDTO retirosDTO) throws Exception {
        try {
            Retiros entity = retirosMapper.retirosDTOToRetiros(retirosDTO);

            businessDelegatorView.deleteRetiros(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRetiros/")
    public void updateRetiros(@RequestBody
    RetirosDTO retirosDTO) throws Exception {
        try {
            Retiros entity = retirosMapper.retirosDTOToRetiros(retirosDTO);

            businessDelegatorView.updateRetiros(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataRetiros")
    public List<RetirosDTO> getDataRetiros() throws Exception {
        try {
            return businessDelegatorView.getDataRetiros();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRetiros/{id}")
    public RetirosDTO getRetiros(@PathVariable("id")
    RetirosId id) throws Exception {
        try {
            Retiros retiros = businessDelegatorView.getRetiros(id);

            return retirosMapper.retirosToRetirosDTO(retiros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
