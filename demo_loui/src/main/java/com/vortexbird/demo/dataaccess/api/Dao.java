package com.vortexbird.demo.dataaccess.api;

import java.io.Serializable;

import java.util.List;


/**
 *
 * @author <a href="mailto:dgomez@vortexbird.com">Diego A Gomez</a>
 * @project zathuracode
 * @class Dao
 * @date Nov 26, 2016
 *
 */
public interface Dao<T, PK extends Serializable> {
    /**
    * Persiste la nueva entidad a la base de datos.
    *
    * @param newEntity
    * @throws DaoException
    */
    void save(T newEntity) throws DaoException;

    /**
     * Consulta una entidad previamente guardado en la base de datos.
     *
     * @param id
     * @return entity or null.
     */
    T findById(PK id);

    /**
     * Consulta una entidad de nuevo desde la base de datos.
     *
     * @param id
     * @return
     */
    T load(PK id);

    /**
     * Actualiza una entidad.
     *
     * @param entity
     * @throws DaoException
     */
    void update(T entity) throws DaoException;

    /**
     * Crea o actualiza una entidad.
     *
     * @param entity
     * @throws DaoException
     */
    void saveOrUpdate(T entity) throws DaoException;

    /**
     * Crea o actualiza una entidad con flush.
     *
     * @param entity
     * @throws DaoException
     */
    void saveOrUpdate(T entity, boolean flush) throws DaoException;

    /**
     * Merge de una entidad.
     *
     * @param entity
     * @throws DaoException
     */
    T merge(T entity) throws DaoException;

    /**
     * Elimina una entidad.
     *
     * @param entity
     * @throws DaoException
     */
    void delete(T entity) throws DaoException;

    /**
     * Elimina todas las entidades de una tabla.
     *
     * @throws DaoException
     */
    void deleteAll() throws DaoException;

    /**
     * Elimina los registros de una entidad con una value de una propiedad que pertenezca a la entidad.
     *
     * @param tableName
     * @param propertyName
     * @param value
     * @throws DaoException
     */
    void deleteByProperty(String tableName, String propertyName, Object value)
        throws DaoException;

    /**
     * Elimina una entidad con un id dado.
     *
     * @param id
     * @throws DaoException
     */
    void deleteById(PK id) throws DaoException;

    /**
     * Busca un objeto por una propiedad con valor de tipo string. Este metodo es util para buscar por columnas que
     * poseen valores unicos.
     *
     * @param propertyName
     * @param value
     * @return
     */
    List<T> findByProperty(String propertyName, Object value);

    /**
     * Execute a named query.
     * <p>
     * A named query is defined in a Hibernate mapping file.
     *
     * @param queryName
     *            the name of a Hibernate query in a mapping file
     * @return a {@link List} containing the results of the query execution
     *
     */
    List<T> find(String queryString);

    /**
     * Execute a named query, binding one value to a "?" parameter in the query string.
     * <p>
     * A named query is defined in a Hibernate mapping file.
     *
     * @param queryName
     *            the name of a Hibernate query in a mapping file
     * @param value
     *            the value of the parameter
     * @return a {@link List} containing the results of the query execution
     *
     */
    List<T> find(String queryString, Object value);

    /**
     * Execute a named query binding a number of values to "?" parameters in the query string.
     * <p>
     * A named query is defined in a Hibernate mapping file.
     *
     * @param queryName
     *            the name of a Hibernate query in a mapping file
     * @param values
     *            the values of the parameters
     * @return a {@link List} containing the results of the query execution
     *
     */
    List<T> find(String queryString, Object... values);

    /**
     * Execute an HQL query, binding one value to a ":" named parameter in the query string.
     *
     * @param queryString
     *            a query expressed in Hibernate's query language
     * @param paramName
     *            the name of the parameter
     * @param value
     *            the value of the parameter
     * @return a {@link List} containing the results of the query execution
     *
     */
    List<T> findByNamedParam(String queryString, String paramName, Object value);

    /**
     * Execute an HQL query, binding a number of values to ":" named parameters in the query string.
     *
     * @param queryString
     *            a query expressed in Hibernate's query language
     * @param paramNames
     *            the names of the parameters
     * @param values
     *            the values of the parameters
     * @return a {@link List} containing the results of the query execution
     *
     */
    List<T> findByNamedParam(String queryString, String[] paramNames,
        Object[] values);

    /**
     * Devuelve la cantidad de registros.
     *
     * @return Long
     */
    Long count();

    /**
     * Consulta todas las entidades
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param sortColumnName
     * @param sortAscending
     * @param startRow
     * @param maxResults
     * @return
     */
    public List<T> findPage(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults);

    /**
     *
     * @param whereCondition
     * @return
     */
    public List<T> findByCriteria(String whereCondition);
}
