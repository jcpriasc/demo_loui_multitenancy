package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.TiposDocumentos;
import com.vortexbird.demo.modelo.control.*;
import com.vortexbird.demo.modelo.dto.TiposDocumentosDTO;
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
public class TiposDocumentosMapper implements ITiposDocumentosMapper {
    private static final Logger log = LoggerFactory.getLogger(TiposDocumentosMapper.class);

    @Transactional(readOnly = true)
    public TiposDocumentosDTO tiposDocumentosToTiposDocumentosDTO(
        TiposDocumentos tiposDocumentos) throws Exception {
        try {
            TiposDocumentosDTO tiposDocumentosDTO = new TiposDocumentosDTO();

            tiposDocumentosDTO.setTdocCodigo(tiposDocumentos.getTdocCodigo());
            tiposDocumentosDTO.setTdocNombre((tiposDocumentos.getTdocNombre() != null)
                ? tiposDocumentos.getTdocNombre() : null);

            return tiposDocumentosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TiposDocumentos tiposDocumentosDTOToTiposDocumentos(
        TiposDocumentosDTO tiposDocumentosDTO) throws Exception {
        try {
            TiposDocumentos tiposDocumentos = new TiposDocumentos();

            tiposDocumentos.setTdocCodigo(tiposDocumentosDTO.getTdocCodigo());
            tiposDocumentos.setTdocNombre((tiposDocumentosDTO.getTdocNombre() != null)
                ? tiposDocumentosDTO.getTdocNombre() : null);

            return tiposDocumentos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TiposDocumentosDTO> listTiposDocumentosToListTiposDocumentosDTO(
        List<TiposDocumentos> listTiposDocumentos) throws Exception {
        try {
            List<TiposDocumentosDTO> tiposDocumentosDTOs = new ArrayList<TiposDocumentosDTO>();

            for (TiposDocumentos tiposDocumentos : listTiposDocumentos) {
                TiposDocumentosDTO tiposDocumentosDTO = tiposDocumentosToTiposDocumentosDTO(tiposDocumentos);

                tiposDocumentosDTOs.add(tiposDocumentosDTO);
            }

            return tiposDocumentosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TiposDocumentos> listTiposDocumentosDTOToListTiposDocumentos(
        List<TiposDocumentosDTO> listTiposDocumentosDTO)
        throws Exception {
        try {
            List<TiposDocumentos> listTiposDocumentos = new ArrayList<TiposDocumentos>();

            for (TiposDocumentosDTO tiposDocumentosDTO : listTiposDocumentosDTO) {
                TiposDocumentos tiposDocumentos = tiposDocumentosDTOToTiposDocumentos(tiposDocumentosDTO);

                listTiposDocumentos.add(tiposDocumentos);
            }

            return listTiposDocumentos;
        } catch (Exception e) {
            throw e;
        }
    }
}
