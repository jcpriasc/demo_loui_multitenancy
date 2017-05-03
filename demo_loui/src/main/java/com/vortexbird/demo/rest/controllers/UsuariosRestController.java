package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.IUsuariosMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.UsuariosDTO;
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
@RequestMapping("/usuarios")
public class UsuariosRestController {
    private static final Logger log = LoggerFactory.getLogger(UsuariosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IUsuariosMapper usuariosMapper;

    @PutMapping(value = "/saveUsuarios")
    public void saveUsuarios(@RequestBody
    UsuariosDTO usuariosDTO) throws Exception {
        try {
            Usuarios entity = usuariosMapper.usuariosDTOToUsuarios(usuariosDTO);

            businessDelegatorView.saveUsuarios(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteUsuarios/{id}")
    public void deleteUsuarios(@PathVariable("id")
    UsuariosDTO usuariosDTO) throws Exception {
        try {
            Usuarios entity = usuariosMapper.usuariosDTOToUsuarios(usuariosDTO);

            businessDelegatorView.deleteUsuarios(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateUsuarios/")
    public void updateUsuarios(@RequestBody
    UsuariosDTO usuariosDTO) throws Exception {
        try {
            Usuarios entity = usuariosMapper.usuariosDTOToUsuarios(usuariosDTO);

            businessDelegatorView.updateUsuarios(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataUsuarios")
    public List<UsuariosDTO> getDataUsuarios() throws Exception {
        try {
            return businessDelegatorView.getDataUsuarios();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getUsuarios/{id}")
    public UsuariosDTO getUsuarios(@PathVariable("id")
    Long usuCedula) throws Exception {
        try {
            Usuarios usuarios = businessDelegatorView.getUsuarios(usuCedula);

            return usuariosMapper.usuariosToUsuariosDTO(usuarios);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
