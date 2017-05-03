package com.vortexbird.demo.dto.mapper;

import com.vortexbird.demo.modelo.Retiros;
import com.vortexbird.demo.modelo.RetirosId;
import com.vortexbird.demo.modelo.dto.RetirosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IRetirosMapper {
    public RetirosDTO retirosToRetirosDTO(Retiros retiros)
        throws Exception;

    public Retiros retirosDTOToRetiros(RetirosDTO retirosDTO)
        throws Exception;

    public List<RetirosDTO> listRetirosToListRetirosDTO(List<Retiros> retiross)
        throws Exception;

    public List<Retiros> listRetirosDTOToListRetiros(
        List<RetirosDTO> retirosDTOs) throws Exception;
}
