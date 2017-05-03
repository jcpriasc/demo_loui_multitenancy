package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.TiposUsuarios;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.TiposUsuariosDTO;
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
public class TiposUsuariosMapper implements ITiposUsuariosMapper {
    private static final Logger log = LoggerFactory.getLogger(TiposUsuariosMapper.class);

    @Transactional(readOnly = true)
    public TiposUsuariosDTO tiposUsuariosToTiposUsuariosDTO(
        TiposUsuarios tiposUsuarios) throws Exception {
        try {
            TiposUsuariosDTO tiposUsuariosDTO = new TiposUsuariosDTO();

            tiposUsuariosDTO.setTusuCodigo(tiposUsuarios.getTusuCodigo());
            tiposUsuariosDTO.setTusuNombre((tiposUsuarios.getTusuNombre() != null)
                ? tiposUsuarios.getTusuNombre() : null);

            return tiposUsuariosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TiposUsuarios tiposUsuariosDTOToTiposUsuarios(
        TiposUsuariosDTO tiposUsuariosDTO) throws Exception {
        try {
            TiposUsuarios tiposUsuarios = new TiposUsuarios();

            tiposUsuarios.setTusuCodigo(tiposUsuariosDTO.getTusuCodigo());
            tiposUsuarios.setTusuNombre((tiposUsuariosDTO.getTusuNombre() != null)
                ? tiposUsuariosDTO.getTusuNombre() : null);

            return tiposUsuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TiposUsuariosDTO> listTiposUsuariosToListTiposUsuariosDTO(
        List<TiposUsuarios> listTiposUsuarios) throws Exception {
        try {
            List<TiposUsuariosDTO> tiposUsuariosDTOs = new ArrayList<TiposUsuariosDTO>();

            for (TiposUsuarios tiposUsuarios : listTiposUsuarios) {
                TiposUsuariosDTO tiposUsuariosDTO = tiposUsuariosToTiposUsuariosDTO(tiposUsuarios);

                tiposUsuariosDTOs.add(tiposUsuariosDTO);
            }

            return tiposUsuariosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TiposUsuarios> listTiposUsuariosDTOToListTiposUsuarios(
        List<TiposUsuariosDTO> listTiposUsuariosDTO) throws Exception {
        try {
            List<TiposUsuarios> listTiposUsuarios = new ArrayList<TiposUsuarios>();

            for (TiposUsuariosDTO tiposUsuariosDTO : listTiposUsuariosDTO) {
                TiposUsuarios tiposUsuarios = tiposUsuariosDTOToTiposUsuarios(tiposUsuariosDTO);

                listTiposUsuarios.add(tiposUsuarios);
            }

            return listTiposUsuarios;
        } catch (Exception e) {
            throw e;
        }
    }
}
