package com.vortexbird.demo.modelo.control;

import com.vortexbird.demo.dataaccess.dao.*;
import com.vortexbird.demo.dto.mapper.IRetirosMapper;
import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.RetirosDTO;
import com.vortexbird.demo.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("RetirosLogic")
public class RetirosLogic implements IRetirosLogic {
    private static final Logger log = LoggerFactory.getLogger(RetirosLogic.class);

    /**
     * DAO injected by Spring that manages Retiros entities
     *
     */
    @Autowired
    private IRetirosDAO retirosDAO;
    @Autowired
    private IRetirosMapper retirosMapper;
    @Autowired
    private Validator validator;

    public void validateRetiros(Retiros retiros) throws Exception {
        try {
            Set<ConstraintViolation<Retiros>> constraintViolations = validator.validate(retiros);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Retiros> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Retiros> getRetiros() throws Exception {
        log.debug("finding all Retiros instances");

        List<Retiros> list = new ArrayList<Retiros>();

        try {
            list = retirosDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Retiros failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Retiros");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveRetiros(Retiros entity) throws Exception {
        log.debug("saving Retiros instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Retiros");
            }

            validateRetiros(entity);

            if (getRetiros(entity.getId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            retirosDAO.save(entity);

            log.debug("save Retiros successful");
        } catch (Exception e) {
            log.error("save Retiros failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteRetiros(Retiros entity) throws Exception {
        log.debug("deleting Retiros instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Retiros");
        }

        if (entity.getId().getRetCodigo() == null) {
            throw new ZMessManager().new EmptyFieldException("retCodigo");
        }

        if (entity.getId().getCueNumero() == null) {
            throw new ZMessManager().new EmptyFieldException("cueNumero");
        }

        try {
            retirosDAO.delete(entity);

            log.debug("delete Retiros successful");
        } catch (Exception e) {
            log.error("delete Retiros failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateRetiros(Retiros entity) throws Exception {
        log.debug("updating Retiros instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Retiros");
            }

            validateRetiros(entity);

            retirosDAO.update(entity);

            log.debug("update Retiros successful");
        } catch (Exception e) {
            log.error("update Retiros failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<RetirosDTO> getDataRetiros() throws Exception {
        try {
            List<Retiros> retiros = retirosDAO.findAll();

            List<RetirosDTO> retirosDTO = new ArrayList<RetirosDTO>();

            for (Retiros retirosTmp : retiros) {
                RetirosDTO retirosDTO2 = retirosMapper.retirosToRetirosDTO(retirosTmp);
                retirosDTO.add(retirosDTO2);
            }

            return retirosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Retiros getRetiros(RetirosId id) throws Exception {
        log.debug("getting Retiros instance");

        Retiros entity = null;

        try {
            entity = retirosDAO.findById(id);
        } catch (Exception e) {
            log.error("get Retiros failed", e);
            throw new ZMessManager().new FindingException("Retiros");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Retiros> findPageRetiros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Retiros> entity = null;

        try {
            entity = retirosDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Retiros Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberRetiros() throws Exception {
        Long entity = null;

        try {
            entity = retirosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Retiros Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Retiros> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Retiros> list = new ArrayList<Retiros>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = retirosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
