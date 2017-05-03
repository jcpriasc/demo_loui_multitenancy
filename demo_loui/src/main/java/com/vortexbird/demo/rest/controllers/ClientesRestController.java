package com.vortexbird.demo.rest.controllers;

import com.vortexbird.demo.dto.mapper.IClientesMapper;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.ClientesDTO;
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
@RequestMapping("/clientes")
public class ClientesRestController {
    private static final Logger log = LoggerFactory.getLogger(ClientesRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IClientesMapper clientesMapper;

    @PutMapping(value = "/saveClientes")
    public void saveClientes(@RequestBody
    ClientesDTO clientesDTO) throws Exception {
        try {
            Clientes entity = clientesMapper.clientesDTOToClientes(clientesDTO);

            businessDelegatorView.saveClientes(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteClientes/{id}")
    public void deleteClientes(@PathVariable("id")
    ClientesDTO clientesDTO) throws Exception {
        try {
            Clientes entity = clientesMapper.clientesDTOToClientes(clientesDTO);

            businessDelegatorView.deleteClientes(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateClientes/")
    public void updateClientes(@RequestBody
    ClientesDTO clientesDTO) throws Exception {
        try {
            Clientes entity = clientesMapper.clientesDTOToClientes(clientesDTO);

            businessDelegatorView.updateClientes(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping(value = "/getDataClientes")
    public List<ClientesDTO> getDataClientes() throws Exception {
        try {
            return businessDelegatorView.getDataClientes();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getClientes/{id}")
    public ClientesDTO getClientes(@PathVariable("id")
    Long cliId) throws Exception {
        try {
            Clientes clientes = businessDelegatorView.getClientes(cliId);

            return clientesMapper.clientesToClientesDTO(clientes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
