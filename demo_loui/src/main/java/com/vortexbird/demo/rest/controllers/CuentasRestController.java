package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.ICuentasMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.CuentasDTO;
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
@RequestMapping("/cuentas")
public class CuentasRestController {
    private static final Logger log = LoggerFactory.getLogger(CuentasRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICuentasMapper cuentasMapper;

    @PutMapping(value = "/saveCuentas")
    public void saveCuentas(@RequestBody
    CuentasDTO cuentasDTO) throws Exception {
        try {
            Cuentas entity = cuentasMapper.cuentasDTOToCuentas(cuentasDTO);

            businessDelegatorView.saveCuentas(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCuentas/{id}")
    public void deleteCuentas(@PathVariable("id")
    CuentasDTO cuentasDTO) throws Exception {
        try {
            Cuentas entity = cuentasMapper.cuentasDTOToCuentas(cuentasDTO);

            businessDelegatorView.deleteCuentas(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCuentas/")
    public void updateCuentas(@RequestBody
    CuentasDTO cuentasDTO) throws Exception {
        try {
            Cuentas entity = cuentasMapper.cuentasDTOToCuentas(cuentasDTO);

            businessDelegatorView.updateCuentas(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataCuentas")
    public List<CuentasDTO> getDataCuentas() throws Exception {
        try {
            return businessDelegatorView.getDataCuentas();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCuentas/{id}")
    public CuentasDTO getCuentas(@PathVariable("id")
    String cueNumero) throws Exception {
        try {
            Cuentas cuentas = businessDelegatorView.getCuentas(cueNumero);

            return cuentasMapper.cuentasToCuentasDTO(cuentas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
