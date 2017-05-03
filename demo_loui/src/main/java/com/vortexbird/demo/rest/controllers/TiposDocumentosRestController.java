package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.ITiposDocumentosMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.TiposDocumentosDTO;
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
@RequestMapping("/tiposDocumentos")
public class TiposDocumentosRestController {
    private static final Logger log = LoggerFactory.getLogger(TiposDocumentosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITiposDocumentosMapper tiposDocumentosMapper;

    @PutMapping(value = "/saveTiposDocumentos")
    public void saveTiposDocumentos(
        @RequestBody
    TiposDocumentosDTO tiposDocumentosDTO) throws Exception {
        try {
            TiposDocumentos entity = tiposDocumentosMapper.tiposDocumentosDTOToTiposDocumentos(tiposDocumentosDTO);

            businessDelegatorView.saveTiposDocumentos(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTiposDocumentos/{id}")
    public void deleteTiposDocumentos(
        @PathVariable("id")
    TiposDocumentosDTO tiposDocumentosDTO) throws Exception {
        try {
            TiposDocumentos entity = tiposDocumentosMapper.tiposDocumentosDTOToTiposDocumentos(tiposDocumentosDTO);

            businessDelegatorView.deleteTiposDocumentos(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTiposDocumentos/")
    public void updateTiposDocumentos(
        @RequestBody
    TiposDocumentosDTO tiposDocumentosDTO) throws Exception {
        try {
            TiposDocumentos entity = tiposDocumentosMapper.tiposDocumentosDTOToTiposDocumentos(tiposDocumentosDTO);

            businessDelegatorView.updateTiposDocumentos(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataTiposDocumentos")
    public List<TiposDocumentosDTO> getDataTiposDocumentos()
        throws Exception {
        try {
            return businessDelegatorView.getDataTiposDocumentos();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTiposDocumentos/{id}")
    public TiposDocumentosDTO getTiposDocumentos(
        @PathVariable("id")
    Long tdocCodigo) throws Exception {
        try {
            TiposDocumentos tiposDocumentos = businessDelegatorView.getTiposDocumentos(tdocCodigo);

            return tiposDocumentosMapper.tiposDocumentosToTiposDocumentosDTO(tiposDocumentos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
