package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.Usuarios;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.UsuariosDTO;
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
public class UsuariosMapper implements IUsuariosMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuariosMapper.class);

    @Transactional(readOnly = true)
    public UsuariosDTO usuariosToUsuariosDTO(Usuarios usuarios)
        throws Exception {
        try {
            UsuariosDTO usuariosDTO = new UsuariosDTO();

            usuariosDTO.setUsuCedula(usuarios.getUsuCedula());
            usuariosDTO.setTusuCodigo((usuarios.getTusuCodigo() != null)
                ? usuarios.getTusuCodigo() : null);
            usuariosDTO.setUsuClave((usuarios.getUsuClave() != null)
                ? usuarios.getUsuClave() : null);
            usuariosDTO.setUsuLogin((usuarios.getUsuLogin() != null)
                ? usuarios.getUsuLogin() : null);
            usuariosDTO.setUsuNombre((usuarios.getUsuNombre() != null)
                ? usuarios.getUsuNombre() : null);

            return usuariosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuarios usuariosDTOToUsuarios(UsuariosDTO usuariosDTO)
        throws Exception {
        try {
            Usuarios usuarios = new Usuarios();

            usuarios.setUsuCedula(usuariosDTO.getUsuCedula());
            usuarios.setTusuCodigo((usuariosDTO.getTusuCodigo() != null)
                ? usuariosDTO.getTusuCodigo() : null);
            usuarios.setUsuClave((usuariosDTO.getUsuClave() != null)
                ? usuariosDTO.getUsuClave() : null);
            usuarios.setUsuLogin((usuariosDTO.getUsuLogin() != null)
                ? usuariosDTO.getUsuLogin() : null);
            usuarios.setUsuNombre((usuariosDTO.getUsuNombre() != null)
                ? usuariosDTO.getUsuNombre() : null);

            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuariosDTO> listUsuariosToListUsuariosDTO(
        List<Usuarios> listUsuarios) throws Exception {
        try {
            List<UsuariosDTO> usuariosDTOs = new ArrayList<UsuariosDTO>();

            for (Usuarios usuarios : listUsuarios) {
                UsuariosDTO usuariosDTO = usuariosToUsuariosDTO(usuarios);

                usuariosDTOs.add(usuariosDTO);
            }

            return usuariosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuarios> listUsuariosDTOToListUsuarios(
        List<UsuariosDTO> listUsuariosDTO) throws Exception {
        try {
            List<Usuarios> listUsuarios = new ArrayList<Usuarios>();

            for (UsuariosDTO usuariosDTO : listUsuariosDTO) {
                Usuarios usuarios = usuariosDTOToUsuarios(usuariosDTO);

                listUsuarios.add(usuarios);
            }

            return listUsuarios;
        } catch (Exception e) {
            throw e;
        }
    }
}
