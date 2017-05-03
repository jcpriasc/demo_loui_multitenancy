package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.ITiposUsuariosMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.TiposUsuariosDTO;
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
@RequestMapping("/tiposUsuarios")
public class TiposUsuariosRestController {
    private static final Logger log = LoggerFactory.getLogger(TiposUsuariosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITiposUsuariosMapper tiposUsuariosMapper;

    @PutMapping(value = "/saveTiposUsuarios")
    public void saveTiposUsuarios(@RequestBody
    TiposUsuariosDTO tiposUsuariosDTO) throws Exception {
        try {
            TiposUsuarios entity = tiposUsuariosMapper.tiposUsuariosDTOToTiposUsuarios(tiposUsuariosDTO);

            businessDelegatorView.saveTiposUsuarios(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTiposUsuarios/{id}")
    public void deleteTiposUsuarios(
        @PathVariable("id")
    TiposUsuariosDTO tiposUsuariosDTO) throws Exception {
        try {
            TiposUsuarios entity = tiposUsuariosMapper.tiposUsuariosDTOToTiposUsuarios(tiposUsuariosDTO);

            businessDelegatorView.deleteTiposUsuarios(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTiposUsuarios/")
    public void updateTiposUsuarios(
        @RequestBody
    TiposUsuariosDTO tiposUsuariosDTO) throws Exception {
        try {
            TiposUsuarios entity = tiposUsuariosMapper.tiposUsuariosDTOToTiposUsuarios(tiposUsuariosDTO);

            businessDelegatorView.updateTiposUsuarios(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataTiposUsuarios")
    public List<TiposUsuariosDTO> getDataTiposUsuarios()
        throws Exception {
        try {
            return businessDelegatorView.getDataTiposUsuarios();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTiposUsuarios/{id}")
    public TiposUsuariosDTO getTiposUsuarios(@PathVariable("id")
    Long tusuCodigo) throws Exception {
        try {
            TiposUsuarios tiposUsuarios = businessDelegatorView.getTiposUsuarios(tusuCodigo);

            return tiposUsuariosMapper.tiposUsuariosToTiposUsuariosDTO(tiposUsuarios);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
