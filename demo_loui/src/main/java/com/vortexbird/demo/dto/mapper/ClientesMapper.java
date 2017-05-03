package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.Clientes;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.ClientesDTO;
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
public class ClientesMapper implements IClientesMapper {
    private static final Logger log = LoggerFactory.getLogger(ClientesMapper.class);

    @Transactional(readOnly = true)
    public ClientesDTO clientesToClientesDTO(Clientes clientes)
        throws Exception {
        try {
            ClientesDTO clientesDTO = new ClientesDTO();

            clientesDTO.setCliId(clientes.getCliId());
            clientesDTO.setCliDireccion((clientes.getCliDireccion() != null)
                ? clientes.getCliDireccion() : null);
            clientesDTO.setCliMail((clientes.getCliMail() != null)
                ? clientes.getCliMail() : null);
            clientesDTO.setCliNombre((clientes.getCliNombre() != null)
                ? clientes.getCliNombre() : null);
            clientesDTO.setCliTelefono((clientes.getCliTelefono() != null)
                ? clientes.getCliTelefono() : null);
            clientesDTO.setTdocCodigo((clientes.getTdocCodigo() != null)
                ? clientes.getTdocCodigo() : null);

            return clientesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Clientes clientesDTOToClientes(ClientesDTO clientesDTO)
        throws Exception {
        try {
            Clientes clientes = new Clientes();

            clientes.setCliId(clientesDTO.getCliId());
            clientes.setCliDireccion((clientesDTO.getCliDireccion() != null)
                ? clientesDTO.getCliDireccion() : null);
            clientes.setCliMail((clientesDTO.getCliMail() != null)
                ? clientesDTO.getCliMail() : null);
            clientes.setCliNombre((clientesDTO.getCliNombre() != null)
                ? clientesDTO.getCliNombre() : null);
            clientes.setCliTelefono((clientesDTO.getCliTelefono() != null)
                ? clientesDTO.getCliTelefono() : null);
            clientes.setTdocCodigo((clientesDTO.getTdocCodigo() != null)
                ? clientesDTO.getTdocCodigo() : null);

            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ClientesDTO> listClientesToListClientesDTO(
        List<Clientes> listClientes) throws Exception {
        try {
            List<ClientesDTO> clientesDTOs = new ArrayList<ClientesDTO>();

            for (Clientes clientes : listClientes) {
                ClientesDTO clientesDTO = clientesToClientesDTO(clientes);

                clientesDTOs.add(clientesDTO);
            }

            return clientesDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Clientes> listClientesDTOToListClientes(
        List<ClientesDTO> listClientesDTO) throws Exception {
        try {
            List<Clientes> listClientes = new ArrayList<Clientes>();

            for (ClientesDTO clientesDTO : listClientesDTO) {
                Clientes clientes = clientesDTOToClientes(clientesDTO);

                listClientes.add(clientes);
            }

            return listClientes;
        } catch (Exception e) {
            throw e;
        }
    }
}
