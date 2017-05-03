package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.modelo.TiposDocumentos;
import com.vortexbird.demo.modelo.dto.TiposDocumentosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITiposDocumentosMapper {
    public TiposDocumentosDTO tiposDocumentosToTiposDocumentosDTO(
        TiposDocumentos tiposDocumentos) throws Exception;

    public TiposDocumentos tiposDocumentosDTOToTiposDocumentos(
        TiposDocumentosDTO tiposDocumentosDTO) throws Exception;

    public List<TiposDocumentosDTO> listTiposDocumentosToListTiposDocumentosDTO(
        List<TiposDocumentos> tiposDocumentoss) throws Exception;

    public List<TiposDocumentos> listTiposDocumentosDTOToListTiposDocumentos(
        List<TiposDocumentosDTO> tiposDocumentosDTOs) throws Exception;
}
