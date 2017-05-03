package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.modelo.TiposUsuarios;
import com.vortexbird.demo.modelo.dto.TiposUsuariosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITiposUsuariosMapper {
    public TiposUsuariosDTO tiposUsuariosToTiposUsuariosDTO(
        TiposUsuarios tiposUsuarios) throws Exception;

    public TiposUsuarios tiposUsuariosDTOToTiposUsuarios(
        TiposUsuariosDTO tiposUsuariosDTO) throws Exception;

    public List<TiposUsuariosDTO> listTiposUsuariosToListTiposUsuariosDTO(
        List<TiposUsuarios> tiposUsuarioss) throws Exception;

    public List<TiposUsuarios> listTiposUsuariosDTOToListTiposUsuarios(
        List<TiposUsuariosDTO> tiposUsuariosDTOs) throws Exception;
}
